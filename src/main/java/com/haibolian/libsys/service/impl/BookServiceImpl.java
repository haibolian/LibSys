package com.haibolian.libsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haibolian.libsys.Mapper.BookMapper;
import com.haibolian.libsys.common.Result;
import com.haibolian.libsys.dto.BookQuery;
import com.haibolian.libsys.entity.Book;
import com.haibolian.libsys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;
    public boolean add(Book book){
        boolean exists = this.lambdaQuery().eq(Book::getIsbn, book.getIsbn()).exists();
        if(exists) {
            throw new IllegalArgumentException("ISBN已存在");
        }
        book.setCreateTime(LocalDateTime.now());
        book.setUpdateTime(LocalDateTime.now());
        return bookMapper.insert(book) > 0;
    }

    public List<Book> search(BookQuery query) {
        return this.lambdaQuery().like(StringUtils.hasText(query.getName()), Book::getName, query.getName())
                .like(StringUtils.hasText(query.getAuthor()), Book::getAuthor, query.getAuthor())
                .like(StringUtils.hasText(query.getIsbn()), Book::getIsbn, query.getIsbn())
                .list();
    }

    public boolean update(Book book) {
        return this.updateById(book);
    }

    public boolean delete(Long id) {
        boolean exists = this.lambdaQuery().eq(Book::getId, id).exists();
        if(!exists) throw new IllegalArgumentException("id不存在");
        return this.removeById(id);
    }
}

package com.haibolian.libsys.controller;

import com.haibolian.libsys.common.Result;
import com.haibolian.libsys.dto.BookQuery;
import com.haibolian.libsys.entity.Book;
import com.haibolian.libsys.service.BookService;
import com.haibolian.libsys.service.impl.BookServiceImpl;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping
    public Result<List<Book>> search(BookQuery query){
        List<Book> list = bookService.search(query);
        return Result.success(list);
    }

    @PostMapping
    public Result<Boolean> add(@Validated @RequestBody Book book) {
        if(bookService.add(book)){
            return Result.success(true);
        }else {
            return Result.failed();
        }
    }

    @PutMapping
    public Result<Boolean> update(@Validated @RequestBody Book book){
        boolean isSuccess = bookService.update(book);
        return Result.infer(isSuccess, true, "更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        boolean isSuccess = bookService.delete(id);
        if(isSuccess) {
            return Result.success(true);
        }else {
            return Result.failed("删除失败");
        }
    }

}

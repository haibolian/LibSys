package com.haibolian.libsys.service;

import com.haibolian.libsys.common.Result;
import com.haibolian.libsys.dto.BookQuery;
import com.haibolian.libsys.entity.Book;

import java.util.List;

public interface BookService {
    boolean add(Book book);

    List<Book> search(BookQuery query);


}

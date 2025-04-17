package com.haibolian.libsys.controller;

import com.haibolian.libsys.common.Result;
import com.haibolian.libsys.dto.BookQuery;
import com.haibolian.libsys.entity.Book;
import com.haibolian.libsys.service.BookService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Result<List<Book>> search(BookQuery query){
        List<Book> list = bookService.search(query);
        return Result.success(list);
    }

    @PostMapping
    public Result add(@Validated @RequestBody Book book) {
        if(bookService.add(book)){
            return Result.success();
        }else {
            return Result.failed();
        }
    }

    @DeleteMapping
    public Result delete(@PathVariable Long id) {
        return Result.failed();
    }

}

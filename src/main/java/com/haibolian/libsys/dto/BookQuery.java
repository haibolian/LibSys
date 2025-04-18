package com.haibolian.libsys.dto;

import lombok.Data;

@Data
public class BookQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    private String name;
    private String author;
    private String isbn;
}

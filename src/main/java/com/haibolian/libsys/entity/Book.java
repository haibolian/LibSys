package com.haibolian.libsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("book")
public class Book {

    @TableId(type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "图书名称不能为空")
    private String name;

    @NotBlank(message = "作者不能为空")
    private String author;

    @NotBlank(message = "ISBN不能为空")
    private String isbn;

    private String category;

    private String publisher;

    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @NotNull(message = "库存不能为空")
    private Integer stock;

    private LocalDate publishDate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}

package com.haibolian.libsys.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haibolian.libsys.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}

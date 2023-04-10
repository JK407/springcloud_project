package com.example.userprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.b2b.commonmodule.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}

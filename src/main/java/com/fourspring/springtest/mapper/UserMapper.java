package com.fourspring.springtest.mapper;

import com.fourspring.springtest.data.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    @Select("select * from User")
    List<User> getUsers();

    @Select("select * from User where uid=#{id}")
    User getUser(Integer id);
}

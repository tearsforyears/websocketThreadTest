package com.fourspring.springtest.data;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @author zhanghaoyang
 */
@Data
@Repository
public class User {

    Integer uid;
    String username;
    String password;
}

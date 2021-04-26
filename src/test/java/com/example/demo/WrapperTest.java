package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper userMapper;

    /**
     * 等值查找
     */
    @Test
    public void selectTest(){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","JOJO");

        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /**
     * 不为空
     */
    @Test
    public void selectUsers(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("create_time").
        isNotNull("update_time");

        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * 区间查找
     */
    @Test
    public void selectTest2(){
        QueryWrapper<User> w = new QueryWrapper<>();
        w.between("age",18,50);
        userMapper.selectList(w).forEach(System.out::println);
    }

    /**
     * 计数
     */
    @Test
    public void selectCount(){
        QueryWrapper<User> w = new QueryWrapper<>();
        w.eq("name","张飞");
        Integer integer = userMapper.selectCount(w);
        System.out.println(integer);
    }

    /**
     * 模糊查询
     */
    @Test
    public void selectTest3(){
        QueryWrapper<User> w = new QueryWrapper<>();
        w.notLike("name","张")
        .likeRight("name","马");

        userMapper.selectMaps(w).forEach(System.out::println);
    }
}

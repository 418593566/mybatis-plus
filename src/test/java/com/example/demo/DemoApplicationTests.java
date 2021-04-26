package com.example.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> list = userMapper.selectList(null);

        list.forEach(System.out::println);
    }


    @Test
    public void inserTest(){
        User user = new User();

        user.setName("JOJO");
        user.setAge(36);
        user.setEmail("418593566@qq.com");

        int insert = userMapper.insert(user);

        System.out.println(insert);

        System.err.println(user);
    }

    @Test
    public void updateTest(){
        User user = new User();
        user.setId(6l);
        user.setName("事");
        user.setAge(66);
        user.setEmail("liyifan@163.com");

        int i = userMapper.updateById(user);
        System.out.println(i);

        System.err.println(user);
    }

    /**
     * 测试乐观锁
     */
    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(7L);

        user.setName("张三");

        int i = userMapper.updateById(user);
        System.out.println(i);
        System.out.println(user);
//        int insert = userMapper.insert(user);
//        System.out.println("添加"+insert+"行");
//
//        System.out.println(user);
    }


    @Test
    public void testSelect(){
        User user = userMapper.selectById(6L);


        System.out.println(user);
    }

    /**
     * 多个id查询
     */
    @Test
    public void testSelects(){
        List<User> list = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));

        list.forEach(System.out::println);
    }

    /**
     * 条件查询
     */
    @Test
    public void testSelectMap(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("name","李四");

        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }


    /**
     * 分页查询
     */
    @Test
    public void testPage(){
        Page<User> page = new Page<>(0,3);
        Page<User> list = userMapper.selectPage(page, null);

        System.out.println(list.getRecords().toString());
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        int i = userMapper.deleteBatchIds(Arrays.asList(13));
        System.out.println("删除了"+i+"行");

        List<User> list = userMapper.selectList(null);

        list.forEach(System.out::println);
    }


    @Test
    public void testDeleteById(){
        int i = userMapper.deleteById(1l);
        System.out.println("删除"+i+"行");

        this.contextLoads();
    }

    @Test
    public void searchUser(){

        List<User> list = userMapper.searchUser();

        list.forEach(System.out::println);

    }
}

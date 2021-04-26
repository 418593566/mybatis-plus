package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
//含有所有属性的构造函数
@AllArgsConstructor
//空参构造
@NoArgsConstructor
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String email;

    @Version   //乐观锁
    private Integer version;

    @TableLogic  //逻辑删除
    private Integer deleted;

    //添加时 填充
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //插入和更新时填充字段
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

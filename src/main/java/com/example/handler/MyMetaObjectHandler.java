package com.example.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component   //不要忘 添加到ioc
public class MyMetaObjectHandler  implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        /**
         * setFieldValByName(String fieldName : 字段名
         *                  Object fieldVal :   字段值
         *                  MetaObject metaObject : 给那个数据处理 )
         */

        log.info("insertFill start ...");
        System.out.println("--------------------------------------------------------");
        this.setFieldValByName("creatTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

        this.strictInsertFill(metaObject,"createTime",Date.class,new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill start ...");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}

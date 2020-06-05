package com.shanezhou.springboot.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 自定义自动填充
 * @Author ShaneZhou
 * @Time 2020/06/04 14:33:33
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "password",
                String.class, "123456");
        this.strictInsertFill(metaObject, "deptId",
                Integer.class, 1);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}

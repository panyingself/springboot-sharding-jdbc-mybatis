package com.toxic.anepoch.entitystore.controller.web;

import com.toxic.anepoch.entitystore.service.model.EntityDetail0;
import com.toxic.anepoch.entitystore.service.service.EntityDetail0Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * @author ying.pan
 * @date 2020/6/1 2:49 PM.
 */
@RestController(value = "/testSharding")
public class TestShardingController {
    @Resource
    private EntityDetail0Service entityDetail0Service;

    @RequestMapping(value = "/testShardingInsert")
    public String testInsert() {
        System.out.println("测试controller......testInsert");
        Random random = new Random();

        EntityDetail0 entityDetail0 = new EntityDetail0();
        entityDetail0.setId((long) Math.floor((random.nextDouble() * 100000.0)));
        entityDetail0.setEntityId((long) Math.floor((random.nextDouble() * 100000.0)));
        entityDetail0.setVersion(0);
        entityDetail0.setSection("");
        entityDetail0.setData("");
        entityDetail0.setCreateDate(new Date());
        entityDetail0.setUpdateTime(new Date());

        entityDetail0Service.save(entityDetail0);
        return "test success";
    }

    @RequestMapping(value = "/testShardingList")
    public Object testList() {
        return entityDetail0Service.queryList(new EntityDetail0());
    }
}

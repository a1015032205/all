package com.java.service.impl;

import com.java.dao.InfoMapper;
import com.java.pojo.Info;
import com.java.service.InfoService;
import com.java.utils.RedisUtil2;
import com.java.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-03-28 23:05
 * @Description: impl
 */
@Service(value = "InfoServiceImpl")
@Slf4j
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisUtil2 redisUtil2;


    @Override
    public Object getAll() {
        return infoMapper.getAll();
    }

    @Override
    public void add(Info info) {
        infoMapper.add(info);

    }

    @Override
    public void del(String id) {
        infoMapper.del(id);
    }

    @Override
    public void update(String id, String name) {
        infoMapper.update(id, name);
    }

    @Override
    public void addResource() {
        ArrayList<Info> listInfo = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            Info info = new Info(null, "小刘" + i, i);
            listInfo.add(info);
        }
        infoMapper.addResource(listInfo);
    }

//    public String testSetObj() {
//
//        redisUtil2.set(user.getUsername(), user);
//        return "success set obj";
//    }
//
//    public Object testGetObj(String key) {
//        return redisUtil2.get(key);
//    }

    @Override
    public Object findAll() {
//        //序列化数据时，以String的方式显示，不会显示成乱码
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        //指定redis以key，value存放数据，key的名称正常显示，不会显示成乱码
//        redisTemplate.setKeySerializer(redisSerializer);
//        Info info = new Info(null, "刘半仙", 100);
//        redisUtil2.set("name", info);
//        //
//        // redisUtils.set("name2", jack2,60L);
//        Object name = redisUtil2.get("name");
////        Object name1 = redisUtil2.get("name2");
//        Object name2 = redisUtils.getString("name");
////        Object name4 = redisUtils.getString("name2");

        List<Info> infos = null;
        //读cache
        infos = (List<Info>) redisUtil2.get("xiaoliu");
        if (infos == null) {
            synchronized (this) {
                infos = (List<Info>) redisUtil2.get("xiaoliu");
                if (infos == null) {
                    log.info("》》》》》》》》》》》》》》》》》》》》》》》从数据库加载数据");
                    infos = infoMapper.getAll();
                    redisUtil2.set("xiaoliu", infos);
                    log.info("数据已加入cache《《《《《《《《《《《《《《《《《");
                } else {
                    log.info("》》》》》》》》》》》》》》》从缓存中加载");
                }
            }
        } else {
            log.info("-----------从缓存中，加载数据《《《《《《《《《《《《《《《《《《《《《《 ");
        }
        return infos;
    }
}

package com.java.service;

import com.java.pojo.Info;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-03-28 23:04
 * @Description: service
 */

public interface InfoService {

    Object getAll();

    void add(Info info);

    void del(String id);

    void update(String id, String name);

    void addResource();

     Object findAll();
}

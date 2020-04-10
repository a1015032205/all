package com.java.dao;

import com.java.pojo.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-03-28 22:51
 * @Description: info
 */

public interface InfoMapper {
    /**
     * 获得所有数据
     * @return 结果
     */
    List<Info> getAll();

    void add(Info info);

    void del(@Param("id")String id);

    void update(@Param("id")String id,@Param("name")String name);

    void addResource(List<Info> list);
}

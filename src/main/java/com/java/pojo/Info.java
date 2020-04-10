package com.java.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-03-28 22:45
 * @Description: info
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    private Integer id;
    private String name;
    private Integer age;


}

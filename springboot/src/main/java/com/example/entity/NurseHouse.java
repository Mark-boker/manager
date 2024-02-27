package com.example.entity;

/**
 * Description:
 * Param:
 * return:
 * Author:boker
 * Date:
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 养老机构
 */
@Data
public class NurseHouse implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private String price;
    /**
     * 图片
     */
    private String img;
    /**
     * 地址
     */
    private String address;
    /**
     * 浏览量
     */
    private Integer count;
    /**
     * 标签
     */
    private String tags;
    /**
     * 床位数量
     */
    private String beds;
    /**
     * 性质
     */
    private String nature;
    /**
     * 类型
     */
    private String type;
    /**
     * 详情
     */
    private String content;
    /**
     * 面积
     */
    private String area;
    /**
     * 成立日期
     */
    private String date;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
}
package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:养老服务
 * Param:
 * return:
 * Author:boker
 * Date:
 */
@Data
public class Serve implements Serializable {
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
     * 封面
     */
    private String cover;
    /**
     * 服务描述
     */
    private String descr;
    /**
     * 发布时间
     */
    private String date;
}
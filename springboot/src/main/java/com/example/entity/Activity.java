package com.example.entity;

/**
 * Description:活动
 * Param:
 * return:
 * Author:boker
 * Date:
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 名称 */
    private String name;
    /** 封面 */
    private String cover;
    /** 简介 */
    private String descr;
    /** 开始日期 */
    private String start;
    /** 结束时间 */
    private String end;
    /** 活动详情 */
    private String content;
    /** 地址 */
    private String address;
    /** 活动状态*/
    private String status;
    /** 活动发布者*/
    private String userId;
}

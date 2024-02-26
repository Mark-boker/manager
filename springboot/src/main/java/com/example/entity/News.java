package com.example.entity;

/**
 * Description:资讯表
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 标题 */
    private String title;
    /** 简介 */
    private String descr;
    /** 内容 */
    private String content;
    /** 封面 */
    private String cover;
    /** 发布时间 */
    private String time;
    /** 浏览次数 */
    private Integer count;
    /** 分类 */
    private String category;


}
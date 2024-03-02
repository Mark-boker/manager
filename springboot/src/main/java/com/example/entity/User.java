package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * Param:
 * return:
 * Author:boker
 * Date:
 */
@Data
public class User extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 角色标识
     */
    private String role;

    /**
     * 身份证
     */
    private String idcard;

    /**
     * 志愿者（1是 0不是）
     */
    private String volunteer;

    /**
     * 志愿者证
     */
    private String vocard;

}
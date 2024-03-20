package com.example.entity;

/**
 * Description:服务预约
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class Reserve implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 服务ID */
    private Integer serveId;
    /** 预约人ID */
    private Integer userId;
    /** 预约时间 */
    private String time;
    /** 审核状态 */
    private String status;
    /** 审核意见 */
    private String reason;
    /** 预约人姓名 */
    private String userName;
    /** 预约服务名 */
    private String serveName;
    /** 预约人电话 */
    private String userPhone;
    /** 预约地址 */
    private String userAddress;

}
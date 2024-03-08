package com.example.entity;

/**
 * Description:活动报名
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import lombok.Data;

import java.io.Serializable;


@Data
public class ActivitySign implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 活动ID */
    private Integer activityId;
    /** 联系方式 */
    private String phone;
    /** 报名日期 */
    private String date;
    /** 报名人ID */
    private Integer userId;
    /** 审核状态 */
    private String status;
    /** 审核意见 */
    private String reason;
    /** 报名人 */
    private String userName;

}
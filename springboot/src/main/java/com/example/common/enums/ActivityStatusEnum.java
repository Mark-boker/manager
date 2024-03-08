package com.example.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

/**
 * Description:
 * Param:
 * return:
 * Author:boker
 * Date:
 */
@AllArgsConstructor

public enum ActivityStatusEnum {
    NOT_START("未开始"),
    IS_END("已结束"),
    NOT_SIGN("未报名"),
    IS_SIGN("已报名");


    private String value;

    public String getValue() {
        return value;
    }
}

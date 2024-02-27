package com.example.mapper;

import com.example.entity.Activity;

import java.util.List;

/**
 * Description:操作activity相关数据接口
 * Param:
 * return:
 * Author:boker
 * Date:
 */

public interface ActivityMapper {

    /**
     * 新增
     */
    int insert(Activity activity);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Activity activity);

    /**
     * 根据ID查询
     */
    Activity selectById(Integer id);

    /**
     * 查询所有
     */
    List<Activity> selectAll(Activity activity);

}
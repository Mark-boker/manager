package com.example.mapper;

/**
 * Description:操作activity_sign相关数据接口
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import com.example.entity.ActivitySign;
import java.util.List;


public interface ActivitySignMapper {

    /**
     * 新增
     */
    int insert(ActivitySign activitySign);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(ActivitySign activitySign);

    /**
     * 根据ID查询
     */
    ActivitySign selectById(Integer id);

    /**
     * 查询所有
     */
    List<ActivitySign> selectAll(ActivitySign activitySign);

}
package com.example.mapper;

/**
 * Description:操作serve相关数据接口
 * Param:
 * return:
 * Author:boker
 * Date:
 */

import com.example.entity.Serve;

import java.util.List;


public interface ServeMapper {

    /**
     * 新增
     */
    int insert(Serve serve);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Serve serve);

    /**
     * 根据ID查询
     */
    Serve selectById(Integer id);

    /**
     * 查询所有
     */
    List<Serve> selectAll(Serve serve);

}
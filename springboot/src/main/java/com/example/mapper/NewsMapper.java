package com.example.mapper;


import com.example.entity.News;

import java.util.List;


/**
 * Description:操作news相关数据接口
 * Param:
 * return:
 * Author:boker
 * Date:
 */

public interface NewsMapper {

    /**
     * 新增
     */
    int insert(News news);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(News news);

    /**
     * 根据ID查询
     */
    News selectById(Integer id);

    /**
     * 查询所有
     */
    List<News> selectAll(News news);

}
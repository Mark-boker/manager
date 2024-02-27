package com.example.mapper;


import com.example.entity.News;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 查询热度新闻
     */
    List<News> selectTopNews(String sort);

    /**
     * 更新浏览量
     */
    @Update("update news set count = count + 1 where id = #{id}")
    void updateCount(Integer id);

}
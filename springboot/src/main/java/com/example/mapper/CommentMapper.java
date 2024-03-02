package com.example.mapper;

/**
 * Description:操作comment相关数据接口
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import com.example.entity.Comment;

import java.util.List;

public interface CommentMapper {

    /**
     * 新增
     */
    int insert(Comment comment);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Comment comment);

    /**
     * 根据ID查询
     */
    Comment selectById(Integer id);

    /**
     * 查询所有
     */
    List<Comment> selectAll(Comment comment);

}
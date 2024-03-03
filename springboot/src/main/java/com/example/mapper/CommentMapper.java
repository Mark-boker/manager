package com.example.mapper;

/**
 * Description:操作comment相关数据接口
 * Param:
 * return:
 * Author:boker
 * Date:
 */

import com.example.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 树状查询
     */
    List<Comment> selectTree(@Param("fid") Integer fid, @Param("module") String module);

    /**
     * 查询父评论
     */
    @Select("select  * from  comment where  pid =#{pid}")
    List<Comment> selectByPid(Integer pid);


    /**
     * 查询评论数
     */
    @Select("select count(*) from  comment where fid =#{fid} and module =#{module}")
    Integer selectCount(@Param("fid") Integer fid, @Param("module") String module);
}
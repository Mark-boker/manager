package com.example.service;

/**
 * Description:服务预约业务处理
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import cn.hutool.core.date.DateUtil;
import com.example.common.enums.RoleEnum;
import com.example.entity.Reserve;
import com.example.mapper.ReserveMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ReserveService {

    @Resource
    private ReserveMapper reserveMapper;

    /**
     * 新增
     */
    public void add(Reserve reserve) {
        reserve.setTime(DateUtil.now());
        reserveMapper.insert(reserve);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        reserveMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            reserveMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Reserve reserve) {
        reserveMapper.updateById(reserve);
    }

    /**
     * 根据ID查询
     */
    public Reserve selectById(Integer id) {
        return reserveMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Reserve> selectAll(Reserve reserve) {
        return reserveMapper.selectAll(reserve);
    }

    /**
     * 分页查询
     */
    public PageInfo<Reserve> selectPage(Reserve reserve, Integer pageNum, Integer pageSize) {
        if (TokenUtils.getCurrentUser().getRole().equals(RoleEnum.USER.name()) ) {//只有普通用户设立用户id
           reserve.setUserId(TokenUtils.getCurrentUser().getId());

        }
        PageHelper.startPage(pageNum, pageSize);
        List<Reserve> list = reserveMapper.selectAll(reserve);
        return PageInfo.of(list);
    }

}
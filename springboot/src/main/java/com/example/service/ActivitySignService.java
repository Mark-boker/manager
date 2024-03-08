package com.example.service;

/**
 * Description:活动报名业务处理
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import com.example.entity.ActivitySign;
import com.example.mapper.ActivitySignMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivitySignService {

    @Resource
    private ActivitySignMapper activitySignMapper;

    /**
     * 新增
     */
    public void add(ActivitySign activitySign) {
        activitySignMapper.insert(activitySign);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        activitySignMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activitySignMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(ActivitySign activitySign) {
        activitySignMapper.updateById(activitySign);
    }

    /**
     * 根据ID查询
     */
    public ActivitySign selectById(Integer id) {
        return activitySignMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<ActivitySign> selectAll(ActivitySign activitySign) {
        return activitySignMapper.selectAll(activitySign);
    }

    /**
     * 分页查询
     */
    public PageInfo<ActivitySign> selectPage(ActivitySign activitySign, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActivitySign> list = activitySignMapper.selectAll(activitySign);
        return PageInfo.of(list);
    }

}
package com.example.service;

/**
 * Description:公益活动信息表业务处理
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.example.common.enums.ActivityStatusEnum;
import com.example.entity.Account;
import com.example.entity.Activity;
import com.example.mapper.ActivityMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private ActivitySignService activitySignServicer;

    /**
     * 新增
     */
    public void add(Activity activity) {

        activityMapper.insert(activity);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        activityMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activityMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Activity activity) {
        activityMapper.updateById(activity);
    }

    /**
     * 根据ID查询
     */
    public Activity selectById(Integer id) {
        Activity activity = activityMapper.selectById(id);
        Date date = new Date();
        String start = activity.getStart();
        if (DateUtil.parseDate(start).isAfter(date)) {//开始时间是否为当前时间之后的
            activity.setStatus(ActivityStatusEnum.NOT_START.getValue());
            return activity;
        }
        String end = activity.getEnd();
        if (DateUtil.parseDate(end).isBefore(date)) {
            activity.setStatus(ActivityStatusEnum.IS_END.getValue());
            return activity;
        }
        Account currentUser = TokenUtils.getCurrentUser();
        if ( activitySignServicer.selectByActivityIdAndUserId(id,currentUser.getId()) == null)  {
            activity.setStatus(ActivityStatusEnum.NOT_SIGN.getValue());
        }else {
            activity.setStatus(ActivityStatusEnum.IS_SIGN.getValue());
        }


        return activity;
    }

    /**
     * 查询所有
     */
    public List<Activity> selectAll(Activity activity) {
        return activityMapper.selectAll(activity);
    }

    /**
     * 分页查询
     */
    public PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> list = activityMapper.selectAll(activity);
        return PageInfo.of(list);
    }

}
package com.example.service;

/**
 * Description:活动报名业务处理
 * Param:
 * return:
 * Author:boker
 * Date:
 */
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.ActivitySign;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.ActivitySignMapper;
import com.example.mapper.UserMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivitySignService {

    @Resource
    private ActivitySignMapper activitySignMapper;
    @Resource
    private UserMapper userMapper;
    /**
     * 新增
     */
    public void add(ActivitySign activitySign) {
        activitySign.setDate(DateUtil.today());
        //看看用户有没有报名
        if ( activitySignMapper.selectByActivityIdAndUserId(activitySign.getActivityId(),activitySign.getUserId()) != null) {
            throw new CustomException(ResultCodeEnum.SIGN_ERROR);
        }
//        User user = userMapper.selectById(activitySign.getUserId());
//
//        if ( user.getIdcard() == null || user.getVocard() == null) {
//            throw new CustomException(ResultCodeEnum.NOT_CARD_ERROR);
//        }
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
        if (TokenUtils.getCurrentUser().getRole().equals(RoleEnum.USER.name()) ) {
            activitySign.setUserId(TokenUtils.getCurrentUser().getId());
            
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ActivitySign> list = activitySignMapper.selectAll(activitySign);
        return PageInfo.of(list);
    }
    /**
     * 查询报名
     */
    public ActivitySign selectByActivityIdAndUserId(Integer activityId, Integer userId) {
       return activitySignMapper.selectByActivityIdAndUserId(activityId,userId);
    }
}
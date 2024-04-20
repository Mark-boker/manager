package com.example.controller;

import com.example.common.Result;
import com.example.entity.Activity;
import com.example.service.ActivityService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:活动接口
 * Param:
 * return:
 * Author:boker
 * Date:
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Resource
    private ActivityService activityService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Activity activity) {
        activityService.add(activity);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        activityService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        activityService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Activity activity) {
        activityService.updateById(activity);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Activity activity = activityService.selectById(id);
        return Result.success(activity);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Activity activity ) {
        List<Activity> list = activityService.selectAll(activity);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Activity activity,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Activity> page = activityService.selectPage(activity, pageNum, pageSize);
        return Result.success(page);
    }
    /**
     * 分页查询用户发布活动
     */
    @GetMapping("/selectPageUser")
    public Result selectPageUser(Activity activity,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,String userId) {
        PageInfo<Activity> page = activityService.selectPageUser(activity, pageNum, pageSize,userId);
        return Result.success(page);
    }
}

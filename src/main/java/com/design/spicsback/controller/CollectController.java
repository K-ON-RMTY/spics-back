package com.design.spicsback.controller;

import com.design.spicsback.entity.Collect;
import com.design.spicsback.service.CollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TCollect)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@RestController
@RequestMapping("collect")
public class CollectController {
    /**
     * 服务对象
     */
    @Resource
    private CollectService collectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Collect selectOne(Integer id) {
        return this.collectService.queryById(id);
    }

}
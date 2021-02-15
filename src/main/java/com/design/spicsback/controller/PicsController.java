package com.design.spicsback.controller;

import com.design.spicsback.entity.Pics;
import com.design.spicsback.service.PicsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TPics)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@RestController
@RequestMapping("pics")
public class PicsController {
    /**
     * 服务对象
     */
    @Resource
    private PicsService picsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Pics selectOne(Integer id) {
        return this.picsService.queryById(id);
    }

}
package com.design.spicsback.controller;

import com.design.spicsback.entity.Information;
import com.design.spicsback.entity.Like;
import com.design.spicsback.service.LikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TLike)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@RestController
@RequestMapping("like")
public class LikeController {
    /**
     * 服务对象
     */
    @Resource
    private LikeService likeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Like selectOne(Integer id) {
        return this.likeService.queryById(id);
    }

    @PostMapping("addOne")
    public Information addOne(Like like){
        Like isSuccess=this.likeService.insert(like);
        if(isSuccess == null){
            return Information.error(203,"失败");
        }else {
            return Information.success("点赞成功");
        }
    }

    @PostMapping("deleteOne")
    public Information deleteOne(Like like){
        boolean isDeleted=this.likeService.deleteByUserIdAndPicId(like);
        if(isDeleted){
            return Information.success("删除成功");
        }else{
            return Information.error(301,"删除失败");
        }
    }

}
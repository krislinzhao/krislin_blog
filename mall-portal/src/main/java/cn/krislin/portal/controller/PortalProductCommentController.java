package cn.krislin.portal.controller;

import cn.krislin.mbg.model.PmsComment;
import cn.krislin.mbg.model.PmsCommentReplay;
import cn.krislin.portal.domain.PmsCommentParam;
import cn.krislin.portal.service.PortalProductCommentService;
import cn.krislincommon.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品评论管理
 **/
@RestController
@Api(tags = "PortalProductCommentController", description = "商品评论管理")
public class PortalProductCommentController {
    @Autowired
    private PortalProductCommentService commentService;

    @ApiOperation("产品评论信息列表")
    @GetMapping(value = "/portal/commentlist/{productId}")
    public CommonResult<List<PmsCommentParam>> getCommentList(
            @PathVariable Long productId,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        return commentService.getCommentList(productId,pageNum,pageSize);
    }

    @ApiOperation("发布产品评论")
    @RequestMapping(value = "/portal/sendComment",method = RequestMethod.POST)
    public CommonResult sendProductComment(@RequestBody PmsComment pmsComment){
        Integer result = commentService.insertProductComment(pmsComment);
        if(result > 0){
            return CommonResult.success(null);
        }else if(result == -1){
            return CommonResult.failed("您没有购买过当前商品,无法评价！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("产品评论回复")
    @RequestMapping(value = "/portal/sendCommentReply",method = RequestMethod.POST)
    public CommonResult sendProductCommentReply(@RequestBody PmsCommentReplay commentReplay){
        Integer result = commentService.insertCommentReply(commentReplay);
        if(result > 0){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }
}

package com.hkx.modules.article.controller;

import com.hkx.common.annotaion.LoginRequired;
import com.hkx.common.api.CommonResult;
import com.hkx.common.api.ResultCode;
import com.hkx.common.enums.Permission;
import com.hkx.modules.article.dto.*;
import com.hkx.modules.article.model.Articles;
import com.hkx.modules.article.service.ArticleService;
import com.hkx.modules.article.service.TempArticleService;
import com.hkx.modules.article.vo.GetArticleByIdVo;
import com.hkx.modules.article.vo.GetArticleByTagVo;
import com.hkx.modules.article.vo.UpdateArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    TempArticleService tempArticleService;

    @PostMapping ("/getAllArticle")
    public CommonResult getAllArticles() {
        return CommonResult.success(articleService.getAllArticles());
    }

    @PostMapping("/addArticle")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult addArticle(@RequestBody AddArticleDto addArticleDto) {
        articleService.addArticle(addArticleDto);
        return CommonResult.success();
    }

    @PostMapping("/deleteArticle")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult deleteArticle(@RequestBody DeleteArticleDto deleteArticleDto) {
        Boolean res = articleService.deleteArticle(deleteArticleDto);
        if (res) return CommonResult.success();
        else return CommonResult.failed(ResultCode.ARTICLE_DEL_ERR);
    }

    @PostMapping("/updateArticle")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult updateArticle(@RequestBody UpdateArticleDto updateArticleDto) {
        UpdateArticleVo updateArticleVo = articleService.updateArticle(updateArticleDto);
            if (updateArticleVo == null) {
            return CommonResult.failed(ResultCode.UPDATE_ERR);
        } else {
            return CommonResult.success(updateArticleVo);
        }
    }

    @PostMapping("/getArticleById")
    public CommonResult getArticleById(@RequestBody GetArticleByIdDto getArticleByIdDto) {
        GetArticleByIdVo getArticleByIdVo = articleService.getArticleById(getArticleByIdDto);
        if (getArticleByIdVo == null) {
            return CommonResult.failed(ResultCode.GET_ARTICLE_ERR);
        } else {
            return CommonResult.success(getArticleByIdVo);
        }
    }

    @PostMapping("/getArticleByTag")
    public CommonResult getArticleByTag(@RequestBody GetArticleByTagDto getArticleByTagDto) {
        List<GetArticleByTagVo> getArticleByTagVos = articleService.getArticleByTag(getArticleByTagDto);
        if (getArticleByTagVos.size() > 0) {
            return CommonResult.success(getArticleByTagVos);
        } else {
            return CommonResult.failed(ResultCode.TAG_GET_ART_ERR);
        }
    }

    @PostMapping("/updateTempArticle")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult updateTempArticle(@RequestBody UpdateTempArticleDto updateTempArticleDto) {
        tempArticleService.updateTempArticle(updateTempArticleDto);
        return CommonResult.success(null, "草稿提交成功");
    }

    @PostMapping("/deleteTempArticle")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult deleteTempArticle() {
        tempArticleService.deleteTempArticle();
        return CommonResult.success(null, "草稿删除成功");
    }

    @PostMapping("/searchTempArticle")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult searchTempArticle() {
        return CommonResult.success(tempArticleService.searchTempArticle());
    }

    @PostMapping("/like")
    public CommonResult like(@RequestBody LikeDto likeDto) {
        articleService.like(likeDto);
        return CommonResult.success(null, "点赞成功");
    }
}

package com.hkx.modules.article.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hkx.modules.article.dto.*;
import com.hkx.modules.article.vo.*;
import com.hkx.modules.article.model.Articles;

import java.util.List;

public interface ArticleService extends IService<Articles> {
    public List<GetAllArticleVo> getAllArticles();
    public void addArticle(AddArticleDto addArticleDto);
    public Boolean deleteArticle(DeleteArticleDto deleteArticleDto);
    public UpdateArticleVo updateArticle(UpdateArticleDto updateArticleDto);
    public GetArticleByIdVo getArticleById(GetArticleByIdDto getArticleByIdDto);
    public List<GetArticleByTagVo> getArticleByTag(GetArticleByTagDto getArticleByTagDto);
    public void like(LikeDto likeDto);
}

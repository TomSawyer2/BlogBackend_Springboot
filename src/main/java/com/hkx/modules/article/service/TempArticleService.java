package com.hkx.modules.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hkx.modules.article.dto.UpdateTempArticleDto;
import com.hkx.modules.article.model.TempArticles;
import com.hkx.modules.article.vo.SearchTempArticleVo;

public interface TempArticleService extends IService<TempArticles> {
    public void updateTempArticle(UpdateTempArticleDto updateTempArticleDto);
    public void deleteTempArticle();
    public SearchTempArticleVo searchTempArticle();
}

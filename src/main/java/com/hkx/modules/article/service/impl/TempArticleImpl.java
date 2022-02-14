package com.hkx.modules.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hkx.modules.article.dto.UpdateTempArticleDto;
import com.hkx.modules.article.mapper.TempArticleMapper;
import com.hkx.modules.article.model.Articles;
import com.hkx.modules.article.model.TempArticles;
import com.hkx.modules.article.service.TempArticleService;
import com.hkx.modules.article.vo.SearchTempArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TempArticleImpl extends ServiceImpl<TempArticleMapper, TempArticles> implements TempArticleService {
    @Override
    public void updateTempArticle(UpdateTempArticleDto updateTempArticleDto) {
        TempArticles article = new TempArticles();
        StringBuilder sb = new StringBuilder();
        updateTempArticleDto.getTags().forEach(tag -> {
            sb.append(tag);
            sb.append("-");
        });
        String res = sb.substring(0, sb.length() - 1);
        article.setTags(res);
        BeanUtils.copyProperties(updateTempArticleDto, article);
        article.setHaveTemp("1");
        baseMapper.update(article, null);
    }

    @Override
    public void deleteTempArticle() {
        TempArticles article = new TempArticles();
        article.setTags("");
        article.setBrief("");
        article.setHaveTemp("0");
        article.setContent("");
        article.setTitle("");
        article.setId(1);
        baseMapper.updateById(article);
    }

    @Override
    public SearchTempArticleVo searchTempArticle() {
        TempArticles res = baseMapper.selectOne(new QueryWrapper<TempArticles>().eq("id", 1));
        SearchTempArticleVo output = new SearchTempArticleVo();
        BeanUtils.copyProperties(res, output);
        return output;
    }
}

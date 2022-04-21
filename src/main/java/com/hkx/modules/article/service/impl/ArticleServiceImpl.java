package com.hkx.modules.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hkx.common.api.CommonResult;
import com.hkx.common.api.ResultCode;
import com.hkx.modules.article.dto.*;
import com.hkx.modules.article.vo.*;
import com.hkx.modules.article.mapper.ArticleMapper;
import com.hkx.modules.article.model.Articles;
import com.hkx.modules.article.service.ArticleService;
import com.hkx.modules.tag.model.Tags;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Articles> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<GetAllArticleVo> getAllArticles() {
        List<GetAllArticleVo> voList = new ArrayList<>();
        List<Articles> articles = articleMapper
                .selectList(new LambdaQueryWrapper<Articles>()
                        .select(Articles::getId, Articles::getTitle, Articles::getUpdateTime, Articles::getTags,
                                Articles::getHaveLike, Articles::getLikes, Articles::getBrief, Articles::getImgUrl));
        articles.forEach(articles1 -> {
            GetAllArticleVo vo = new GetAllArticleVo();
            BeanUtils.copyProperties(articles1, vo);
            voList.add(vo);
        });
        return voList;
    }

    @Override
    public void addArticle(AddArticleDto addArticleDto) {
        Articles article = new Articles();
        BeanUtils.copyProperties(addArticleDto, article);
        StringBuilder sb = new StringBuilder();
        addArticleDto.getTags().forEach(tag -> {
            sb.append(tag);
            sb.append("-");
        });
        String res = sb.substring(0, sb.length() - 1);
        article.setTags(res);
        save(article);
    }

    @Override
    public Boolean deleteArticle(DeleteArticleDto deleteArticleDto) {
        int res = baseMapper.deleteById(deleteArticleDto.getId());
        if (res == 1) return true;
        else return false;
    }

    @Override
    public UpdateArticleVo updateArticle(UpdateArticleDto updateArticleDto) {
        Articles article = baseMapper.selectOne(new LambdaQueryWrapper<Articles>().eq(Articles::getId, updateArticleDto.getId()));
        if (article == null) {
            return null;
        } else {
            BeanUtils.copyProperties(updateArticleDto, article);
            baseMapper.updateById(article);
            UpdateArticleVo updateArticleVo = new UpdateArticleVo();
            BeanUtils.copyProperties(article, updateArticleVo);
            List<String> newTags = List.of(article.getTags().split("-"));
            updateArticleVo.setTags(newTags);
            return updateArticleVo;
        }
    }

    @Override
    public GetArticleByIdVo getArticleById(GetArticleByIdDto getArticleByIdDto) {
        Articles article = baseMapper.selectOne(new LambdaQueryWrapper<Articles>().eq(Articles::getId, getArticleByIdDto.getId()));
        if (article == null) {
            return null;
        } else {
            GetArticleByIdVo getArticleByIdVo = new GetArticleByIdVo();
            BeanUtils.copyProperties(article, getArticleByIdVo);
            return getArticleByIdVo;
        }
    }

    @Override
    public List<GetArticleByTagVo> getArticleByTag(GetArticleByTagDto getArticleByTagDto) {
        List<Articles> res = baseMapper.selectList(new LambdaQueryWrapper<Articles>().like(Articles::getTags, getArticleByTagDto.getTag()));
        List<GetArticleByTagVo> voList = new ArrayList<>();
        res.forEach(articles -> {
            GetArticleByTagVo output = new GetArticleByTagVo();
            BeanUtils.copyProperties(articles, output);
            voList.add(output);
        });
        return voList;
    }

    @Override
    public void like(LikeDto likeDto) {
        Articles article = baseMapper.selectOne(new LambdaQueryWrapper<Articles>().eq(Articles::getId, likeDto.getId()));;
        String likes = article.getLikes();
        int likesNum = Integer.valueOf(likes);
        likesNum ++;
        String output = String.valueOf(likesNum);
        article.setLikes(output);
    }
}

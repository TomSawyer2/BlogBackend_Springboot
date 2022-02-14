package com.hkx.modules.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkx.modules.article.model.TempArticles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TempArticleMapper extends BaseMapper<TempArticles> {
}

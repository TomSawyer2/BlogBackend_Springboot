package com.hkx.modules.tag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkx.modules.article.model.Articles;
import com.hkx.modules.tag.model.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TagMapper extends BaseMapper<Tags> {

}

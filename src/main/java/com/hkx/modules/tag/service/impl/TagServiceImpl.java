package com.hkx.modules.tag.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hkx.common.annotaion.LoginRequired;
import com.hkx.common.enums.Permission;
import com.hkx.modules.article.mapper.ArticleMapper;
import com.hkx.modules.article.model.Articles;
import com.hkx.modules.article.vo.GetAllArticleVo;
import com.hkx.modules.tag.dto.AddTagDto;
import com.hkx.modules.tag.dto.GetAllTagsDto;
import com.hkx.modules.tag.mapper.TagMapper;
import com.hkx.modules.tag.model.Tags;
import com.hkx.modules.tag.service.TagService;
import com.hkx.modules.tag.vo.GetAllTagsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tags> implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public boolean addTag(AddTagDto addTagDto) {
        Integer count = baseMapper.selectCount(new LambdaQueryWrapper<Tags>().eq(Tags::getName, addTagDto.getName()));
        if (count >= 1) return false;
        else {
            Tags newTag = new Tags();
            BeanUtils.copyProperties(addTagDto, newTag);
            save(newTag);
            return true;
        }
    }

    @LoginRequired(needPermission = Permission.USER)
    public List<GetAllTagsVo> getAllTags() {
        List<GetAllTagsVo> voList = new ArrayList<>();
        List<Tags> tags = tagMapper.selectList(null);
        tags.forEach(tag -> {
            GetAllTagsVo vo = new GetAllTagsVo();
            BeanUtils.copyProperties(tag, vo);
            voList.add(vo);
        });
        return voList;
    }
}

package com.hkx.modules.tag.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hkx.modules.tag.dto.AddTagDto;
import com.hkx.modules.tag.model.Tags;
import com.hkx.modules.tag.vo.GetAllTagsVo;

import java.util.List;

public interface TagService extends IService<Tags> {
    public boolean addTag(AddTagDto addTagDto);
    public List<GetAllTagsVo> getAllTags();
}

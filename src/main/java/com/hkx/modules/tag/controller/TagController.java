package com.hkx.modules.tag.controller;

import com.hkx.common.annotaion.LoginRequired;
import com.hkx.common.api.CommonResult;
import com.hkx.common.api.ResultCode;
import com.hkx.common.enums.Permission;
import com.hkx.modules.tag.dto.AddTagDto;
import com.hkx.modules.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("/addTag")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult addTag(@RequestBody AddTagDto addTagDto) {
        Boolean res = tagService.addTag(addTagDto);
        if (res) return CommonResult.success();
        else return CommonResult.failed(ResultCode.TAG_EXISTED);
    }

    @PostMapping("/getAllTags")
    public CommonResult getAllTags() {
        return CommonResult.success(tagService.getAllTags());
    }

}

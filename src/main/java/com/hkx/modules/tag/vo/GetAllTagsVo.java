package com.hkx.modules.tag.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetAllTagsVo {
    @NotBlank
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String color;

    @NotBlank
    private Integer value;

    @NotBlank
    private String imgUrl;
}

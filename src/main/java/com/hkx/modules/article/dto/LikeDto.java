package com.hkx.modules.article.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LikeDto {
    @NotBlank
    private Integer id;
}

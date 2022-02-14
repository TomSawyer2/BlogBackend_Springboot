package com.hkx.modules.article.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class DeleteArticleDto {
    @NotBlank
    private Integer id;
}

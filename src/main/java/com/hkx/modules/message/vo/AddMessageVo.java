package com.hkx.modules.message.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddMessageVo {
    @NotBlank
    private String content;

    @NotBlank
    private String update_time;
}

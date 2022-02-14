package com.hkx.modules.message.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddMessageDto {
    @NotBlank
    private String content;

    @NotBlank
    private String update_time;
}

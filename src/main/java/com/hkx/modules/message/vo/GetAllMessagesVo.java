package com.hkx.modules.message.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetAllMessagesVo {
    @NotBlank
    private Integer id;

    @NotBlank
    private String content;

    @NotBlank
    private String Reply;

    @NotBlank
    private Integer showReply;

    @NotBlank
    private String updateTime;

    @NotBlank
    private String tempReply;
}

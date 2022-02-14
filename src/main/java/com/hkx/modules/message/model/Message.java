package com.hkx.modules.message.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("messages")
public class Message {

    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;

    private String content;

    private String reply;

    private Integer showReply;

    private String updateTime;

    private String tempReply;

}

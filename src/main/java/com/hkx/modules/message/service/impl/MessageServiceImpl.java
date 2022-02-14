package com.hkx.modules.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hkx.common.api.ResultCode;
import com.hkx.common.exception.Asserts;
import com.hkx.modules.message.dto.AddMessageDto;
import com.hkx.modules.message.dto.DeleteMessageDto;
import com.hkx.modules.message.dto.ReplyMessageDto;
import com.hkx.modules.message.mapper.MessageMapper;
import com.hkx.modules.message.model.Message;
import com.hkx.modules.message.service.MessageService;
import com.hkx.modules.message.vo.AddMessageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> getAllMessages() {
        List<Message> res = baseMapper.selectList(null);
        return res;
    }

    @Override
    public AddMessageVo addMessage(AddMessageDto addMessageDto) {
        Message mes = new Message();
        BeanUtils.copyProperties(addMessageDto, mes);
        baseMapper.insert(mes);
        AddMessageVo res = new AddMessageVo();
        BeanUtils.copyProperties(addMessageDto, res);
        return res;
    }

    @Override
    public void replyMessage(ReplyMessageDto replyMessageDto) {
        Message origin = baseMapper.selectOne(new LambdaQueryWrapper<Message>().eq(Message::getId, replyMessageDto.getId()));
        origin.setReply(replyMessageDto.getReply());
        baseMapper.updateById(origin);
    }

    @Override
    public void deleteMessage(DeleteMessageDto deleteMessageDto) {
        int num = baseMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getId, deleteMessageDto.getId()));
        if (num <= 0) {
            Asserts.fail(ResultCode.MSG_NOT_FOUND);
        } else {
            int res = baseMapper.deleteById(deleteMessageDto.getId());
            if (res != 1)  Asserts.fail(ResultCode.MSG_NOT_FOUND);
        }
    }
}

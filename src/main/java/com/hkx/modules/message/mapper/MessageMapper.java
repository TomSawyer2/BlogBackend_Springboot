package com.hkx.modules.message.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkx.modules.message.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MessageMapper extends BaseMapper<Message> {

}

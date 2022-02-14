package com.hkx.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkx.modules.tag.model.Tags;
import com.hkx.modules.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}

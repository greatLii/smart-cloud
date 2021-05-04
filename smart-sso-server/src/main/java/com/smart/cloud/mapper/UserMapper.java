package com.smart.cloud.mapper;

import com.smart.cloud.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserEntity getUserInfoByUUid(@Param("uuid") String uuid);
}

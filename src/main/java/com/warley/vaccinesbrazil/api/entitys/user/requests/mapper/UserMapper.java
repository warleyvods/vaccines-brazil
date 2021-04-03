package com.warley.vaccinesbrazil.api.entitys.user.requests.mapper;

import com.warley.vaccinesbrazil.api.entitys.user.Users;
import com.warley.vaccinesbrazil.api.entitys.user.requests.UserPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract Users toUser(UserPostRequestBody userPostRequestBody);

}

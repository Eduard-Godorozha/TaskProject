package com.eduard.restapiproject.web.mappers;

import com.eduard.restapiproject.domain.user.User;
import com.eduard.restapiproject.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}

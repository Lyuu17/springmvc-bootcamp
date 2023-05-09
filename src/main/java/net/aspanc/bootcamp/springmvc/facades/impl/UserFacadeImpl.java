package net.aspanc.bootcamp.springmvc.facades.impl;

import net.aspanc.bootcamp.springmvc.dtos.UserDto;
import net.aspanc.bootcamp.springmvc.entities.UserModel;
import net.aspanc.bootcamp.springmvc.facades.UserFacade;
import net.aspanc.bootcamp.springmvc.services.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserFacadeImpl implements UserFacade {

    @Resource
    private UserService userService;

    @Resource
    private Converter<UserDto, UserModel> userDtoToUserModelConverter;

    @Resource
    private Converter<UserModel, UserDto> userModelToUserDtoConverter;

    @Override
    public List<UserDto> findAll() {
        return userService.findAll()
                .stream()
                .map(userModelToUserDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userService.findById(id)
                .map(userModelToUserDtoConverter::convert);
    }

    @Override
    public List<UserDto> findByUsername(String title) {
        return userService.findByUsername(title)
                .stream()
                .map(userModelToUserDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @Override
    public UserDto save(UserDto game) {
        return userModelToUserDtoConverter.convert(userService.save(userDtoToUserModelConverter.convert(game)));
    }
}

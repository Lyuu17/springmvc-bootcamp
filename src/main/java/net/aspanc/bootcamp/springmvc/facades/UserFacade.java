package net.aspanc.bootcamp.springmvc.facades;

import net.aspanc.bootcamp.springmvc.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserFacade {

    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    List<UserDto> findByUsername(String username);

    Optional<UserDto> findFirstByUsername(String username);

    void deleteById(Long id);

    UserDto save(UserDto user);
}

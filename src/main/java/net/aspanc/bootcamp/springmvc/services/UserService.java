package net.aspanc.bootcamp.springmvc.services;

import net.aspanc.bootcamp.springmvc.entities.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> findAll();

    Optional<UserModel> findById(Long id);

    List<UserModel> findByUsername(String username);

    Optional<UserModel> findFirstByUsername(String username);

    void deleteById(Long id);

    UserModel save(UserModel entity);
}

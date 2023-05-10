package net.aspanc.bootcamp.springmvc.services.impl;

import net.aspanc.bootcamp.springmvc.daos.UserDao;
import net.aspanc.bootcamp.springmvc.entities.UserModel;
import net.aspanc.bootcamp.springmvc.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<UserModel> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<UserModel> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Optional<UserModel> findFirstByUsername(String username) {
        return userDao.findFirstByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public UserModel save(UserModel game) {
        return userDao.save(game);
    }
}

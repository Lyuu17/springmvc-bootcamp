package net.aspanc.bootcamp.springmvc.daos;

import net.aspanc.bootcamp.springmvc.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<UserModel, Long> {

    List<UserModel> findByUsername(String username);

    Optional<UserModel> findFirstByUsername(String username);
}

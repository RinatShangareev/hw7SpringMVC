package ru.shangareevrr.common.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shangareevrr.common.entity.User;
import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>  {

      User findByUserNameAndPassword(String name, String pass);

      User findByUserName(String userName);

      List<User> findAll();

}

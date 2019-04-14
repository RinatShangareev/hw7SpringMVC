package ru.shangareevrr.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.shangareevrr.common.entity.User;
import ru.shangareevrr.common.repository.UserRepository;
import ru.shangareevrr.common.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAll() {
      return userRepository.findAll();
    }

    public User getById(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User getByNameByPass(String name, String pass){
        return userRepository.findByUserNameAndPassword(name, pass);
    }

    public User createOrUpdate(User user) {
        return userRepository.save(user);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public void delete(Long id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            try {
                throw new Exception("User with id = " + id + " not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        userRepository.delete(user.get());
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new ArrayList<>(roleRepository.findAll()));
        userRepository.save(user);
    }

}

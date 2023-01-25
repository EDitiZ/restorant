package com.restorant.backend.Service;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.User;
import com.restorant.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByAddress(Address address) {
        return userRepository.findByAddress(address);
    }

    @Override
    public void deleteUser(Integer Uid) {
        userRepository.deleteById(Uid);
    }

    @Override
    public User updateUser(User userToUpdate) {
        return userRepository.save(userToUpdate);
    }
}

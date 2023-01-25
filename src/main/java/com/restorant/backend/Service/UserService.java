package com.restorant.backend.Service;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);
    Optional<User> findById(Integer Uid);
    List<User> findByAddress(Address address);
    void deleteUser(Integer Uid);

    User updateUser(User userToUpdate);
}

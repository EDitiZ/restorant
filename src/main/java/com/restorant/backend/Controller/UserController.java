package com.restorant.backend.Controller;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.User;
import com.restorant.backend.PojoInput.UserInput;
import com.restorant.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/post")
    public ResponseEntity<User> create(@RequestBody UserInput input){

        String firstName = input.getFirstName();
        String lastName = input.getLastName();
        Address address = input.getAddress();
        String phoneNo = input.getPhoneNo();

        User user = new User(firstName,lastName,address,phoneNo);
        userService.create(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/city/{address}")
    public ResponseEntity<List<User>> findAllByAddress(@PathVariable String address){
        Address addressEnum = Address.valueOf(address.toUpperCase());
        List<User> users = userService.findByAddress(addressEnum);

        if (!users.isEmpty())
            return new ResponseEntity<>(users,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer uid){
        userService.deleteUser(uid);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{Uid}")
    public ResponseEntity<User> updateUser(@PathVariable Integer Uid, @RequestBody UserInput input){
        User user = userService.findById(Uid).orElseThrow();

        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setAddress(input.getAddress());
        user.setPhoneNo(input.getPhoneNo());

        userService.updateUser(user);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}

package com.restorant.backend.Repository;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT r from User r where r.address = :address")
    List<User> findByAddress(@Param("address") Address address);
}

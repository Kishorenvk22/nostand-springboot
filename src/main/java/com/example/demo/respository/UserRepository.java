package com.example.demo.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByMobile(String mobile);

}

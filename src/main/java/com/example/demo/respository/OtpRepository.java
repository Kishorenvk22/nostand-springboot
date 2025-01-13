package com.example.demo.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OtpDetails;
import java.util.List;



@Repository
public interface OtpRepository extends JpaRepository<OtpDetails, Long> {

	Optional<OtpDetails> findByMobile(String mobile);
}

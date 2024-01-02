package com.example.demo.domain.repository;

import com.example.demo.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByEmailAndPassword(final String email,final String password);

    Optional<UserEntity> findByEmail(final String email);


}

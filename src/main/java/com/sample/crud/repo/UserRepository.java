package com.sample.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.crud.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

package com.example.week6.repository;

import com.example.week6.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByNameContaining(String name, Pageable pageable);

    @Query("SELECT u FROM User u ORDER BY u.name ASC")
    Page<User> findAllSortedByName(Pageable pageable);
}
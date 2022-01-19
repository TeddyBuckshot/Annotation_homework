package com.samcodes.example.annotation_homework.repositories;

import com.samcodes.example.annotation_homework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<User, Long> {
}

package com.samcodes.example.annotation_homework.repositories;

import com.samcodes.example.annotation_homework.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepo extends JpaRepository<File, Long> {
}

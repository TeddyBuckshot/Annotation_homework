package com.samcodes.example.annotation_homework.repositories;

import com.samcodes.example.annotation_homework.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoldersRepo extends JpaRepository<Folder, Long> {
}

package com.samcodes.example.annotation_homework.controllers;

import com.samcodes.example.annotation_homework.models.File;
import com.samcodes.example.annotation_homework.repositories.FilesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilesController {

    @Autowired
    FilesRepo filesRepo;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(filesRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id){
        Optional<File> payload = filesRepo.findById(id);
        if (payload.isPresent()) {
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/raids")
    public ResponseEntity<File> createFile(@RequestBody File file){
        filesRepo.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/files/{id}")
    public ResponseEntity<File> deleteFile(@PathVariable Long id){
        filesRepo.deleteById(id);
        return new ResponseEntity("deleted", HttpStatus.OK);
    }

    @PutMapping(value = "/files/{id}")
    public ResponseEntity<File> updateFile(@PathVariable Long id, @RequestBody File file){
        Optional<File> findToUpdate = filesRepo.findById(id);
        if(findToUpdate.isPresent()){
            File fileToUpdate = findToUpdate.get();
            fileToUpdate.setName(file.getName());
            fileToUpdate.setExtension(file.getExtension());
            fileToUpdate.setSize(file.getSize());
            fileToUpdate.setFolder(file.getFolder());
            filesRepo.save(fileToUpdate);
            return new ResponseEntity<>(fileToUpdate, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

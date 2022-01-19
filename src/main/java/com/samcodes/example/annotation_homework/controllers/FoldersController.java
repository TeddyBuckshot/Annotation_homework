package com.samcodes.example.annotation_homework.controllers;

import com.samcodes.example.annotation_homework.models.Folder;
import com.samcodes.example.annotation_homework.repositories.FoldersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoldersController {

    @Autowired
    FoldersRepo foldersRepo;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(foldersRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id){
        Optional<Folder> payload = foldersRepo.findById(id);
        if (payload.isPresent()) {
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder){
        foldersRepo.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/folders/{id}")
    public ResponseEntity<Folder> deleteFolder(@PathVariable Long id){
        foldersRepo.deleteById(id);
        return new ResponseEntity("deleted", HttpStatus.OK);
    }

    @PutMapping(value = "/folders/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable Long id, @RequestBody Folder folder){
        Optional<Folder> findToUpdate = foldersRepo.findById(id);
        if(findToUpdate.isPresent()){
            Folder folderToUpdate = findToUpdate.get();
            folderToUpdate.setTitle(folder.getTitle());
            folderToUpdate.setUser(folder.getUser());
            foldersRepo.save(folderToUpdate);
            return new ResponseEntity<>(folderToUpdate, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

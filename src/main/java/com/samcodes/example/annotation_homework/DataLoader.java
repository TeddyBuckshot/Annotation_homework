package com.samcodes.example.annotation_homework;

import com.samcodes.example.annotation_homework.models.File;
import com.samcodes.example.annotation_homework.models.Folder;
import com.samcodes.example.annotation_homework.models.User;
import com.samcodes.example.annotation_homework.models.enums.Extentions;
import com.samcodes.example.annotation_homework.repositories.FilesRepo;
import com.samcodes.example.annotation_homework.repositories.FoldersRepo;
import com.samcodes.example.annotation_homework.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {

    @Autowired
    UsersRepo usersRepo;
    @Autowired
    FoldersRepo foldersRepo;
    @Autowired
    FilesRepo filesRepo;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        User user1 = new User("Sam");
        usersRepo.save(user1);
        User user2 = new User("Linzi");
        usersRepo.save(user2);

        Folder folder1 = new Folder("text documents", user1);
        foldersRepo.save(folder1);
        Folder folder2 = new Folder("java documents", user2);
        foldersRepo.save(folder2);

        File text1 = new File("document1", Extentions.TEXT, 30, folder1);
        filesRepo.save(text1);
        File text2 = new File("document2", Extentions.TEXT, 35, folder1);
        filesRepo.save(text2);
        File text3 = new File("document3", Extentions.TEXT, 28, folder1);
        filesRepo.save(text3);
        File text4 = new File("document4", Extentions.TEXT, 42, folder1);
        filesRepo.save(text4);

        File java1 = new File("java1", Extentions.JAVA, 300, folder2);
        filesRepo.save(java1);
        File java2 = new File("java2", Extentions.JAVA, 400, folder2);
        filesRepo.save(java2);
        File java3 = new File("java3", Extentions.JAVA, 350, folder2);
        filesRepo.save(java3);
        File java4 = new File("java4", Extentions.JAVA, 500, folder2);
        filesRepo.save(java4);

    }
}

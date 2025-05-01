package com.report.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class FileService {


    @Value("${Uploads.Documents}")
    private String path; // This is your base upload path from application.properties

    public String[] saveFile(MultipartFile file) {

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        try {
            // 1. Create the upload directory if it doesn't exist
            Path uploadPath = Paths.get(path);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); // creates the directory and parents if needed
            }



            // 2. Create the file name
            String originalFilename = file.getOriginalFilename();
            String fileName = System.currentTimeMillis() + "_" + originalFilename; // to avoid name clashes

            // 3. Create the full path where the file will be stored
            Path filePath = uploadPath.resolve(fileName);

            // 4. Save the file
            file.transferTo(filePath.toFile());

            // 5. Return filename and path as a String array
            System.out.println("fileName=>"+fileName + " directory => "+ uploadPath+ "full path with name=> "+ filePath.toString());
            return new String[]{fileName,uploadPath.toString(), filePath.toString()};


        }catch (IOException e) {
            throw new RuntimeException("Failed to save file");
        }
    }


}

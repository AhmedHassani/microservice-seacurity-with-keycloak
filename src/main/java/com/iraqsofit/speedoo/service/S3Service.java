package com.iraqsofit.speedoo.service;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class S3Service {


    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("nabil-express-test.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        File path = ResourceUtils.getFile("classpath:nabil-express-test-firebase-adminsdk-utgmq-8519ae4bf1.json");
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(path.getPath()));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return blob.getSelfLink();
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }


    public String upload(MultipartFile multipartFile) {
        String TEMP_URL = "";
        try {
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));
            File file = this.convertToFile(multipartFile, fileName);
            TEMP_URL = this.uploadFile(file, fileName);
            file.delete();
            System.out.println(TEMP_URL);
            return TEMP_URL;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return TEMP_URL;
        }

    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}

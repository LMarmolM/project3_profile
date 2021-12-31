package com.revature.s3buckettest.controller;

import com.revature.s3buckettest.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class S3Controller {
    @Autowired
    S3Service service;

    @PostMapping("/profiles/{id}/profile_pic")
    String uploadProfilePic(@PathVariable Long id, @RequestPart("image") MultipartFile image) {

        try {
            String link = service.uploadProfilePic(id, image);
            return link;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Image could not be uploaded: " + e.getMessage());
        }
    }
}

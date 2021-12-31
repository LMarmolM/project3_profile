package com.revature.s3buckettest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface S3Service {
    String uploadProfilePic(Long id, MultipartFile image) throws Exception;
}

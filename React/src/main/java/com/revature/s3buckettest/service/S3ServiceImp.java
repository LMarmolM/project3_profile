package com.revature.s3buckettest.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class S3ServiceImp implements S3Service {

    @Override
    public String uploadProfilePic(Long id, MultipartFile image) throws Exception {

        final int MAX_IMAGE_SIZE = 5000000; //5MB

        //check that file is image
        if (!image.getContentType().contains("image")) {
            System.out.println("Wrong content-type for profile pic");
            throw new Exception("Invalid file type for profile picture");
        }

        //check size of image
        if(image.getSize() > MAX_IMAGE_SIZE){ //
            System.out.println("Image file too large");
            throw new Exception("Image file too large");
        }

            /* Create S3 Client Object */
            AmazonS3 s3 = AmazonS3ClientBuilder
                    .standard()
                    .withRegion(Regions.US_EAST_1)
                    .withCredentials(new AWSStaticCredentialsProvider(
                            new BasicAWSCredentials(System.getenv("AWS_ACCESS_KEY_ID"), System.getenv("AWS_SECRET_ACCESS_KEY"))))
                    .build();

            /* Set Bucket Name */
            String bucketName = "minimint";
            try {

                //set metadata
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(image.getContentType());
                metadata.setContentLength(image.getSize());

                // create PutObjectRequest object */
                PutObjectRequest request = new PutObjectRequest(bucketName, id.toString(), image.getInputStream(), metadata);
                request.setStorageClass(StorageClass.Standard);
                request.setCannedAcl(CannedAccessControlList.BucketOwnerFullControl);

                // Send put object request
                PutObjectResult result = s3.putObject(request);
                System.out.println("Uploaded profile pic to storage for id: " + id);

                //Set profilepic link for current profile (based on profile id) in db


                return "https://" + bucketName + ".s3.us-east-1.amazonaws.com/" + id;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to upload picture");
            }
        return "error";
    }
}

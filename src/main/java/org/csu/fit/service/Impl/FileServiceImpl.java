package org.csu.fit.service.Impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.csu.fit.config.OssConfiguration;
import org.csu.fit.service.DishService;
import org.csu.fit.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private OssConfiguration ossConfiguration;

    @Override
    public String uploadPicture(MultipartFile file) {
        if (file == null){
            return null;
        }
        OSS client =new OSSClientBuilder().build(ossConfiguration.getENDPOINT(),ossConfiguration.getACCESSKEYID(),ossConfiguration.getACCESSKEYSECRET());
        try {
            String bucketName = ossConfiguration.getBUCKETNAME();
            String fileHost = ossConfiguration.getFILEHOST();
            //判断容器是否存在，不存在则创建
            if (!client.doesBucketExist(bucketName)) {
                client.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                client.createBucket(createBucketRequest);
            }
            //设置文件路径及名称+ ("/" + UUID.randomUUID().toString().replace("-", "") + "-" )
            String fileUrl = fileHost + "/" + file.getOriginalFilename();
            System.out.println("file size:" + file.getSize());
            //上传文件
            PutObjectResult result = client.putObject(bucketName, fileUrl,  new ByteArrayInputStream(file.getBytes()));
            if (result == null){
                return null;
            }
            else {
                return fileUrl;
            }
        }catch (OSSException oe){
            oe.getMessage();
        }catch (ClientException ce){
            ce.getMessage();
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            if (client != null){
                client.shutdown();
            }
        }
        return null;
    }
}

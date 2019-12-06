package org.csu.fit.service;

import org.springframework.web.multipart.MultipartFile;


public interface IFileService {
    String uploadPicture(MultipartFile file);
}

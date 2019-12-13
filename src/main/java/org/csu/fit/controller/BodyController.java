package org.csu.fit.controller;

import org.csu.fit.config.OssConfiguration;
import org.csu.fit.service.BodyService;
import org.csu.fit.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.NumberFormat;

@RestController
@CrossOrigin
public class BodyController {

    @Autowired
    private BodyService bodyService;
    @Autowired
    private IFileService fileService;
    @Autowired
    private OssConfiguration ossConfiguration;

    @PostMapping("/bodyScore")
    public double getBodyScore(@RequestParam("picture") MultipartFile file){
        if(file != null) {
            String filename = file.getOriginalFilename();
            if (!"".equals(filename.trim())) {
                System.out.println("file size:" + file.getSize());
                String uploadUrl = ossConfiguration.getPREFIX() + fileService.uploadPicture(file);
                NumberFormat nf = NumberFormat.getNumberInstance();
                nf.setMaximumFractionDigits(9);
                return Double.parseDouble(nf.format(bodyService.getBodyScore(uploadUrl) + Math.random()));
            } else {
                return 0.0;
            }
        }else {
            return 0.0;
        }
    }
}

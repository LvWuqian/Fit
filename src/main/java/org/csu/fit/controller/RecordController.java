package org.csu.fit.controller;

import org.csu.fit.config.Configuration;
import org.csu.fit.utils.RecordAPI.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.csu.fit.service.ILanguageService;
import org.csu.fit.utils.RecordAPI.util.DemoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@CrossOrigin
public class RecordController {
    @Autowired
    private ILanguageService languageService;

    @PostMapping("/uploadRecord")
    public String upload(MultipartFile file) throws IOException, DemoException {
        File fil = new File(Configuration.FILENAME);
        FileOutputStream st = new FileOutputStream(fil);
        // 拷贝到此路径
        IOUtils.copy(file.getInputStream(), st);
        System.out.println(file.getContentType() + " ");

        // 填写下面信息
        String result = languageService.analyse();
        System.out.println("识别结束：结果是：");
        System.out.println(result);
        JSONObject ans = new JSONObject(result);
        return ans.getJSONArray("result").getString(0);
    }
}

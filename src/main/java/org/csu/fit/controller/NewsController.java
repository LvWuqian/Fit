package org.csu.fit.controller;

import org.csu.fit.config.Configuration;
import org.csu.fit.service.INewsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
public class NewsController {

    @Autowired
    private INewsService newsService;

    @GetMapping("/healthNews")
    public JSONObject getNews() throws IOException {
        return newsService.getRequestFromUrl("http://api01.idataapi.cn:8000/news/toutiao?apikey=" + Configuration.NEWS_API_KEY + "&kw=健康生活&pageToken=0");
    }

}

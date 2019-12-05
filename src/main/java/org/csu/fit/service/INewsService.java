package org.csu.fit.service;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.Reader;

public interface INewsService {

    String readAll(Reader rd) throws IOException;

    JSONObject postRequestFromUrl(String url, String body) throws IOException, JSONException;

    JSONObject getRequestFromUrl(String url) throws IOException, JSONException;
}

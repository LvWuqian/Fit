package org.csu.fit.service;

import org.csu.fit.utils.RecordAPI.util.DemoException;

import java.io.IOException;

public interface ILanguageService {
    String analyse() throws IOException, DemoException;

    String runRawPostMethod(String token) throws IOException, DemoException;

    String runJsonPostMethod(String token) throws DemoException, IOException;

    byte[] getFileContent(String filename) throws DemoException, IOException;

    String base64Encode(byte[] content);
}

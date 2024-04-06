package ru.golovin.ttsservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebFilePathService {

    @Value("${file.storage}")
    private String fileStorage;

    @Value("${file.storage.web}")
    private String fileStorageWeb;

    public String getFilePath(String fileName) {
        return fileStorage.concat("/").concat(fileName);
    }

    public String getWebFilePathFromLocal(String url) {
        return url.replace(fileStorage, fileStorageWeb);
    }

    public String getWebFilePath(String fileName) {
        return fileStorageWeb.concat("/").concat(fileName);
    }
}

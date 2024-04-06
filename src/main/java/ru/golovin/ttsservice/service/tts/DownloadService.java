package ru.golovin.ttsservice.service.tts;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.golovin.ttsservice.dto.SoundDto;
import ru.golovin.ttsservice.util.Md5Util;

import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
@RequiredArgsConstructor
public class DownloadService {

    private final RestTemplate restTemplate;

    @Value("${file.storage}")
    private String fileStorage;

    @SneakyThrows
    public SoundDto download(String url) {
        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, byte[].class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            SoundDto sound = new SoundDto();
            byte[] data = responseEntity.getBody();
            if (data == null) {
                throw new NullPointerException();
            }
            String md5 = Md5Util.calculateMD5(data);
            String name = md5.concat(".wav");
            String downloadPath = fileStorage.concat("/").concat(name);
            try (OutputStream outputStream = new FileOutputStream(downloadPath)) {
                outputStream.write(data);
            }
            sound.setFileMd5(md5);
            sound.setFileUrl(downloadPath);
            sound.setFileName(name);
            return sound;
        } else {
            throw new BadRequestException();
        }
    }
}

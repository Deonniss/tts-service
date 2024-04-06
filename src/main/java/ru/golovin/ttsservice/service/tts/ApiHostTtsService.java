package ru.golovin.ttsservice.service.tts;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.golovin.ttsservice.dto.apihost.ApiHostTtsData;
import ru.golovin.ttsservice.dto.apihost.ApiHostTtsRequest;
import ru.golovin.ttsservice.dto.apihost.ApiHostTtsResponse;
import ru.golovin.ttsservice.entity.SoundFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiHostTtsService implements TtsRestSender {

    private final Gson gson;
    private final RestTemplate restTemplate;
    private final HttpHeaders applicationJsonHeaders;
    private final DownloadService downloadService;

    @Value("${apihost.url}")
    private String apiHostUrl;

    @SneakyThrows
    public SoundFile executeRequest(String text) {
        ApiHostTtsRequest request = new ApiHostTtsRequest();
        ApiHostTtsData data = new ApiHostTtsData();
        data.setLang("ru-RU");
        data.setSpeaker("628");
        data.setEmotion("neutral");
        data.setText(text);
        data.setRate(Double.toString(1));
        data.setPitch(Double.toString(1));
        data.setType("mp3");
        data.setPause("0");
        request.setData(List.of(data));
        HttpEntity<String> requestEntity = new HttpEntity<>(gson.toJson(request), applicationJsonHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiHostUrl, requestEntity, String.class);
        ApiHostTtsResponse apiHostTtsResponse = gson.fromJson(responseEntity.getBody(), ApiHostTtsResponse.class);
        return downloadService.download(apiHostTtsResponse.getAudio());
    }
}

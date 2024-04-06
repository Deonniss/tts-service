package ru.golovin.ttsservice.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.golovin.ttsservice.dto.SoundDto;
import ru.golovin.ttsservice.dto.SoundResponse;
import ru.golovin.ttsservice.dto.TextRequest;
import ru.golovin.ttsservice.repository.TextDataRepository;
import ru.golovin.ttsservice.service.tts.TtsRestSender;
import ru.golovin.ttsservice.util.Md5Util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
@RequiredArgsConstructor
public class TextToSoundService {

    private final TtsRestSender ttsRestSender;
    private final TextDataRepository textDataRepository;
    private final WebFilePathService webFilePathService;
    private final SoundService soundService;

    @SneakyThrows
    public SoundResponse textToSound(TextRequest textRequest) {
        SoundResponse soundResponse = new SoundResponse();
        Map<String, String> map = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(Math.min(textRequest.getTexts().size(), 100));

        for (String t : textRequest.getTexts()) {
            executor.execute(() -> {
                try {
                    if (t == null || t.isBlank()) {
                        throw new NullPointerException("Null or empty text");
                    }
                    String md5 = Md5Util.calculateMD5(t);
                    if (!textDataRepository.existsByMd5(md5)) {
                        SoundDto sound = ttsRestSender.executeRequest(t);
                        soundService.save(sound);
                        map.put(sound.getText(), webFilePathService.getWebFilePathFromLocal(sound.getFileUrl()));
                    } else {
                        map.put(t, webFilePathService.getWebFilePath(textDataRepository.findByMd5(md5).getSoundFile().getName()));
                    }
                } catch (Exception e) {
                    map.put(t, e.getMessage());
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        soundResponse.setTts(map);
        return soundResponse;
    }
}

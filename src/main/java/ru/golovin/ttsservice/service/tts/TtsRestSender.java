package ru.golovin.ttsservice.service.tts;

import ru.golovin.ttsservice.entity.SoundFile;

public interface TtsRestSender {

    SoundFile executeRequest(String text);
}

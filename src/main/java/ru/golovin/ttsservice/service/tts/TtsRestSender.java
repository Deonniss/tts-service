package ru.golovin.ttsservice.service.tts;

import ru.golovin.ttsservice.dto.SoundDto;

public interface TtsRestSender {

    SoundDto executeRequest(String text);
}

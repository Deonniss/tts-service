package ru.golovin.ttsservice.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SoundResponse {

    private Map<String, String> tts;
}

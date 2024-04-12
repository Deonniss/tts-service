package ru.golovin.ttsservice.dto.tts.apihost;

import lombok.Data;

@Data
public class ApiHostTtsData {

    private String lang;
    private String speaker;
    private String emotion;
    private String text;
    private String rate;
    private String pitch;
    private String type;
    private String pause;
}

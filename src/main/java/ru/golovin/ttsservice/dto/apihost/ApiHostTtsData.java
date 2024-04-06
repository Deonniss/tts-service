package ru.golovin.ttsservice.dto.apihost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiHostTtsData {
    @JsonProperty("lang")
    private String lang;

    @JsonProperty("speaker")
    private String speaker;

    @JsonProperty("emotion")
    private String emotion;

    @JsonProperty("text")
    private String text;

    @JsonProperty("rate")
    private String rate;

    @JsonProperty("pitch")
    private String pitch;

    @JsonProperty("type")
    private String type;

    @JsonProperty("pause")
    private String pause;
}

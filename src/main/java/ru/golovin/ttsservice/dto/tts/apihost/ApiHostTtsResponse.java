package ru.golovin.ttsservice.dto.tts.apihost;

import lombok.Data;
import ru.golovin.ttsservice.dto.tts.Response;

@Data
public class ApiHostTtsResponse implements Response {

    private int status;
    private String limit;
    private String audio;
}

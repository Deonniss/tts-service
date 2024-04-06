package ru.golovin.ttsservice.dto.tts.apihost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.golovin.ttsservice.dto.tts.Request;

import java.util.List;

@Data
public class ApiHostTtsRequest implements Request {

    @JsonProperty("data")
    private List<ApiHostTtsData> data;
}

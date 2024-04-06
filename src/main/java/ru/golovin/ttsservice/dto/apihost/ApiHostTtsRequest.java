package ru.golovin.ttsservice.dto.apihost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.golovin.ttsservice.dto.Request;

import java.util.List;

@Data
public class ApiHostTtsRequest implements Request {

    @JsonProperty("data")
    private List<ApiHostTtsData> data;
}

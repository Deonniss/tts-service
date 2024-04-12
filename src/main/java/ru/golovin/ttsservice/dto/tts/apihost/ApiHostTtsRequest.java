package ru.golovin.ttsservice.dto.tts.apihost;

import lombok.Data;
import ru.golovin.ttsservice.dto.tts.Request;

import java.util.List;

@Data
public class ApiHostTtsRequest implements Request {

    private List<ApiHostTtsData> data;
}

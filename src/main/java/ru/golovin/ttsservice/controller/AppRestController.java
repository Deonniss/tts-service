package ru.golovin.ttsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.golovin.ttsservice.dto.SoundResponse;
import ru.golovin.ttsservice.dto.TextRequest;
import ru.golovin.ttsservice.service.TextToSoundService;

@RestController
@RequestMapping(path = "/sound", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AppRestController {

    private final TextToSoundService ttsService;

    @PostMapping("/tts")
    public ResponseEntity<SoundResponse> textToSound(@RequestBody final TextRequest textRequest) {
        return ResponseEntity.ok(ttsService.textToSound(textRequest));
    }

}

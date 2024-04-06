package ru.golovin.ttsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sound", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AppRestController {


    public ResponseEntity<?> generateAudioFiles();

}

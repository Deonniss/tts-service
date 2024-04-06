package ru.golovin.ttsservice.dto;

import lombok.Data;

import java.util.Set;

@Data
public class TextRequest {

    private Set<String> texts;
}

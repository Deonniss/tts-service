package ru.golovin.ttsservice.dto;

import lombok.Data;

@Data
public class SoundDto {

    private String text;
    private String textMd5;
    private String fileName;
    private String fileMd5;
    private String fileUrl;
}

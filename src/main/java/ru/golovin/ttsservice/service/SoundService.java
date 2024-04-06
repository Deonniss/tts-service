package ru.golovin.ttsservice.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.golovin.ttsservice.dto.SoundDto;
import ru.golovin.ttsservice.entity.SoundFile;
import ru.golovin.ttsservice.entity.TextData;
import ru.golovin.ttsservice.repository.SoundFileRepository;
import ru.golovin.ttsservice.repository.TextDataRepository;

@Service
@RequiredArgsConstructor
public class SoundService {

    private final SoundFileRepository soundFileRepository;
    private final TextDataRepository textDataRepository;
    private final WebFilePathService webFilePathService;

    @SneakyThrows
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(SoundDto sound) {
        SoundFile soundFile = new SoundFile();
        soundFile.setName(sound.getFileName());
        soundFile.setUrl(webFilePathService.getWebFilePath(sound.getFileUrl()));
        soundFile.setMd5(sound.getFileMd5());
        TextData textData = new TextData();
        textData.setText(sound.getText());
        textData.setMd5(sound.getTextMd5());
        textData.setSoundFile(soundFileRepository.save(soundFile));
        textDataRepository.save(textData);
    }
}

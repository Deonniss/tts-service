package ru.golovin.ttsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.golovin.ttsservice.entity.SoundFile;

public interface SoundFileRepository extends JpaRepository<SoundFile, Long> {
}

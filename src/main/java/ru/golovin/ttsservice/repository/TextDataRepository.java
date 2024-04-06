package ru.golovin.ttsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.golovin.ttsservice.entity.TextData;

public interface TextDataRepository extends JpaRepository<TextData, Long> {

    boolean existsByMd5(String md5);

    TextData findByMd5(String md5);
}

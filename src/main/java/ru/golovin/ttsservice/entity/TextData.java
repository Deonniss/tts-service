package ru.golovin.ttsservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class TextData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String text;

    @Column(unique = true, nullable = false)
    private String md5;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sound_file_id")
    private SoundFile soundFile;
}

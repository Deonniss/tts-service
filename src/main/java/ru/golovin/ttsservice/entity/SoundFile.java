package ru.golovin.ttsservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class SoundFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String md5;

    @Column(unique = true, nullable = false)
    private String url;
}

package ru.golovin.ttsservice.dto.apihost;

public enum ApiHostLang {
    RU("ru-RU");

    private final String name;

    ApiHostLang(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

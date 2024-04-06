package ru.golovin.ttsservice.util;

import lombok.SneakyThrows;

import java.security.MessageDigest;

public final class Md5Util {

    private Md5Util() {
    }

    @SneakyThrows
    public static String calculateMD5(byte[] bytes) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

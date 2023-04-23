package com.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ApiUtils {

    private ApiUtils(){}

    @SneakyThrows
    public static String readJsonAsString(String filepath){
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    @SneakyThrows
    public static Path writeJsonToFile(String filepath, Response response){
        return Files.write(Paths.get(filepath),response.asByteArray());
    }
}

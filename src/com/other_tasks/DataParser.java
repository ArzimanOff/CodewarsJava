package com.other_tasks;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
public class DataParser {
    public static void main(String[] args) {
        String date = "2024-03-02T17:23:09.000Z";
        System.out.println(parseDate(date));
    }
    public static String parseDate(String dateString){
        // Преобразование строки в объект ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString);

        // Создание формата для нужного вывода
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Преобразование в строку с нужным форматом
        return zonedDateTime.format(formatter);
    }
}

package com.jackie.se.date;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
    public static void main(String[] args) {
        format();
        System.out.println("-----------------");
        parse();
        System.out.println("-----------------");
        customFormat();
    }

    private static void format() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.format(DateTimeFormatter.ISO_TIME));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    private static void parse() {
        String dateStr = "2018-06-29";
        String timeStr = "20:01:12.367";
        String dateTimeStr = "2018-06-29T20:01:12.367";
        LocalDate date = LocalDate.parse(dateStr);
        LocalTime time = LocalTime.parse(timeStr);
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
    }

    private static void customFormat() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ss.SSS");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse("19890508T12:35:16.124", dateTimeFormatter);
        LocalDate date = LocalDate.parse("19890508", dateFormatter);
        LocalTime time = LocalTime.parse("12:23:14.189", timeFormatter);
        System.out.println(dateTime);
        System.out.println(date);
        System.out.println(time);
    }
}

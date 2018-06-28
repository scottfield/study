package com.jackie.json.date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

public class SerializeDateDemo {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper
                .registerModule(new JavaTimeModule());
    }

    public static void main(String[] args) throws IOException {
//        serializeMapWithDateKeyAndDateValue();
        serializeObject();
    }

    private static void serializeMapWithDateKeyAndDateValue() throws JsonProcessingException {
        Map<Object, Object> map = new HashMap<>();
        map.put(LocalDate.now(), LocalDate.now());
        map.put(LocalTime.now(), LocalTime.now());
        map.put(LocalDateTime.now(), LocalDateTime.now());
        ObjectWriter writer = objectMapper.writer();
        String result = writer.writeValueAsString(map);
        System.out.println(result);
    }

    private static void serializeObject() throws JsonProcessingException {
        VO vo = new VO();
        vo.setDate(LocalDate.now());
        vo.setTime(LocalTime.now());
        vo.setDateTime(LocalDateTime.now());
        String result = objectMapper.writeValueAsString(vo);
        System.out.println(result);
    }

    private static class VO {
        private LocalDate date;
        private LocalTime time;
        private LocalDateTime dateTime;

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public LocalTime getTime() {
            return time;
        }

        public void setTime(LocalTime time) {
            this.time = time;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
        }
    }
}

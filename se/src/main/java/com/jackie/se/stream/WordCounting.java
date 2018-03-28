package com.jackie.se.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordCounting {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\s");
        Map<String, Long> wordCountMap = Files.lines(Paths.get("E:\\work\\text.txt"))
            .flatMap(pattern::splitAsStream)
            .collect(groupingBy(String::toLowerCase, counting()));
        System.out.println(wordCountMap);

    }
}

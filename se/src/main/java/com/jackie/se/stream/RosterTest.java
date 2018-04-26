package com.jackie.se.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RosterTest {
    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("jackie", LocalDate.now(), Person.Sex.MALE, "www.jackie.com", 10));
        roster.add(new Person("scott", LocalDate.now(), Person.Sex.MALE, "www.scott.com", 20));
        roster.add(new Person("alie", LocalDate.now(), Person.Sex.FEMALE, "www.alie.com", 30));
        roster.add(new Person("joyce", LocalDate.now(), Person.Sex.FEMALE, "www.joyce.com", 40));
        roster.add(new Person("wisdom", LocalDate.now(), Person.Sex.FEMALE, "www.wisdom.com", 50));
        roster.add(new Person("cron", LocalDate.now(), Person.Sex.FEMALE, "www.cron.com", 60));
        roster.add(new Person("tom", LocalDate.now(), Person.Sex.MALE, "www.tom.com", 70));

        roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .mapToInt(Person::getAge)
            .average()
            .ifPresent(System.out::println);
    }
}

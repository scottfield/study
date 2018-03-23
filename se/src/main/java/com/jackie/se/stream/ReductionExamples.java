package com.jackie.se.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReductionExamples {
    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("jackie", LocalDate.now(), Person.Sex.MALE, "www.jackie.com", 10));
        roster.add(new Person("scott", LocalDate.now(), Person.Sex.MALE, "www.scott.com", 20));
        roster.add(new Person("alie", LocalDate.now(), Person.Sex.FEMALE, "www.alie.com", 30));
        roster.add(new Person("joyce", LocalDate.now(), Person.Sex.FEMALE, "www.joyce.com", 40));
        roster.add(new Person("wisdom", LocalDate.now(), Person.Sex.FEMALE, "www.wisdom.com", 50));
        roster.add(new Person("cron", LocalDate.now(), Person.Sex.FEMALE, "www.cron.com", 60));
        roster.add(new Person("tom", LocalDate.now(), Person.Sex.MALE, "www.tom.com", 70));

        aggregateWithReduceMethod(roster);

        //calculate average value

        aggregateWithCollectMethod(roster);
        //grouping
        grouping(roster);
        //multilevel grouping
        multilevelGrouping(roster);
    }

    private static void multilevelGrouping(List<Person> roster) {
        Map<Person.Sex, List<String>> namesByGender =
            roster
                .stream()
                .collect(
                    Collectors.groupingBy(
                        Person::getGender,
                        Collectors.mapping(
                            Person::getName,
                            Collectors.toList())));
        System.out.println("names by gender:" + namesByGender);
        //total age by gender
        Map<Person.Sex, Integer> totalAgeByGender =
            roster
                .stream()
                .collect(
                    Collectors.groupingBy(
                        Person::getGender,
                        Collectors.reducing(
                            0,
                            Person::getAge,
                            Integer::sum)));
        System.out.println("total age by gender:" + totalAgeByGender);
        //average age by gender
        Map<Person.Sex, Double> averageAgeByGender = roster
            .stream()
            .collect(
                Collectors.groupingBy(
                    Person::getGender,
                    Collectors.averagingInt(Person::getAge)));
        System.out.println("average age by gender:" + averageAgeByGender);
    }

    private static void aggregateWithReduceMethod(List<Person> roster) {
        Integer sum = roster
            .stream()
            .map(Person::getAge)
            .reduce(0, (a, b) -> a + b);
        System.out.println("sum:" + sum);
        int sum1 = roster
            .stream()
            .mapToInt(Person::getAge)
            .sum();
        System.out.println("sum1:" + sum1);
    }

    private static void aggregateWithCollectMethod(List<Person> roster) {
        Averager averageCollect = roster.stream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .map(Person::getAge)
            .collect(Averager::new, Averager::accept, Averager::combine);

        System.out.println("Average age of male members: " +
            averageCollect.average());
    }

    private static void grouping(List<Person> roster) {
        Map<Person.Sex, List<Person>> byGender =
            roster
                .stream()
                .collect(
                    Collectors.groupingBy(Person::getGender));

        System.out.println(byGender);
    }
}

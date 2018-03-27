package com.jackie.se.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

public class DishTest {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));
//        threeHighCaloriesDishes(menu);
//        distinct();
//        skip(menu);
//        firstTwoMeatDishes(menu);
//        eachDishNameLength(menu);
//        distinctWord(menu);
//        square();
//        pair();
//        anyMatch(menu);
//        count(menu);
//        toInStream(menu);
//        revertingBackToObjectStream(menu);
//        numberRange();
//        createStreamWithIterate();
//        first20FibonacinoNumbers();
//        highestCalorieDish(menu);
//        lowestCalorieDish(menu);
//        totalCountOfDishes(menu);
//        totalCaloriesOfMenu(menu);
        summaryOfMenu(menu);
    }


    private static void threeHighCaloriesDishes(List<Dish> menu) {
        List<String> names = menu.stream()
            .filter(dish -> {
                System.out.println("filter:" + dish);
                return dish.getCalories() > 300;
            })
            .sorted((a, b) -> {
                System.out.println("compare:" + a + " and " + b);
                return -(a.getCalories() - b.getCalories());
            })
            .map(dish -> {
                System.out.println("mapping:" + dish);
                return dish.getName();
            })
            .limit(3)
            .collect(toList());
        System.out.println(names);
    }

    private static void distinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
            .filter(i -> i % 2 == 0)
            .distinct()
            .forEach(System.out::println);
    }

    private static void skip(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .skip(2)
            .collect(toList());
        System.out.println(dishes);
    }

    private static void firstTwoMeatDishes(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
            .filter(dish -> dish.getType() == Dish.Type.MEAT)
            .limit(2)
            .collect(toList());
        System.out.println(dishes);
    }

    private static void eachDishNameLength(List<Dish> menu) {
        List<Integer> dishNamesLength = menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .collect(toList());
        System.out.println(dishNamesLength);
    }

    private static void distinctWord(List<Dish> menu) {
        List<String> words = menu.stream()
            .map(Dish::getName)
            .map(dish -> Arrays.asList(dish.split("")))
            .flatMap(Collection::stream)
            .collect(toList());
        System.out.println(words);
    }

    private static void square() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
            .map(e -> e * e)
            .collect(toList());
        System.out.println(squares);
    }

    private static void pair() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer[]> pairs = list1.stream()
            .flatMap(e -> list2.stream()
                .map(n -> new Integer[]{e, n}))
            .filter(arr -> (arr[0] + arr[1]) % 3 == 0)
            .collect(toList());
        for(Integer[] pair : pairs){
            System.out.println(Arrays.toString(pair));
        }
    }

    private static void anyMatch(List<Dish> menu) {
        if(menu.stream()
            .anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }

    private static void toInStream(List<Dish> menu) {
        int totalCalories = menu.stream()
            .mapToInt(Dish::getCalories)
            .sum();
        System.out.println("total calories:" + totalCalories);
    }

    private static void revertingBackToObjectStream(List<Dish> menu) {
        IntStream intStream = menu.stream()
            .mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
        boxed.forEach(System.out::println);
    }

    private static void count(List<Dish> menu) {
        long count = menu.stream()
            .map(x -> 1)
            .reduce(0, (a, b) -> a + b);
        System.out.println(count);
    }

    private static void numberRange() {
        long count = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).count();
        System.out.println(count);

    }

    private static void createStreamWithIterate() {
        Stream.iterate(0, n -> n + 2)
            .limit(10)
            .forEach(System.out::println);
    }

    private static void first20FibonacinoNumbers() {
        Stream.iterate(new Integer[]{0, 1}, (arr) -> new Integer[]{arr[1], arr[0] + arr[1]}).flatMap(Arrays::stream).distinct().limit(20).forEach(System.out::println);
    }

    private static void highestCalorieDish(List<Dish> menu) {
        menu.stream()
            .collect(Collectors.maxBy(comparingInt(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void lowestCalorieDish(List<Dish> menu) {
        menu.stream()
            .collect(Collectors.minBy(comparingInt(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void totalCountOfDishes(List<Dish> menu) {
        Long count = menu.stream()
            .collect(Collectors.counting());
        System.out.println("total count of dishes:" + count);
    }

    private static void totalCaloriesOfMenu(List<Dish> menu) {
        Integer totalCalories = menu.stream()
            .collect(summingInt(Dish::getCalories));
        System.out.println("total calories of menu:" + totalCalories);
    }

    private static void summaryOfMenu(List<Dish> menu) {
        IntSummaryStatistics summary = menu.stream()
            .collect(summarizingInt(Dish::getCalories));
        System.out.println("calorie summary of menu:" + summary);
    }
}

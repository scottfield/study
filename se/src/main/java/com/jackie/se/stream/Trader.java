package com.jackie.se.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
//        transIn2011OrderByValueAsc(transactions);
//        allUniqueCities(transactions);
//        allTradersInCambrige(transactions);
        allTradersnames(transactions);
//        anyTraderBaseInMilan(transactions);
//        printAllTransactionWhichTraderBaseInCambriga(transactions);
        maxTransactionValue(transactions);
        minTransactionValue(transactions);
    }


    private static void transIn2011OrderByValueAsc(List<Transaction> transactions) {
        List<Transaction> list = transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(Comparator.comparingInt(Transaction::getValue))
            .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void allUniqueCities(List<Transaction> transactions) {
        List<String> cities = transactions.stream()
            .map(Transaction::getTrader)
            .map(Trader::getCity)
            .distinct()
            .collect(Collectors.toList());
        System.out.println(cities);
    }

    private static void allTradersInCambrige(List<Transaction> transactions) {
        List<Trader> traders = transactions.stream()
            .map(Transaction::getTrader)
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());
        System.out.println(traders);

    }

    private static void allTradersnames(List<Transaction> transactions) {
        String traders = transactions.stream()
            .map(Transaction::getTrader)
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .map(Trader::getName)
            .collect(Collectors.joining(","));
        System.out.println(traders);

    }

    private static void anyTraderBaseInMilan(List<Transaction> transactions) {
        if(transactions.stream()
            .anyMatch(t -> t.getTrader().getCity().equals("Milan"))){
            System.out.println("there are some traders based in Milan");

        }

    }

    private static void printAllTransactionWhichTraderBaseInCambriga(List<Transaction> transactions) {
        transactions.stream()
            .filter(t -> t.getTrader().getCity().equals("Cambridge"))
            .forEach(t -> System.out.println(t.getValue()));
    }

    private static void maxTransactionValue(List<Transaction> transactions) {
        Optional<Integer> max = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Math::max);
        max.ifPresent(System.out::println);
    }

    private static void minTransactionValue(List<Transaction> transactions) {
        Optional<Integer> min = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Math::min);
        min.ifPresent(System.out::println);
    }


    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

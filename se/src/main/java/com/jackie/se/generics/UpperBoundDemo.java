package com.jackie.se.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UpperBoundDemo {
    public static void main(String[] args) {
        Box<Number> box = new Box<>();
        box.add(1);
        box.add(1L);
        box.add(1f);
        box.add(1D);
        System.out.println(box);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        double sum = sum(numbers);
        System.out.println("sum is:" + sum);
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
        ln.add(null);
        ln.clear();
//        ln.add(new EvenNumber(35));  // compile-time error
        printList(numbers);
        List<Serializable> serializableList = null;
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        List<Number> numberList = null;
        List<? super Integer> consumerList;
        consumerList = serializableList;
        for(Object o : consumerList){

        }
        consumerList = objectList;
        consumerList = numberList;
        consumerList.add(new Integer(0));//this compiles
//        consumerList.add(Long.valueOf(1));
        List<Object> output = new ArrayList<Object>();
        List<Long> input = new ArrayList<Long>();
        copy(output, input);
    }

    public static void printList(List<?> list) {
        for(Object elem : list){
            System.out.println(elem + " ");
        }

        System.out.println();
    }

    private static double sum(List<? extends Number> numbers) {
        return numbers.stream()
            .mapToDouble(Number::doubleValue)
            .sum();
    }

    public static <T> void copy
        (List<? super T> dest, List<? extends T> src) {  // bounded wildcard parameterized types
        for(int i = 0; i < src.size(); i++)
            dest.set(i, src.get(i));
    }

    void wildcardError(List<?> list) {
//        list.set(0, list.get(0)); //cannot compile
    }

    static class NaturalNumber {

        private int i;

        public NaturalNumber(int i) {
            this.i = i;
        }
    }

    static class EvenNumber extends NaturalNumber {

        public EvenNumber(int i) {
            super(i);
        }
    }

    private static class Box<T extends Number> {
        private List<T> container = new ArrayList<>();

        public Box() {

        }

        public void add(T t) {
            container.add(t);
        }

        @Override
        public String toString() {
            return "Box{" +
                "container=" + container +
                '}';
        }
    }
}

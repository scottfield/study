package com.jackie.spring.el;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ElTest {
    public static void main(String[] args) {
        //test collection selection
        collectionSelection();
        //test register function
//        registerFunction();
        //test expression template
//        expressionTemplate();
        //test projection
//        projection();
        //test inline list
//        inlineList();
    }

    private static void collectionSelection() {
        // create an array of integers
        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17));

// create parser and set variable primes as the array of integers
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("primes", primes);

// all prime numbers > 10 from the list (using selection ?{...})
// evaluates to [11, 13, 17]
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
            "#primes.?[#this>7]").getValue(context);
        System.out.println(primesGreaterThanTen);
        //first match
        Integer firstMatch = (Integer) parser.parseExpression(
            "#primes.^[#this>7]").getValue(context);
        System.out.println(firstMatch);
        //last match
        Integer lastMatch = (Integer) parser.parseExpression(
            "#primes.$[#this>7]").getValue(context);
        System.out.println(lastMatch);
        System.out.println(parser.parseExpression("systemProperties").getValue(context));
    }

    static void registerFunction() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        try{
            context.registerFunction("reverseString",
                StringUtils.class.getDeclaredMethod("reverseString", new Class[]{String.class}));
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }
        ExpressionParser parser = new SpelExpressionParser();
        String helloWorldReversed = parser.parseExpression(
            "#reverseString(\"hello\")").getValue(context, String.class);
        System.out.println(helloWorldReversed);
    }

    static void expressionTemplate() {
        ExpressionParser parser = new SpelExpressionParser();
        String randomPhrase = parser.parseExpression(
            "random number is #{T(java.lang.Math).random()}",
            new TemplateParserContext()).getValue(String.class);
        System.out.println(randomPhrase);
    }

    static void projection() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        Map<String, Integer> heightMap = new HashMap<String, Integer>();
        heightMap.put("tree1", 100);
        heightMap.put("tree2", 200);
        heightMap.put("tree3", 500);

        context.setVariable("heightMap", heightMap);
        List<Integer> heightList = (List<Integer>) parser.parseExpression("#heightMap.![value]"
        ).getValue(context);
        System.out.println(heightList);
    }

    static void inlineList() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        Object value = parser.parseExpression("{1,2,3}").getValue(context);
        System.out.println(value);
    }

    abstract static class StringUtils {
        static String reverseString(String input) {
            StringBuilder backwards = new StringBuilder();
            for(int i = 0; i < input.length(); i++)
                backwards.append(input.charAt(input.length() - 1 - i));
            return backwards.toString();
        }
    }
}

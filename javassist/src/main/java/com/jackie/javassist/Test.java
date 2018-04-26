package com.jackie.javassist;

import javassist.*;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {

//        Hello hello = new Hello(); //this code will eagerly load Hello class
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.jackie.javassist.Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        cc.toClass();
        Hello hello = new Hello();
        hello.say();
    }
}

package com.jackie.webservice.demo;

import javax.jws.WebService;

/**
 * Created by Jackie on 2016/8/29.
 */
@WebService(endpointInterface = "com.jackie.webservice.demo.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}

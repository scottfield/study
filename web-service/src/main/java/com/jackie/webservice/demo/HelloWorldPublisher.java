package com.jackie.webservice.demo;

import javax.xml.ws.Endpoint;

/**
 * Created by Jackie on 2016/8/29.
 */
public class HelloWorldPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:7779/ws/hello", new HelloWorldImpl());
    }
}

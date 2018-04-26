package com.jackie.webservice.demo;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jackie on 2016/8/29.
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:7779/ws/hello?wsdl");
            QName qname = new QName("http://pagination.webservice.jackie.com/", "HelloWorldImplService");
            Service service = Service.create(url, qname);
            HelloWorld hello = service.getPort(HelloWorld.class);
            System.out.println(hello.getHelloWorldAsString("jackie"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

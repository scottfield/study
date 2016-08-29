package com.jackie.webservice.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Jackie on 2016/8/29.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloWorld {
    @WebMethod
    String getHelloWorldAsString(String name);
}

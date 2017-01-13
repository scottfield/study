package com.jackie.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by jackie on 11/8/2016.
 */
public class CCLoader extends URLClassLoader {
    /**
     * This constructor is used to set the parent ClassLoader
     */
    public CCLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    /**
     * Every request for a class passes through this method. If the class is in
     * com.journaldev package, we will use this classloader or else delegate the
     * request to parent classloader.
     *
     * @param name Full class name
     */
    @Override
    public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("Loading Class '" + name + "'");
        if (name.startsWith("org.apache")) {
            System.out.println("Loading Class using CCLoader");
            return super.loadClass(name, resolve);
        }
        return super.loadClass(name, resolve);
    }

}

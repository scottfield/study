package com.jackie.io.file;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title(文件名): FileFilterDemo<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2016/11/17
 *
 * @author SF-2171
 */
public class FileFilterDemo {
    public static void main(String[] args) {
        FilenameFilter filenameFilter = new ClassFileFilter();
        File[] roots = File.listRoots();
        List<String> allClassFileNames = new ArrayList<>();

        for (File root : roots) {
            String[] list = root.list(filenameFilter);
            if (list != null && list.length > 0) {
                allClassFileNames.addAll(Arrays.asList(list));
            }
        }
        allClassFileNames.forEach(System.out::println);
    }

    private static class ClassFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            if (name.endsWith(".class")) {
                return true;
            }
            return false;
        }
    }
}

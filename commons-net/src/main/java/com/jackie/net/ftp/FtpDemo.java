package com.jackie.net.ftp;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

/**
 * Created by Jackie on 2016/7/26.
 */
public class FtpDemo {

    public static void main(String[] args) {
        String server = "10.0.3.144";
        int port = 21;
        String user = "jackie";
        String pass = "123456";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), false));
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
//            ftpClient.enterLocalPassiveMode();
            System.out.println("working directory==>" + ftpClient.printWorkingDirectory());
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            mkdir(ftpClient, "/jackie/image");
            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File("D:\\docs\\commons-net-3.5\\examples\\ftp\\ServerToServerFTP.java");

            String firstRemoteFile = "test1.java";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            ftpClient.sendSiteCommand("chmod 755 " + firstRemoteFile);
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }
            inputStream.close();
            /*
            // APPROACH #2: uploads second file using an OutputStream
            File secondLocalFile = new File("d:/avalon.pdf");
            String secondRemoteFile = "/test";
            InputStream inputStream = new FileInputStream(secondLocalFile);

            System.out.println("Start uploading second file");
            OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
            System.out.println(ftpClient.getReplyString());
            byte[] bytesIn = new byte[4096];
            int read = 0;

            while ((read = inputStream.read(bytesIn)) != -1) {
                outputStream.write(bytesIn, 0, read);
            }
            inputStream.close();
            outputStream.close();

            boolean completed = ftpClient.completePendingCommand();

            System.out.println(completed);

            if (completed) {
                System.out.println("The second file is uploaded successfully.");
            }*/

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Boolean mkdir(FTPClient ftpClient, String path) {
        //remove leading slash
        if (path.startsWith("/")) {
            path = path.replaceFirst("/", "");
        }
        String[] subDirs = path.split("/");

        String LOCAL_CHARSET = "UTF-8";
        boolean mkdirSuccess;
        try {
            // 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
            ftpClient.setControlEncoding(LOCAL_CHARSET);
            for (String subDir : subDirs) {
                //encoding
                mkdirSuccess = ftpClient.makeDirectory(subDir);
                ftpClient.sendSiteCommand("chmod 755 " + subDir);
                ftpClient.changeWorkingDirectory(subDir);
                if (!mkdirSuccess) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

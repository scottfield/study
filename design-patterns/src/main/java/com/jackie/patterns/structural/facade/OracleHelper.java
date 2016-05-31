package com.jackie.patterns.structural.facade;

import java.sql.Connection;

/**
 * Created by jackie on 5/30/2016.
 */
public class OracleHelper {
    public static Connection getOracleDBConnection() {
        //get Oracle DB connection using connection parameters
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection con) {
        //get data from table and generate pdf report
        System.out.println("generate oracle pdf report");
    }

    public void generateOracleHTMLReport(String tableName, Connection con) {
        //get data from table and generate html report
        System.out.println("generate oracle html report");
    }
}

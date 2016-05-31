package com.jackie.patterns.structural.facade;

import java.sql.Connection;

/**
 * Created by jackie on 5/30/2016.
 */
public class MySqlHelper {
    public static Connection getMySqlDBConnection(){
        //get MySql DB connection using connection parameters
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection con){
        //get data from table and generate pdf report
        System.out.println("generate mysql pdf report");
    }

    public void generateMySqlHTMLReport(String tableName, Connection con){
        //get data from table and generate html report
        System.out.println("generate mysql html report");
    }
}

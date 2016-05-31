package com.jackie.patterns.structural.facade;

import org.junit.Test;

import java.sql.Connection;

/**
 * Created by jackie on 5/30/2016.
 */
public class HelperFacadeTest {

    private final String tableName = "Employee";

    @Test
    public void testGenerateReportWithFacade() throws Exception {
        //generating MySql HTML report and Oracle PDF report using Facade
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
    }

    @Test
    public void testGenerateReportWithoutFacade() throws Exception {
        //generating MySql HTML report and Oracle PDF report without using Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);

        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);

    }
}
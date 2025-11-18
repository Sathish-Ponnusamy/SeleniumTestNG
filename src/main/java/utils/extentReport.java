package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class extentReport {

    public extentReport() throws IOException {

//        final File CONF = new File("configs/spark-config.xml");
        ConfigFileReader cfr = new ConfigFileReader();
        final File CONF = new File(cfr.getReportConfigPath());
//        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

        ExtentSparkReporter spark = new ExtentSparkReporter(cfr.getReportOutPath());
        spark.loadXMLConfig(CONF);
        ExtentReports extent1 = new ExtentReports();
        extRepInst(spark, extent1, "Testname", "TestValue");
        extRepTer(spark, extent1);
    }

//    public void extRepInst(ExtentSparkReporter spark, ExtentReports extent1,String TestName,String TestValue){
//        ExtentTest node = extent1.createTest(TestName).info(MarkupHelper.createUnorderedList(TestValue).getMarkup());
//
//    }

    public void extRepInst(ExtentSparkReporter spark, ExtentReports extent1,String TestName,String TestValue){
        ExtentTest node = extent1.createTest(TestName).info(MarkupHelper.createUnorderedList(TestValue).getMarkup());

    }

    public void extRepTer(ExtentSparkReporter spark, ExtentReports extent1){
        extent1.createTest("About")
                .assignCategory("QA Dashboard")
                .info("The dashboard page is developed to give a overview of all <span class='badge badge-primary'>Projects</span>");
        extent1.setSystemInfo("Author: ", "Sathish Ponnusamy");
        extent1.setSystemInfo("Report: ", "QA Summary Report");
        extent1.attachReporter(spark);
        extent1.flush();
    }
}

package retryAnalyser;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyTestsRetryAnalyzerTransformerTests {

    SoftAssert softAssert = new SoftAssert();
    @Test()
    public void Test()
    {
//        Assert.assertEquals(false, true);
        softAssert.assertEquals(false, true);
        softAssert.assertAll();

    }

    @Test()
    public void Test1()
    {
//        Assert.assertEquals(true,false );
softAssert.assertEquals(true,false);
        softAssert.assertAll();
    }

    @Test
    public void Test2()
    {
        Assert.assertEquals(true,true );
    }



}

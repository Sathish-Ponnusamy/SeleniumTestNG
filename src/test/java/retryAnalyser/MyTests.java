package retryAnalyser;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyTests {

    SoftAssert softassert = new SoftAssert();

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void Test()
    {
//        Assert.assertEquals(false, true);
        softassert.assertEquals(false, true);
        softassert.assertAll();

    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void Test1()
    {
//        Assert.assertEquals(true,false );
        softassert.assertEquals(true,false );
        softassert.assertAll();
    }

}

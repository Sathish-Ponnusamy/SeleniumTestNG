package retryAnalyser;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTests {

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void Test()
    {
        Assert.assertEquals(false, true);

    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void Test1()
    {
        Assert.assertEquals(true,false );

    }

}

package apiServer.testcases.apiServer;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;
import apiServer.Base.BaseTest;
import apiServer.util.Constants;
import apiServer.util.DataUtil;
import com.aventstack.extentreports.Status;


public class ApiLogin extends BaseTest{


	@Test(dataProvider="getData")
	public void APILoginTest(Hashtable<String,String> data) throws Exception{
		
		test.log(Status.INFO, "Starting "+ testName);

		if(DataUtil.isSkip(testName, xls) ||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO))
		{
			test.log(Status.SKIP, "Runmode is set to NO");
			throw new SkipException("Runmode is set to NO");
		}		
	    ds.executeKeywords(testName, xls, data);
	}


}

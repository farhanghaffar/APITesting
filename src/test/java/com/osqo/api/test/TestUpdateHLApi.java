
package com.osqo.api.test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.hc.core5.reactor.Command.Priority;
import org.codehaus.groovy.util.FastArray;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.pages.DashboardPage;
import com.bond.pages.LoginPage;
import com.bond.pages.CreateBondPage;
import com.bond.pages.OsqoApiPage;
import com.bond.pages.CreateBondApiPage;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;
import com.sun.mail.imap.Utility;

import groovyjarjarantlr.debug.TraceAdapter;


public class TestUpdateHLApi extends BaseClass {
	CreateBondPage syncSubmissionPage;
	CreateBondApiPage syncSubmissionApi;
	OsqoApiPage osqoApiPage;
	
	Status testStatus = Status.PASS;
	boolean flowUi = false;
	boolean flowApi = true;
	HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
	ArrayList<TestSteps> subSteps = new ArrayList<>();
	String testName = null;
	
@Test(enabled = true, priority = 0, groups = {"API"})	
public void UpdateAggregator() {
	
	try {
		initConfiguration();
		osqoApiPage = new OsqoApiPage();
		syncSubmissionPage = new CreateBondPage();
		syncSubmissionApi = new CreateBondApiPage();
		
		map.put("<b>*************** Update Aggregator Request ***************</b>",osqoApiPage.updatAggregator());
		
		
		
	} catch (Exception e) {
		//e.printStackTrace();
		try {
			syncSubmissionPage.addSubStep(subSteps, "Screenshot", Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
		}catch (Exception e2) {
			// TODO: handle exception
			System.out.println("Exception : "+e2.getMessage());
		}
		Assert.assertFalse(true);
	} catch (Error e) {
		//e.printStackTrace();
		syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		try {
			try {
				driver.close();
			}catch (Exception e) {
			}
		}catch (Exception e) {
		}
		try {
			addTestStepsIntoReport(testStatus, map, "Update Aggregator Request And Verify On HL","");

		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	
}
		
	@Test(enabled = false,priority=1,groups = { "API" })
	public void UpdateAndVerifySubAggregatorApiInHLApi() {
		
		testStatus = Status.PASS;
		flowUi = false;
		flowApi = true;
		map = null;
		map = new LinkedHashMap<>();
		subSteps = null;
		subSteps = new ArrayList<>();
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>***************Update Sub Aggregator Request***************</b>",osqoApiPage.updateSubAggregator());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Sub Aggregator Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}

	}
	

	@Test(enabled = false, priority=2,groups = { "API" })
	public void UpdateBrokerGroup() {
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>***************Update Broker Group Request***************</b>",osqoApiPage.BrokerGroup(true));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Aggregator Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}

		
	}


	@Test(enabled = false, priority=3,groups = { "API" })
	public void UpdateBroker() {
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>***************Update Broker Group Request***************</b>",osqoApiPage.Broker(true));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Aggregator Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}

		
	}

	
	@Test(enabled = false, priority=4,groups = { "API" })
	public void UpdateBorrower() {
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>***************Update Borrower Request***************</b>",osqoApiPage.borrower(true));

			
			
		} catch (Exception e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Aggregator Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}

		
		
	}
	

	@Test(enabled = false, priority=5,groups = { "API" })
	public void UpdateBorrowerParty() {
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>***************Borrower Party Request***************</b>",osqoApiPage.borrowerParty(true));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Aggregator Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}

		
		
	}
	
	@Test(enabled = false, priority=6,groups = { "API" })
	public void UpdateScenario() {
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>*************** Update Scenario Request ***************</b>",osqoApiPage.scenario(true));

			
			
		} catch (Exception e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Aggregator Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}
	}
	
	@Test(enabled = false, priority=7,groups = { "API" })
	public void UpdatePropertyClass() {
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>*************** Update Property-Class Request***************</b>",osqoApiPage.propertyClass(true));
			
			
		} catch (Exception e) {
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Aggregator Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}		
	}
	@Test(enabled = false, priority=8,groups = { "API" })
	public void Updateguarantor() {
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>*************** Update Guarantor Request ***************</b>",osqoApiPage.guarantor(true));

			
			
		} catch (Exception e) {
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			try {
				driver.close();
			}catch (Exception e) {
			}
			try {
				addTestStepsIntoReport(testStatus, map, "Update Guarantor Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}		
	}

}
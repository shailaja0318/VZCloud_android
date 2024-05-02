/*package com.sncr.verizon.appiumtests.controls;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

*//**
 * THIS CLASS IS JUST OVERRIDING DEFAULT METHOD TO INCLUDE @BEFORESUITE, WITHOUT IT
 * WE CANT EXECUTE SPRING RELATED FUNCTIONALITY WITHIN @BEFORESUITE METHOD.
 *
 * @author Alen Kalac
 *//*
public class AbstractTestNGSpringContextTestSuite extends AbstractTestNGSpringContextTests{
    //    @BeforeSuite(alwaysRun = true)
//    @BeforeClass(alwaysRun = true)
//    @BeforeTest(alwaysRun = true)
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }
}
*/
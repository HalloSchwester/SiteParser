package de.fhws.siteparser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SiteDownloadTest.class, SiteStructureTest.class, ParseTests.class })
public class AllTests
{

}

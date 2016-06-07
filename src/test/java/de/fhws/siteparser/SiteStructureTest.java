package de.fhws.siteparser;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SiteStructureTest
{
  PatreonSiteParser p = new PatreonSiteParser();
 
  Document downloadedPage;
  
  @Before
  public void downloadPage() throws IOException
  {
    downloadedPage = p.downloadPage();
  }
  
  @Test
  public void testPageStructure() throws IOException
  {
    String html = downloadedPage.html();
    assertTrue(html.contains("patron_count"));
    assertTrue(html.contains("pledge_sum"));
  }
}

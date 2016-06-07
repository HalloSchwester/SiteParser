package de.fhws.siteparser;

import org.jsoup.nodes.Document;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
 
public class SiteDownloadTest
{
  @Test
  public void testPageDownload() throws IOException
  {
    PatreonSiteParser p = new PatreonSiteParser();
    Document downloadPage = p.downloadPage();
    assertNotNull(downloadPage);
  }
}

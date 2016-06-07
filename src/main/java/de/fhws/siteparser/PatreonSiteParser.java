package de.fhws.siteparser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PatreonSiteParser
{
  String site = "https://www.patreon.com/zombieorpheus?ty=h";
  int pledgedSum;
  int patronCount;  
  
  public void parseSite() throws IOException
  {
    Document document = downloadPage();
    parseDocumentForPatronCount(document);
    parseDocumentForPledgedSum(document);
    System.out.println("Pledged Sum: " + Math.round(pledgedSum/100));
    System.out.println("Patrons: " + patronCount);
  }
  
  protected Document downloadPage() throws IOException
  {
    return Jsoup.connect(site).get(); 
  }
  
  protected void parseDocumentForPatronCount(Document document)
  {
    String patrons = parseDocumentForSubstring(document.html(), "\"patron_count\":", ",");
    patronCount = Integer.valueOf(patrons);
  }
  
  protected void parseDocumentForPledgedSum(Document document)
  {
    String pledge = parseDocumentForSubstring(document.html(), "\"pledge_sum\":", ",");
    pledgedSum = Integer.valueOf(pledge);
  }
  
  protected String parseDocumentForSubstring(String doc, String startString, String endString)
  {
    int startIndex = determineStartIndexFromString(doc, startString);
    int endIndex = determineEndIndexFromStringAndStartIndex(doc, endString, startIndex);
    return doc.substring(startIndex, endIndex).trim();
  }
  
  protected int determineStartIndexFromString(String doc, String string)
  {
    int startIndex = doc.indexOf(string);
    if (startIndex == -1) throwParserException(string);
    else startIndex = startIndex + string.length();
    return startIndex;
  }
  
  protected int determineEndIndexFromStringAndStartIndex(String doc, String string, int startIndex)
  {
    int endIndex = doc.indexOf(string, startIndex);
    if (endIndex == -1) throwParserException(string);
    return endIndex;
  }
  
  protected void throwParserException(String notContained)
  {
    throw new ParserException("String " + notContained + " is not contained in page " + site);
  }
  
  public static void main(String[] args)
  {
    PatreonSiteParser parser = new PatreonSiteParser();
    try
    {
      parser.parseSite();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}

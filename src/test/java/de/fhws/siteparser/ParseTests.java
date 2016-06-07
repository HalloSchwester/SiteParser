package de.fhws.siteparser;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParseTests
{
  PatreonSiteParser p = new PatreonSiteParser();
 
  @Test
  public void testParseDocumentForSubstring()
  {
    String doc = "<html><body><div id=\"element\">contents</div>";
    String substring = p.parseDocumentForSubstring(doc, "<div id=\"element\">", "</div>");
    
    assertTrue(substring.equals("contents"));
  }
  
  @Test
  public void testIndicesAndSubstring()
  {
    String doc = "<html><body><div id=\"element\">contents</div>";
    int startIndex = p.determineStartIndexFromString(doc, "<div id=\"element\">");
    assertTrue(startIndex == 30);
    int endIndex = p.determineEndIndexFromStringAndStartIndex(doc, "</div>", startIndex);
    assertTrue(endIndex == 38);
    assertTrue(doc.substring(startIndex,endIndex).equals("contents"));
  }
  
  @Test(expected=ParserException.class)
  public void testParserException()
  {
    p.throwParserException("testString");
  }
}

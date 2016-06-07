package de.fhws.siteparser;

public class ParserException extends RuntimeException
{
  private static final long serialVersionUID = -103104265902242588L;

  public ParserException()
  {
    super();
  }

  public ParserException(String message)
  {
    super(message);
  }
}

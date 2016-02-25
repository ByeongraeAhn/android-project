package com.ldcc.android;

// - 클래스 이름 만으로 어디서 어떤 원인으로 예외가 발생했는지 바로 파악할 수 있도록. 
public class DaoException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public DaoException() {
    super();
  }

  public DaoException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }

  
}

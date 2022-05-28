package com.example;

public class ContainsAnalyzer implements StringAnalyzer {
  @Override
  public boolean analyze(String sourceStr, String searchStr){
    return sourceStr.contains(searchStr);
  }
}


package tests;

import Emag.RandomRole;

public class DummyRandom implements RandomRole{
  private int valueToReturn;
  
  public DummyRandom(int valueToReturn) {
    this.valueToReturn = valueToReturn;
  }

  @Override
  public int generateBetween(int lower, int upper) {
    return valueToReturn;
  }
  
  public void setValueToReturn(int valueToReturn) {
    this.valueToReturn = valueToReturn;
  }
  
}

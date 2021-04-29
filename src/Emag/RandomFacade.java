package Emag;

import java.util.Random;

/**
 * Random generator
 * @author mircea_badoi
 *
 */
public class RandomFacade implements RandomRole {
  
  /**
   * Generates a number between the given values
   */
  public int generateBetween(int lower, int upper) {
    Random random = new Random();
    int randomValue = random.nextInt(upper - lower);
    return randomValue + lower;
  }
}

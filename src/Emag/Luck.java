package Emag;

/**
 * The luck of a player
 * @author mircea_badoi
 *
 */
public class Luck implements LuckRole {
  
  /**
   * Value of the luck given reported to 100%
   */
  protected int luckValue;
  
  /**
   * The random generator 
   */
  private RandomRole random;
  
  /**
   * Public constructor
   * @param luckValue The initial value of the luck
   * @param random The random generator 
   */
  public Luck(int luckValue, RandomRole random) {
    this.luckValue = luckValue;
    this.random = random;
  }

  /**
   * True if the value of this holding luck value is greater than the given one
   * @param luck The value of the opponent's luck
   */
  @Override
  public boolean isLuckierThan(int luck) {

    return this.luckValue >= luck;
  }
  
  
  @Override
  public boolean isLuckier(LuckRole luck) {
    if (luck.isLuckierThan(luckValue)) {
      return false;
    }
    return true;
  }
  
  
  @Override
  public boolean isLucky() {
    int randomValue = random.generateBetween(0, 100);
    return randomValue <= luckValue;
  }

}
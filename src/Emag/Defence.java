package Emag;

public class Defence implements DefenceRole {
  
  /**
   * Capacity of defence of a player
   */
  private int defence;
  
  /**
   * Public constructor
   * @param defence The value of the player defence
   */
  public Defence(int defence) {
    this.defence = defence;
  }
  
  /**
   * Computes the actual impact of the hit from opponent
   * @param strength2 Strength of the opponent hit
   */
  @Override
  public int computeDamage(int strength2) {
    return strength2 - defence;
  }

}
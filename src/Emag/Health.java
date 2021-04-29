package Emag;

/**
 * Health of a player
 * @author mircea_badoi
 *
 */
public class Health implements HealthRole {
  
  /**
   * Value of the player's health
   */
  private int health;

  /**
   * Public constructor
   * @param health The value of the initial health of the player
   */
  public Health(int health) {
    this.health = health;
  }
  
  /**
   * True if the value of health is greater than 0
   */
  @Override
  public boolean isDead() {
    if (health <= 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Apply the given damage by subtracting from health value
   * @param damage The value to subtract from the current health
   */
  @Override
  public void applyDamage(int damage) {
    health -= damage;

  }

  @Override
  public String toString() {
    return String.valueOf(health);
  }

}
package Emag;

/**
 * This represents a beast
 * 
 * @author mircea_badoi
 *
 */
public class Beast implements PlayerRole {

  /**
   * Holds the functionalities regarding the health of this beast
   */
  private HealthRole health;

  /**
   * Represents the strength attribute of this beast
   */
  private int strength;

  /**
   * Holds the functionalities regarding the speed of this beast
   */
  private SpeedRole speed;
  /**
   * The defence mechanism of this beast
   */
  private DefenceRole defence;
  
  /**
   * How lucky this beast is
   */
  private LuckRole luck;
  
  /**
   * The name of this beast
   */
  private String name;
  
  /**
   * Public constructor
   * @param health The health of this beast, when is 0, this beast is dead
   * @param strength This attribute of the beast determines how damage is done by this beast
   * @param speed The speed of this beast, used to find who attacks first
   * @param defence The defence mechanisms of this beast which is any class which implements {@link DefenceRole}
   * @param luck The luck of this beast which is any class which implements {@link LuckRole}
   * @param name Name of this beast
   */
  public Beast(HealthRole health, int strength, SpeedRole speed, DefenceRole defence, LuckRole luck, String name) {
    this.health = health;
    this.strength = strength;
    this.speed = speed;
    this.defence = defence;
    this.luck = luck;
    this.name = name;
  }
  
  /**
   * Attacks the opponent
   * @param defender The player which you wish to attack
   */
  @Override
  public void attack(PlayerRole defender) {
    try {
      GameLaunch.getArena().append("\n" + name + " attacks");
    } catch(NullPointerException e) {
      System.err.println("is in debug");
    }
    defender.defend(strength);
  }
  
  /**
   * Determine if this beast is attacking first based on speed and luck.
   * If the speed is the same for both players, the luck is taken into consideration.
   * If the luch of this beast is greater it returns {@code True}, otherwise {@code False}
   * @param secondPlayer The player to compare to
   */
  @Override
  public boolean isAttackingFirst(PlayerRole secondPlayer) {
    if (secondPlayer.isFasterThan(speed)) {
      return false;
    }
    if (secondPlayer.isSlowerThan(speed)) {
      return true;
    }

    if (secondPlayer.isLuckierThan(luck)) {
      return false;
    }
    return true;
  }

  /**
   * Computes the impact of the hit from opponent
   * @param strength The strength of the opponent hit
   */
  @Override
  public void defend(int strength) {
    if (luck.isLucky()) {
      try {
        GameLaunch.getArena().append("\n" + "Missed");
      } catch(NullPointerException e) {
        System.err.println("is in debug");
      }
      return;
    }
    int damage = defence.computeDamage(strength);
    health.applyDamage(damage);
    try {
      GameLaunch.getArena().append("\n" + name + " Defending" + ", damage: " + damage + ", health: " + health);
    } catch(NullPointerException e) {
      System.err.println("is in debug");
    }
  }
  
  /**
   * Returns true if this beast is dead
   */
  @Override
  public boolean isDead() {

    return health.isDead();
  }
  
  /**
   * True if the speed of this beast is greater than the given opponent speed, otherwise false
   * @param speedValue The speed of the opponent
   */
  public boolean isFasterThan(SpeedRole speedValue) {
    return speed.isFasterThan(speedValue);
  }
  
  /**
   * True if the speed of this beast is less than the given opponent speed, otherwise false
   * @param speedValue The speed of the opponent
   */
  public boolean isSlowerThan(SpeedRole speedValue) {
    return speed.isSlowerThan(speedValue);
  }
  
  /**
   * True if this best is luckier than the opponent, otherwise false
   * @param luck The luck of the opponent
   */
  @Override
  public boolean isLuckierThan(LuckRole luck) {
    return this.luck.isLuckier(luck);
  }

  @Override
  public String toString() {
    return name + " [health=" + health + "]";
  }

}

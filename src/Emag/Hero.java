package Emag;

/**
 * This represent a Hero
 * @author mircea_badoi
 *
 */
public class Hero implements PlayerRole {
  
  /**
   * The hero has a inner beast
   */
  private PlayerRole innerBeast;
  
  /**
   * The chance of a double attack 
   */
  private LuckRole attackChance;
  
  /**
   * Public constructor
   * @param innerBeast The inner beast of this hero
   * @param attackChance The chance of double attack
   */
  public Hero(PlayerRole innerBeast, LuckRole attackChance) {
    super();
    this.innerBeast = innerBeast;
    this.attackChance = attackChance;
  }
  
  /**
   * Attacks the opponent
   * @param defender The player which you wish to attack
   */
  public void attack(PlayerRole defender) {
    innerBeast.attack(defender);
    if (attackChance.isLucky()) {
      try {
        GameLaunch.getArena().append("\n" + "Hero is lucky, attacks again");
      } catch (NullPointerException e) {
        System.err.println("is debug");
      }
      innerBeast.attack(defender);
    }
  }
  
  /**
   * True if this hero is dead, otherwise false
   */
  public boolean isDead() {
    return innerBeast.isDead();
  }
  
  /**
   * True if this hero is attacks first, which is determined based on speed and luck
   */
  public boolean isAttackingFirst(PlayerRole secondPlayer) {
    return innerBeast.isAttackingFirst(secondPlayer);
  }
  
  /**
   * True if this hero is faster compared to the given opponent speed
   * @param speed The speed of the opponent to compare to
   */
  public boolean isFasterThan(SpeedRole speed) {
    return innerBeast.isFasterThan(speed);
  }
  
  /**
   * True if this hero is slower compared to the given opponent speed
   * @param speed The speed of the opponent to compare to
   */
  public boolean isSlowerThan(SpeedRole speed) {
    return innerBeast.isSlowerThan(speed);
  }
  
  /**
   * Defend the hero 
   * @param strength The strength of the opponent's hit
   */
  public void defend(int strength) {
    innerBeast.defend(strength);
  }
  
  /**
   * True if the luck of this hero is greater compared to the given luck
   * 
   */
  public boolean isLuckierThan(LuckRole luck) {
    return innerBeast.isLuckierThan(luck);
  }

  @Override
  public String toString() {
    return innerBeast.toString();
  }

}

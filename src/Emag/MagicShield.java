package Emag;

/**
 * Defend with a magic shield
 * @author mircea_badoi
 *
 */
public class MagicShield implements DefenceRole {
  /**
   * Determines the chance of using this magic shield
   */
  private LuckRole luck;
  
  /**
   * The defence of owner of this defence mechanism
   */
  private DefenceRole innerDefense;

  /**
   * Public constructor
   * @param luck The value of this object random is used to determine the chance of using the magic shield
   * @param innerDefense The defence of a player
   */
  public MagicShield(LuckRole luck, DefenceRole innerDefense) {
    this.luck = luck;
    this.innerDefense = innerDefense;
  }
  
  /**
   * Computes the damage based on the opponent's hit strength and the chance to use the magic shield 
   */
  public int computeDamage(int strength2) {
    int damage = innerDefense.computeDamage(strength2);
    if (luck.isLucky()) {
      damage = damage / 2;
      try {
      GameLaunch.getArena().append("\n" + "Hero has shield");
      } catch (NullPointerException e) {
        System.err.println("is in debug");
      }
    }
    return damage;
  }

}

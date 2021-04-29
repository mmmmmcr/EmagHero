package Emag;

public interface PlayerRole {

  void attack(PlayerRole defender);

  boolean isDead();

  boolean isAttackingFirst(PlayerRole secondPlayer);

  boolean isFasterThan(SpeedRole speed);

  boolean isSlowerThan(SpeedRole speed);

  void defend(int strength);

  boolean isLuckierThan(LuckRole luck);
  
}

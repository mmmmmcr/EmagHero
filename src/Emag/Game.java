package Emag;

/**
 * Plays the Hero game
 * @author mircea_badoi
 *
 */
public class Game {
  /**
   * The attacker
   */
  private PlayerRole attacker;
  
  /**
   * The defender
   */
  private PlayerRole defender;
  
  /**
   * The number of the rounds allowed
   */
  private int maxRoundsNumber;
  
  /**
   * Counts the number of the rounds given
   */
  private int roundCounter;
  
  /**
   * Public constructor
   * @param firstPlayer The first player 
   * @param secondPlayer The second Player
   * @param maxRoundsNumber The number of rounds allowed
   */
  public Game(PlayerRole firstPlayer, PlayerRole secondPlayer, int maxRoundsNumber) {
    if (firstPlayer.isAttackingFirst(secondPlayer)) {
      attacker = firstPlayer;
      defender = secondPlayer;
    } else {
      attacker = secondPlayer;
      defender = firstPlayer;
    }
    this.maxRoundsNumber = maxRoundsNumber;
  }
  
  /**
   * Plays the game
   */
  public void fight() {
    GameLaunch.getArena().append("\n" + "Initial: " + attacker.toString());
    GameLaunch.getArena().append("\n" + "Initial: " + defender.toString() + "\n");
    GameLaunch.getArena().append("\n" + "Start game: ");
    while (fightNotDone()) {
      attacker.attack(defender);
      switchDefenderWithAttacker();
      roundCounter++;
    }
    GameLaunch.getArena().append("\n" + "End game: \n");
    if(!attacker.isDead() && defender.isDead()) {
      GameLaunch.getArena().append("\n" + "Final: " + attacker.toString() + " won, " + defender.toString() + " lost ");
    } else if(!defender.isDead() && attacker.isDead()) {
      GameLaunch.getArena().append("\n" + "Final: " + defender.toString() + " won, " + attacker.toString() + " lost ");
    } else {
      GameLaunch.getArena().append("\n Draw");
    }
  }
  
  /**
   * 
   * @return True if the number of maximum rounds is not reached or none of the players is dead, otherwise false
   */
  private boolean fightNotDone() {
    if (defender.isDead()) {
      return false;
    }
    if (attacker.isDead()) {
      return false;
    }

    if (roundCounter > maxRoundsNumber) {
      return false;
    }
    return true;
  }
  
  /**
   * Switches the role of the players
   */
  private void switchDefenderWithAttacker() {
    PlayerRole temp;
    temp = attacker;
    attacker = defender;
    defender = temp;

  }

}

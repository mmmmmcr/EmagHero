package tests;

import java.util.ArrayList;
import java.util.List;

import Emag.Beast;
import Emag.Defence;
import Emag.DefenceRole;
import Emag.Health;
import Emag.Hero;
import Emag.Luck;
import Emag.MagicShield;
import Emag.PlayerRole;
import Emag.RandomRole;
import Emag.Speed;
import junit.framework.TestCase;

public class TestAttackAndDefend extends TestCase {
  
  /**
   * <p><b>Description:</b> Tests the attack and defend mechanism of a beast</p>
   * @author mircea_badoi
   */
  public void testAttackAndDefendBeast() {
    DummyRandom random1 = new DummyRandom(80);
    RandomRole luck1 = new DummyRandom(50);
    RandomRole luck2 = new DummyRandom(50);
    List<PlayerRole> players = getPlayers(random1, luck1, luck2, 60, 10) ;
    
    //attacker do not miss
    players.get(0).attack(players.get(1));
    assertEquals("Beast [health=80]Beast [health=60]", players.get(0).toString() + players.get(1).toString());
    
    //attacker miss the hit
    players = getPlayers(random1, luck1, luck2, 10, 60) ;
    players.get(0).attack(players.get(1));
    assertEquals("Beast [health=80]Beast [health=80]", players.get(0).toString() + players.get(1).toString());
  }
  
  /**
   * <p><b>Description:</b> Tests the attack and defend mechanism of a hero, including twice attack and shield</p>
   * @author mircea_badoi
   */
  public void testAttackAndDefendHero() {
    DummyRandom random = new DummyRandom(80);
    
    //defender does not have shield, attacker attack once
    List<PlayerRole> players = getHeroes(random, false, false);
    
    players.get(0).attack(players.get(1));
    assertEquals("Hero [health=100]Hero [health=70]", players.get(0).toString() + players.get(1).toString());
    
    //defender does not have shield, attacker attack twice
    players = getHeroes(random, false, true);
    
    players.get(0).attack(players.get(1));
    assertEquals("Hero [health=100]Hero [health=40]", players.get(0).toString() + players.get(1).toString());
    
    //defender  has shield, attacker attack twice
    players = getHeroes(random, true, true);
    
    players.get(0).attack(players.get(1));
    assertEquals("Hero [health=100]Hero [health=70]", players.get(0).toString() + players.get(1).toString());
    
  }
  
  
  
  /**
   * Creates two beasts 
   * @param speed1 The speed of the beasts
   * @param luck1 The luck generator of the first beast
   * @param luck2 The luck generator of the second beast
   * @param initialLuck1 The initial value of luck for the first beast
   * @param initialLuck2 The initial value of luck for the second beast
   * @return The list with the bests
   */
  private List<PlayerRole> getPlayers(RandomRole speed1, RandomRole luck1, RandomRole luck2, int initialLuck1, int initialLuck2){
    List<PlayerRole> toReturn = new ArrayList<PlayerRole>();
    
    PlayerRole beast1 = new Beast(
        new Health(speed1.generateBetween(0, 0)), 
        100,
        new Speed(speed1.generateBetween(0, 0)), 
        new Defence(speed1.generateBetween(0, 0)),
        new Luck(initialLuck1, luck1), 
        "Beast");
    
    PlayerRole beast2 = new Beast(
        new Health(speed1.generateBetween(0, 0)), 
        100,
        new Speed(speed1.generateBetween(0, 0)), 
        new Defence(speed1.generateBetween(0, 0)),
        new Luck(initialLuck2, luck2), 
        "Beast");
    
    toReturn.add(beast1);
    toReturn.add(beast2);
    return toReturn;
  }
  
  /**
   * Get heroes to test
   * @param random The random generator used to determine if a hero has luck
   * @param hasShield True if the defender hero has shield
   * @param attackTwice True if the attacker hero attacks twice
   * @return A list with two heroes configured
   */
  private List<PlayerRole> getHeroes(RandomRole random, boolean hasShield, boolean attackTwice){
    List<PlayerRole> toReturn = new ArrayList<PlayerRole>();

    // Hero initialising
    DefenceRole innerBeastDefence = new Defence(50);
    PlayerRole innerBeast1 = new Beast(
        new Health(100),
        80,
        new Speed(100),
        new MagicShield(new Luck(20, random), innerBeastDefence),
        new Luck(100, random),
        "Hero");
    
    PlayerRole innerBeast2 = new Beast(
        new Health(100),
        100,
        new Speed(100),
        new MagicShield(new Luck(hasShield ? 100 : 0, random), innerBeastDefence),
        new Luck(10, random),
        "Hero");

    PlayerRole hero1 = new Hero(innerBeast1, new Luck(attackTwice ? 100 : 0, random));
    PlayerRole hero2 = new Hero(innerBeast2, new Luck(100, random));

    toReturn.add(hero1);
    toReturn.add(hero2);
    return toReturn;
  }

}

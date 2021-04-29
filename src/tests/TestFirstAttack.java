package tests;

import java.util.ArrayList;
import java.util.List;

import Emag.Beast;
import Emag.Defence;
import Emag.Health;
import Emag.Luck;
import Emag.PlayerRole;
import Emag.RandomRole;
import Emag.Speed;
import junit.framework.TestCase;

public class TestFirstAttack extends TestCase {
  
  /**
   * <p><b>Description:</b> Tests who is attacking first if the first player has a higher speed and luck or the other way</p>
   * 
   *
   * @author mircea_badoi
   */
  public void testIsAttackingFirstHigherSpeed() {
    DummyRandom random1 = new DummyRandom(100);
    DummyRandom random2 = new DummyRandom(90);
    List<PlayerRole> players = getPlayers(random1, random2, null, null) ;
    
    //first player should be the winner as it has higher speed
    assertEquals(true, players.get(0).isAttackingFirst(players.get(1)));
    
    players = getPlayers(random2, random1, null, null) ;
    
    //second player should be the winner as it has higher speed
    assertEquals(false, players.get(0).isAttackingFirst(players.get(1)));
  }
  
  /**
   * <p><b>Description:</b> Tests who is attacking first if the first player has the same speed and luck</p>
   * 
   *
   * @author mircea_badoi
   */
  public void testIsAttackingFirstSameSpeed() {
    RandomRole random1 = new DummyRandom(80);
    RandomRole random2 = new DummyRandom(80);
    List<PlayerRole> players = getPlayers(random1, random2, null, null) ;
    
    //first player should be the attacker in case of the same speed and luck
    assertEquals(true, players.get(0).isAttackingFirst(players.get(1)));
  }
  
  /**
   * <p><b>Description:</b> Tests who is attacking first if the first player has the same speed and luck</p>
   * 
   *
   * @author mircea_badoi
   */
  public void testIsAttackingFirstSameSpeedDifferentLuck() {
    RandomRole random1 = new DummyRandom(80);
    RandomRole luck1 = new DummyRandom(100);
    RandomRole luck2 = new DummyRandom(80);
    List<PlayerRole> players = getPlayers(random1, random1, luck1, luck2) ;
    
    //first player should be the attacker because of the luck
    assertEquals(true, players.get(0).isAttackingFirst(players.get(1)));
    
    //second player should be the attacker because of the luck
    players = getPlayers(random1, random1, luck2, luck1) ;
    assertEquals(false, players.get(0).isAttackingFirst(players.get(1)));
  }
  
  private List<PlayerRole> getPlayers(RandomRole speed1, RandomRole speed2, RandomRole luck1, RandomRole luck2){
    List<PlayerRole> toReturn = new ArrayList<PlayerRole>();
    
    PlayerRole beast1 = new Beast(
        new Health(speed1.generateBetween(0, 0)), 
        speed1.generateBetween(0, 0),
        new Speed(speed1.generateBetween(0, 0)), 
        new Defence(speed1.generateBetween(0, 0)),
        new Luck(luck1 != null ? luck1.generateBetween(0, 0) : speed1.generateBetween(0, 0), luck1), 
        "Beast");
    
    PlayerRole beast2 = new Beast(
        new Health(speed2.generateBetween(0, 0)), 
        speed2.generateBetween(0, 0),
        new Speed(speed2.generateBetween(0, 0)), 
        new Defence(speed2.generateBetween(0, 0)),
        new Luck(luck2 != null ? luck2.generateBetween(0, 0) : speed2.generateBetween(0, 0), luck2), 
        "Beast");
    
    toReturn.add(beast1);
    toReturn.add(beast2);
    return toReturn;
  }

}

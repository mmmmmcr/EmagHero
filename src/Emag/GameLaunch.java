package Emag;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 * Lunches the game
 * 
 * @author mircea_badoi
 *
 */
public class GameLaunch {
  private final static int NO_ROUNDS = 20;
  private static JTextArea arena;

  public static void main(String[] args) {
    createFrame();

  }

  /**
   * Creates a JFrame just to be easier to see how the game is running
   */
  private static void createFrame() {
    // create a frame for better visualisation
    int marginSize = 10;
    arena = new JTextArea();
    arena.setEditable(false);
    arena.setMargin(new Insets(marginSize, marginSize, marginSize, marginSize));
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 600);
    frame.setLayout(new BorderLayout());
    frame.add(new JScrollPane(arena), BorderLayout.CENTER);
    JButton playButton = new JButton("Play");
    frame.add(playButton, BorderLayout.NORTH);
    DefaultCaret caret = (DefaultCaret) arena.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    playButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        arena.setText(null);
        initGame();
      }
    });
  }

  /**
   * Initialise the game
   */
  private static void initGame() {
    RandomRole random = new RandomFacade();

    // Beast initialising
    PlayerRole beast = new Beast(
        new Health(random.generateBetween(60, 90)), 
        random.generateBetween(60, 90),
        new Speed(random.generateBetween(40, 60)), 
        new Defence(random.generateBetween(40, 60)),
        new Luck(random.generateBetween(25, 40), random), 
        "Beast");

    // Hero initialising
    DefenceRole innerBeastDefence = new Defence(random.generateBetween(40, 55));
    PlayerRole innerBeast = new Beast(
        new Health(random.generateBetween(70, 100)),
        random.generateBetween(70, 80),
        new Speed(random.generateBetween(40, 50)),
        new MagicShield(new Luck(20, random), innerBeastDefence),
        new Luck(random.generateBetween(10, 30), random),
        "Hero");

    PlayerRole hero = new Hero(innerBeast, new Luck(10, random));

    Game game = new Game(hero, beast, NO_ROUNDS);
    game.fight();
  }

  public static JTextArea getArena() {
    return GameLaunch.arena;
  }

}

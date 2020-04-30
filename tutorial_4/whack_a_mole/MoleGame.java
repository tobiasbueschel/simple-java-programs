package tutorial_4.whack_a_mole;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

@SuppressWarnings("serial")
public class MoleGame extends JFrame {

  private JPanel contentPane;
  private static JTextField scoreTxt = new JTextField();
  private static JTextField timeTxt = new JTextField();
  private static int time = 60;
  private static int score = 0;
  private static boolean scored = false;
  private static boolean isGameOver = true;
  private static JLabel[] molesArray = {new JLabel("mole1"), new JLabel("mole2"), new JLabel("mole3"), new JLabel(
    "mole4"), new JLabel("mole5"), new JLabel("mole6"), new JLabel("mole7")};

  /**
   * Create the frame.
   */
  public MoleGame() {
    setResizable(false);
    setTitle("Whack a Mole");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 600);
    System.out.println("working");
    contentPane = new JPanel();
    contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel scoreLab = new JLabel("SCORE:");
    scoreLab.setBounds(61, 102, 61, 16);
    scoreLab.setFont(new Font("Samsung InterFace", Font.BOLD, 18));
    contentPane.add(scoreLab);

    JLabel timeLab = new JLabel("TIME:");
    timeLab.setBounds(633, 87, 61, 16);
    timeLab.setFont(new Font("Samsung InterFace", Font.BOLD, 18));
    contentPane.add(timeLab);

    scoreTxt.setFont(new Font("Samsung InterFace", Font.PLAIN, 18));
    scoreTxt.setEditable(true);
    scoreTxt.setText("none");
    scoreTxt.setBounds(129, 102, 45, 16);
    scoreTxt.setBorder(BorderFactory.createEmptyBorder());
    contentPane.add(scoreTxt);
    scoreTxt.setColumns(10);

    timeTxt.setFont(new Font("Samsung InterFace", Font.PLAIN, 18));
    timeTxt.setEditable(true);
    timeTxt.setBounds(682, 87, 52, 20);
    timeTxt.setBorder(BorderFactory.createEmptyBorder());
    contentPane.add(timeTxt);
    timeTxt.setColumns(10);

    JButton btnStart = new JButton("START");
    btnStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        score = 0;
        isGameOver = false;
      }
    });
    btnStart.setBounds(345, 17, 117, 29);
    contentPane.add(btnStart);

    // set moles
    for (int i = 0; i < molesArray.length; i++) {
      contentPane.add(molesArray[i]);
      molesArray[i].setIcon(new ImageIcon(ClassLoader.getSystemResource("images/mole.png")));
      molesArray[i].setVisible(false);
      molesArray[i].addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          scored = true;
        }
      });
    }

    molesArray[0].setBounds(58, 371, 80, 87);
    molesArray[1].setBounds(160, 318, 80, 87);
    molesArray[2].setBounds(262, 371, 80, 87);
    molesArray[3].setBounds(360, 318, 80, 87);
    molesArray[4].setBounds(458, 371, 80, 87);
    molesArray[5].setBounds(561, 318, 80, 87);
    molesArray[6].setBounds(660, 371, 80, 87);

    JLabel background = new JLabel("background");
    background.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/background.png")));
    background.setBounds(0, 0, 800, 578);
    contentPane.add(background);
    contentPane.setVisible(true);

  }

  // Methods that randomly let's moles appear on the screen if (time >0)
  private static void drawMoles() {
    pause();

    while (time > 0) {
      timeTxt.setText(Integer.toString(time));

      //randomly let moles appear on screen
      int rand = (int) (Math.random() * 7);
      molesArray[rand].setVisible(true);

      if (scored) {
        score++;
        playSound();
        System.out.println(score);
        scored = false;
        pause();
      } else {
        pause();
        molesArray[rand].setVisible(false);
      }
      scoreTxt.setText(Integer.toString(score));
      molesArray[rand].setVisible(false);
      time--;
    }
  }

  // sound method embedded from https://www.youtube.com/watch?v=QVrxiJyLTqU
  private static void playSound() {
    try {
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(new File("/Users/Tobias/Dropbox/UCL/Programming/Java/Tutorial4/src" +
        "/whack_a_mole/clap.WAV")));
      clip.start();
    } catch (Exception e) {
      System.out.println("ERROR: Sound");
    }
  }

  // TODO As time progresses, the speed of the moles appearing gets faster.
  // Create parameters for Easy, Medium and Hard speeds. Store the top 10 scores with a name, in a file.
  private static void pause() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MoleGame frame = new MoleGame();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    while (true) {
      System.out.println(isGameOver);
      if (!isGameOver) {
        drawMoles();
      }
    }
  }
}

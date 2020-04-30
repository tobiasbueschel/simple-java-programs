package tutorial_5.balls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Renderer extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;
  public static Boolean start = false;

  Timer tm = new Timer(5, this);
  int posX = 0, posY = 0, posXrand = 0, posYrand = 0, velX = 2, velY = 2, randX = (int) (Math.random() * 7), randY =
    (int) (Math.random() * 7);

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    g.fillOval(posX, 40, 30, 30);
    g.setColor(Color.GREEN);
    g.fillOval(100, posY, 30, 30);
    g.setColor(Color.YELLOW);
    g.fillOval(posXrand, posYrand, 30, 30);
    tm.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // checks Oval 1 & 2
    if (posX < 0 || posX > tutorial_5.balls.BallGame.width - 30) {
      velX = -velX;
    }
    if (posY < 0 || posY > tutorial_5.balls.BallGame.height - 30) {
      velY = -velY;
    }
    posY += velY;
    posX += velX;

    // checks Oval 3
    if (posXrand < 0 || posXrand > tutorial_5.balls.BallGame.width - 30) {
      randX = -randX;
    }
    if (posYrand < 0 || posYrand > tutorial_5.balls.BallGame.height - 30) {
      randY = -randY;
    }
    posYrand += randY;
    posXrand += randX;

    tutorial_5.balls.BallGame.textArea.setText("Ball 1: x=" + (posX + 15) + " y=40\n" + "Ball 2: x=100 y=" + (posY + 15) + "\n" +
      "Ball 3: x=" + (posXrand + 15) + " y=" + (posYrand + 15));

    repaint();
  }
}

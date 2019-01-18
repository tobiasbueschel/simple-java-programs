package tutorial_5.balls;

import java.awt.Color;
import java.awt.Graphics;

public class BallEntity {
	private int size, posX, posY;

	// Constructor for a ball object
	BallEntity() {
		super();
		this.size = 20;
		this.posX = 0;
		this.posY = 0;
	}

	public void move(int x, int y) {

		if ( posX > 400 || posX < 0){
			x = -x;
		}
		System.out.println("X is: " + x);
		System.out.println("posX is: " + posX);

		posY = posY + y;
		posX = posX + x;


	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(posX, posY, size, size);
	}
}

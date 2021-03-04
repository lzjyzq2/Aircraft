package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import base.GameObject;
import base.Resources;
import manager.GameManager;

public class Background extends GameObject {
	
	Rectangle rectangle;
	Rectangle rectangle2;
	BufferedImage image= Resources.backgroundImage;
	BufferedImage image2= Resources.backgroundImage;
	int speed = 100;
	public Background() {
		// TODO Auto-generated constructor stub
		rectangle = new Rectangle(0, 0, image.getWidth(), image.getHeight());
		rectangle2 = new Rectangle(0, -image.getHeight(), image.getWidth(), image.getHeight());
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(image, rectangle.x, rectangle.y, null);
		g.drawImage(image2, rectangle2.x, rectangle2.y, null);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		rectangle.y+=speed*GameManager.deltaTime;
		rectangle2.y+=speed*GameManager.deltaTime;
		if(rectangle.y>=image.getHeight())
			rectangle.y = -image.getHeight();
		if(rectangle2.y>=image.getHeight())
			rectangle2.y = -image.getHeight();
	}
}

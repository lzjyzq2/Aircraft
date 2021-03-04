package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import base.GameObject;

public class Bullet extends GameObject {
	public Point direction;
	public BufferedImage[] image;
	public Shooter shooter;
	public double speed;
	public enum Shooter{
		Player,Enemy
	}
	public Bullet() {
		// TODO Auto-generated constructor stub
	}
	public Bullet(double x,double y,Point direction,Shooter shooter) {
		
	}
	
	
	public Bullet newBullet(double x,double y,Point direction,Shooter shooter) {
		Bullet bullet = null ;
		try {
			bullet = (Bullet) this.clone();
			bullet.x = x;
			bullet.y = y;
			bullet.direction = direction;
			bullet.shooter = shooter;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return bullet;
	}
}

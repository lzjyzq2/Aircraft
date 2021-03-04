package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

import base.GameObject;
import explode.Explode;
import manager.EnemyManager;
import manager.GameManager;

public class Item extends GameObject {
	public BufferedImage image;
	public double speed;
	public Point direction;
	
	public Item newItem(double x,double y,Point direction) {
		Item item = null;
		try {
			item = (Item) this.clone();
			item.x = x;
			item.y = y;
			item.direction = direction;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public void destroy() {
		EnemyManager.instance.removeGameObject(this);
		GameManager.instance.addGameObject(new Explode((int)x, (int)y, (int)width, (int)height));
	}
}

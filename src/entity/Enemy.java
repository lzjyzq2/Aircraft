package entity;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Utils.RandonUtils;
import base.GameObject;
import base.Resources;
import entity.Bullet.Shooter;
import explode.Explode;
import manager.EnemyManager;
import manager.ExplodeManager;
import manager.GameManager;
import manager.ItemManager;

public class Enemy extends GameObject {
	
	public int HP;
	public BufferedImage image;
	public double speed;
	public Point direction;
	public Weapon weapon;
	public int grade;
	public Enemy newEnemy(double x,double y,Point direction) {
		Enemy enemy = null;
		try {
			enemy = (Enemy) this.clone();
			enemy.x = x;
			enemy.y = y;
			enemy.direction = direction;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return enemy;
	}
	
	public void destroy() {
		GameManager.instance.grade +=grade;
		
		int seed = RandonUtils.getRandomInt(100);
		if(seed <15) {
			ItemManager.instance.addGameObject(ItemManager.hpItem.newItem(x, y,direction));
		}else if (seed < 25) {
			ItemManager.instance.addGameObject(ItemManager.bombWeaponItem.newItem(x, y,direction));
		}else if (seed <40) {
			ItemManager.instance.addGameObject(ItemManager.laserWeaponItem.newItem(x, y,direction));
		}

		EnemyManager.instance.removeGameObject(this);
		ExplodeManager.instance.addGameObject(new Explode((int)x, (int)y, (int)width, (int)height));
	}
}

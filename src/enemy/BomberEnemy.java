package enemy;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import base.Resources;
import entity.Enemy;
import entity.Weapon;
import entity.Bullet.Shooter;
import manager.EnemyManager;
import manager.GameManager;
import manager.WeaponManager;
import manager.GameManager.GameState;

public class BomberEnemy extends Enemy {
	
	public BomberEnemy() {
		// TODO Auto-generated constructor stub
		image = Resources.attackerenemyImage;
		speed = 100;
		HP = 10;
		width = image.getWidth();
		height = image.getHeight();
		grade = 10;
		weapon = WeaponManager.normalWeapon.createClone(x, y, Shooter.Enemy);
		weapon.width = 154;
		weapon.height = height;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image,(int)x,(int)y,null);
	}
	@Override
	public void update() {
		x+= direction.getX()*speed*GameManager.deltaTime;
		y+= direction.getY()*speed*GameManager.deltaTime;
		weapon.x = x;
		weapon.y = y;
		weapon.update();

		if(HP<=0) {
			destroy();
		}
		if(bangTest(GameManager.instance.aircraft)) {
			
		}
		if(y>Resources.height) {
			EnemyManager.instance.removeGameObject(this);
		}
	}
	
}

package bullet;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.time.Year;

import javax.lang.model.type.NullType;

import base.Resources;
import entity.Bullet;
import entity.Enemy;
import entity.Bullet.Shooter;
import manager.EnemyBulletManager;
import manager.EnemyManager;
import manager.GameManager;
import manager.PlayerBulletManager;

public class NormalBullet extends Bullet {

	public NormalBullet() {
		image = new BufferedImage[] { Resources.normalbulletImage };
		speed = 500;
		width = 10;
		height = 20;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		if(shooter==Shooter.Player) {
			g.drawImage(image[0], (int)x, (int)y, (int)width, (int)height, null);
		}else {
			g.rotate(0);
			g.drawImage(image[0], (int)x, (int)y, (int)width, (int)height, null);
		}

	}

	@Override
	public void update() {
		x += direction.x * speed*GameManager.deltaTime;
		y += direction.y * speed*GameManager.deltaTime;
		if (shooter == Shooter.Player) {
			for (int i = 0; i < EnemyManager.instance.gameobjects.size(); i++) {
				Enemy enemy = (Enemy) EnemyManager.instance.gameobjects.get(i);
				if (bangTest(enemy)) {
					PlayerBulletManager.instance.removeGameObject(this);
					enemy.HP--;
					return;
				}
			}
			if (y < 0) {
				PlayerBulletManager.instance.removeGameObject(this);
				return;
			}
		} else {
			if(bangTest(GameManager.instance.aircraft)) {
				EnemyBulletManager.instance.removeGameObject(this);
				GameManager.instance.aircraft.HP--;
			}
		}
	}
}

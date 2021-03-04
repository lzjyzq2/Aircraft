package bullet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import base.Resources;
import entity.Bullet;
import entity.Enemy;
import entity.Bullet.Shooter;
import manager.EnemyManager;
import manager.GameManager;
import manager.PlayerBulletManager;

public class LaserBullet extends Bullet {
	public LaserBullet() {
		image = new BufferedImage[] { 
				Resources.laser1,
				Resources.laser2,
				Resources.laser3
				};
		width = 20;
		height = Resources.height;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(image[0], (int)x, (int)y, (int)width, (int)height, null);
	}

	@Override
	public void update() {
		if (shooter == Shooter.Player) {
			for (int i = 0; i < EnemyManager.instance.gameobjects.size(); i++) {
				Enemy enemy = (Enemy) EnemyManager.instance.gameobjects.get(i);
				if (bangTest(enemy)) {
					//PlayerBulletManager.instance.removeGameObject(this);
					enemy.destroy();
					System.out.println("»÷ÖÐµÐ»ú");
					return;
				}
			}
		} 
	}
}

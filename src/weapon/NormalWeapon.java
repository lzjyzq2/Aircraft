package weapon;

import java.awt.Point;

import bullet.NormalBullet;
import entity.Bullet.Shooter;
import entity.Weapon;
import manager.BulletManager;
import manager.EnemyBulletManager;
import manager.GameManager;
import manager.PlayerBulletManager;

public class NormalWeapon extends Weapon {
	//Éä»÷ËÙ¶È
	public double shootspeed = 10;
	public int time = 0;
	public Point playerdir = new Point(0, -1);
	public Point enemydir = new Point(0, 1);

	public NormalWeapon() {
		bullet = BulletManager.normalBullet;
	}

	@Override
	public void update() {
		time++;
		if (time%10==0) {
			if (shooter == Shooter.Player) {
				PlayerBulletManager.instance.addGameObject(bullet.newBullet(x+width/2-bullet.width/2, y-bullet.height, playerdir, shooter));
			} else {
				EnemyBulletManager.instance.addGameObject(bullet.newBullet(x+width/2, y+height, enemydir, shooter));
			}
		}
	}
}

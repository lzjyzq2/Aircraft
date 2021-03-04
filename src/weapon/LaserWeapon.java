package weapon;

import java.awt.Point;

import base.GameObject;
import bullet.NormalBullet;
import entity.Bullet;
import entity.Weapon;
import entity.Bullet.Shooter;
import manager.BulletManager;
import manager.EnemyBulletManager;
import manager.GameManager;
import manager.PlayerBulletManager;
import manager.WeaponManager;

public class LaserWeapon extends Weapon {
	//Éä»÷ËÙ¶È
		public double shootspeed = 10;
		public double time = 0;
		public Point playerdir = new Point(0, -1);
		public Point enemydir = new Point(0, 1);
		
		public Bullet myBullet;
		public LaserWeapon() {
			bullet = BulletManager.laserBullet;
		}

		@Override
		public void update() {
			if(time==0) {
				PlayerBulletManager.instance.addGameObject(myBullet = bullet.newBullet(x+width/2-bullet.width/2, y-bullet.height, playerdir, shooter));
			}
			myBullet.x = x+width/2-bullet.width/2;
			myBullet.y = y-bullet.height;
			time+=10*GameManager.deltaTime;
			if(time>40) {
				
			}
		}
}

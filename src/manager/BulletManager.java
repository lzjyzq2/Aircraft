package manager;

import java.util.ArrayList;
import java.util.List;

import bullet.LaserBullet;
import bullet.NormalBullet;
import entity.Bullet;

public class BulletManager {
	public static BulletManager instance = new BulletManager();
	private BulletManager() {
		
	}
	
	public static NormalBullet normalBullet = new NormalBullet();
	public static LaserBullet laserBullet = new LaserBullet();
}

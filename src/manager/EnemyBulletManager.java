package manager;

import base.GameObjectCollection;

public class EnemyBulletManager extends GameObjectCollection {
	public static EnemyBulletManager instance = new EnemyBulletManager();
	public void init() {
		gameobjects.clear();
	}
}

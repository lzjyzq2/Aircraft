package manager;

import base.GameObjectCollection;

public class PlayerBulletManager extends GameObjectCollection {
	public static PlayerBulletManager instance = new PlayerBulletManager();
	public void init() {
		gameobjects.clear();
	}
}

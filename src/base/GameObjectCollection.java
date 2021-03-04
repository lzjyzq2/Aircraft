package base;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GameObjectCollection extends GameObject {

	public List<GameObject> gameobjects = new ArrayList<GameObject>();

	@Override
	public void draw(Graphics2D g) {
		for (int i = 0; i < gameobjects.size(); i++) {
			GameObject gameObject = gameobjects.get(i);
			if (gameObject != null) {
				gameObject.draw(g);
			}
		}
		// 若在Update时，发生remove，此时迭代器会异常故弃用
//		for (GameObject gameObject : gameobjects) {
//			gameObject.draw(g);
//		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		for (int i = 0; i < gameobjects.size(); i++) {
			GameObject gameObject = gameobjects.get(i);
			if (gameObject != null) {
				gameObject.update();
			}
		}
//若在Update时，发生remove，此时迭代器会异常故弃用
//		for (GameObject gameObject : gameobjects) {
//			gameObject.update();
//		}
	}

	public void addGameObject(GameObject gameObject) {
		if(gameObject!=null) {
			gameobjects.add(gameObject);
		}
	}

	public void removeGameObject(GameObject gameObject) {
		gameobjects.remove(gameObject);
	}
}

package manager;

import java.awt.Graphics2D;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import base.GameObject;
import base.GameObjectCollection;
import base.Resources;
import enemy.BomberEnemy;
import entity.Aircraft;
import entity.Background;
import javazoom.jl.player.Player;
import musicplayer.player;

public class GameManager extends GameObjectCollection {

	public static double fps = 100;
	public static double deltaTime = 1 / fps;
	public static double updateTime = 1000 / fps;
	public GameState gameState = GameState.Wait;

	public Aircraft aircraft;

	public static GameManager instance = new GameManager();

	public long grade = 0;
	
	private GameManager() {
		addGameObject(UIManager.instance);
		Thread thread = new Thread(new player());
		thread.start();
	}
	public void init(){
		grade = 0;
		EnemyManager.instance.init();
		PlayerBulletManager.instance.init();
		EnemyBulletManager.instance.init();
		ItemManager.instance.init();
		ExplodeManager.instance.init();
		aircraft = new Aircraft();
		aircraft.x = (Resources.width - Resources.heroImage.getWidth())/2;
		aircraft.y = Resources.height - Resources.heroImage.getHeight()-Resources.lifepanelImage.getHeight();
		gameobjects.clear();
		addGameObject(new Background());
		addGameObject(aircraft);
		addGameObject(EnemyManager.instance);
		addGameObject(PlayerBulletManager.instance);
		addGameObject(EnemyBulletManager.instance);
		addGameObject(ItemManager.instance);
		addGameObject(ExplodeManager.instance);
		addGameObject(UIManager.instance);
	}
	public void start() {
		init();
		this.gameState = GameState.Run;
	}
	public enum GameState {
		Wait, Run, Pause, End
	}

	@Override
	public void update() {
		switch (gameState) {
		case End:
			break;
		case Wait:

			break;
		case Run:
			for (int i = 0; i < this.gameobjects.size(); i++) {
				GameObject gameObject = gameobjects.get(i);
				if (gameObject != null) {
					gameObject.update();
				}
			}
			break;
		case Pause:
			break;

		default:
			break;
		}
	}
}

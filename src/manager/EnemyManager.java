package manager;

import java.awt.Point;
import java.util.Random;

import Utils.RandonUtils;
import base.GameObject;
import base.GameObjectCollection;
import base.Resources;
import enemy.BomberEnemy;
import enemy.BossEnemy;
import enemy.NormalEnemy;
import entity.Enemy;

public class EnemyManager extends GameObjectCollection {
	public static EnemyManager instance = new EnemyManager();
	
	public static BomberEnemy bomberEnemy = new BomberEnemy();
	public static NormalEnemy normalEnemy = new NormalEnemy();

	public static BossEnemy bossEnemy = new BossEnemy();

	public boolean canCreateBoss = true;
	int bossnum = 1;
	Random random = new Random();
	double next;

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		next += GameManager.deltaTime;
		if (next > 0.5) {
			next = 0;
			int seed = RandonUtils.getRandomInt(100);
			if (seed < 30) {
				addGameObject(bomberEnemy.newEnemy(random.nextInt((int) (Resources.width - bomberEnemy.width)),
						-bomberEnemy.height, new Point(0, 1)));
			} else {
				addGameObject(normalEnemy.newEnemy(random.nextInt((int) (Resources.width - normalEnemy.width)),
						-normalEnemy.height, new Point(0, 1)));
			}

		}
		if (GameManager.instance.grade > 0 && canCreateBoss && GameManager.instance.grade >= 200 * bossnum) {
			canCreateBoss = false;
			addGameObject(bossEnemy.newEnemy(random.nextInt((int) (Resources.width - bossEnemy.width)),
					-bossEnemy.height, new Point(0, 1)));
		}
	}

	public void init() {
		gameobjects.clear();
	}
}

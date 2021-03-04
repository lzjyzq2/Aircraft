package manager;

import base.GameObjectCollection;
import explode.Explode;

public class ExplodeManager extends GameObjectCollection{
	
	public static ExplodeManager instance = new ExplodeManager();
	
	private ExplodeManager() {
		// TODO Auto-generated constructor stub
	}
	public void init() {
		gameobjects.clear();
	}
}

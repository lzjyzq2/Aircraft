package base;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class InputManager extends GameObject implements MouseListener{

	public static InputManager instance = new InputManager();
	private Map<Integer, Boolean> keyMap = new HashMap<Integer, Boolean>();
	private InputManager() {
		// TODO Auto-generated constructor stub
	}
	public void KeyDown(int key) {
		if(keyMap.containsKey(key)) {
			keyMap.replace(key, true);
		}else {
			keyMap.put(key, true);
		}
	}
	public boolean KeyIsDown(int key) {
		boolean flag = false;
		if (keyMap.containsKey(key)) {
			flag = keyMap.get(key);
		}
		return flag;
	}
	public void KeyUp(int key) {
		if(keyMap.containsKey(key)) {
			keyMap.replace(key, false);
		}else {
			keyMap.put(key, false);
		}
	}
//	public boolean KeyIsUp(int key) {
//		boolean flag = true;
//		if (keyMap.containsKey(key)) {
//			flag = keyMap.get(key);
//		}
//		return flag;
//	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

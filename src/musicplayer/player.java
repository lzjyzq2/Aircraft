package musicplayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import base.Resources;
import javazoom.jl.player.Player;

public class player implements Runnable {

	FileInputStream fis;
	BufferedInputStream stream;
	Player player;
	
	@Override
	public void run() {
		try {
			fis = new FileInputStream(Resources.bgm);
			stream = new BufferedInputStream(fis);
			player = new Player(stream);
			player.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

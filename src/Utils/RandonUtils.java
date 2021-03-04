package Utils;

import java.util.Random;

public class RandonUtils {
	public static Random random = new Random();
	
	public static double getRandomDouble() {
		return random.nextDouble();
	}
	
	public static int getRandomInt(int edge) {
		return random.nextInt(edge);
	}
}

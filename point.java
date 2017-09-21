import java.awt.Graphics;
import java.util.Random;

public class point {
	Random rand = new Random();
	public int x = rand.nextInt(Source.WIDTH) + 1;
	public int y = rand.nextInt(Source.HEIGHT) + 1;
	public int label;
	
	public float[] inputs = {
			x,
			y,
			1
	};
	
	public point() {
		if (y > 280) {
			label = 1;
		} else {
			label = -1;
		}
	}
	
	public void show(Graphics g) {
		g.fillOval(x, y, 18, 18);
	}
}
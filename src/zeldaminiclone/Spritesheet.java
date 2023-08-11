package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	public static BufferedImage	spritsheet;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_rigth;
	public static BufferedImage[] enemy_down;
	public static BufferedImage tileWall;
	
	public Spritesheet() {
		try {
			spritsheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		player_up = new BufferedImage[2];
		player_down = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_rigth = new BufferedImage[2];
		enemy_down = new BufferedImage[2];
		
		player_up[0] = Spritesheet.getSprite(0, 11, 16, 16);
		player_up[1] = Spritesheet.getSprite(16, 11, 16, 16);
		
		player_down[0] = Spritesheet.getSprite(69, 11, 16, 16);
		player_down[1] = Spritesheet.getSprite(87, 11, 16, 16);
		
		player_left[0] = Spritesheet.getSprite(201, 259, 16, 16);
		player_left[1] = Spritesheet.getSprite(185, 259, 16, 16);
		
		player_rigth[0] = Spritesheet.getSprite(34, 11, 16, 16);
		player_rigth[1] = Spritesheet.getSprite(51, 11, 16, 16);
		
		enemy_down[0] = Spritesheet.getSprite(148,207,16, 16);
		enemy_down[1] = Spritesheet.getSprite(148+16,207+16,16, 16);
		
		
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int heigth) {
		return spritsheet.getSubimage(x, y, width, heigth);
	}
}

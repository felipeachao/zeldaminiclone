package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpritesheetWall {
	public static BufferedImage	spritsheetWall;
	public static BufferedImage player_front;
	public static BufferedImage tileWall;
	
	public SpritesheetWall() {
		try {
			spritsheetWall = ImageIO.read(getClass().getResource("/wall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tileWall = SpritesheetWall.getSprite(8,8, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int heigth) {
		return spritsheetWall.getSubimage(x, y, width, heigth);
	}
}

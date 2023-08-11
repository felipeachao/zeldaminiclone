package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle {
	
	public int spd = 4;
	public boolean rigth, up, down, left;
	
	public String arrow;
	
	public int curAnimation = 0;
	
	public int curFrames = 0, targetFrames = 15;
	
	public static List<Bullet> bullets = new ArrayList<>();
	
	public boolean shoot = false;
	
	public int dir = 1;
	
	public Player(int x, int y) {
		super(x, y, 32,32);
		
	}
	
	public void tick() {
		boolean moved = false;
		if(rigth && World.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
			arrow = "rigth";
			dir = 1;
		} else if (left && World.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
			arrow = "left";
			dir = -1;
		}
		
		if(up && World.isFree(x, y-spd)) {
			y-=spd;
			moved = true;
			arrow = "up";
		} else if (down && World.isFree(x, y+spd)) {
			y+=spd;
			moved = true;
			arrow = "down";
		}
		
		if(moved) {
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.player_up.length) {
					curAnimation = 0;
				}
			}
		}
		
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x,y, dir));
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
		
	}
	
	public void render(Graphics g) {
		if(arrow == "up") {
			g.drawImage(Spritesheet.player_down[curAnimation], x, y, 32, 32, null);
		} else if (arrow == "down") {			
			g.drawImage(Spritesheet.player_up[curAnimation], x, y, 32, 32, null);
		} else if (arrow == "rigth") {
			g.drawImage(Spritesheet.player_rigth[curAnimation], x, y, 32, 32, null);
		} else if (arrow == "left") {
			g.drawImage(Spritesheet.player_left[curAnimation], x, y, 32, 32, null);
		} else {
			g.drawImage(Spritesheet.player_up[curAnimation], x, y, 32, 32, null);
		}
		for(int i=0; i<bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
}

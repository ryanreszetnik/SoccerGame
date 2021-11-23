import processing.core.PApplet;
import processing.core.PImage;

public class SoccerGameOrigional extends PApplet {
	
	PImage photoBackground, photoGloves, photoOutline, photoSoccer;


	int shotClock = 500;
	boolean shoot = false;
	boolean shot = false;
	float shot_x = random(175, 1336);
	float shot_y = random(215, 730);
	boolean player_shot = false;
	boolean animation_lose = false;
	boolean animation_win = false;
	int restarttimer = 100;
	int score = 0;
	float timer = 200;
	float time_of_level = (timer-80)/frameRate;
	
	
	public static void main(String[] args) {
		// Names our main window Animation
		PApplet.main("SoccerGameOrigional");
	}
	public void settings()
	{
		
		fullScreen();

	}
	public void setup()
	{
		
		frameRate(60);
		photoBackground = loadImage("2hwzed5.jpg");
		photoGloves = loadImage("gloves.png");
		photoOutline = loadImage("Outline.png");
		photoSoccer = loadImage("soccerball.png");
		
	}
	public void draw()
	{ 
		textSize(32);
		text("Score:", width-150, 30);
		
		if (mousePressed == false && player_shot == false)
		{	

			image(photoBackground, 0, 0);
			image(photoGloves, mouseX - 135, mouseY - 95);
			textSize(32);
			text("Score:", width-150, 30);
			shoot = false;
		}
		if (mousePressed == true && player_shot == false)
		{	
			shoot = true;	
			player_shot = true;
			image(photoBackground, 0, 0);
			textSize(32);
			text("Score:", width-150, 30);
			}
		ball();
		shotClock --;
		if(shotClock < 420 && shotClock > 400){

			image(photoOutline, shot_x - 56, shot_y - 68);
			
		}
		if(shotClock < 400 && time_of_level >= 0.010 && shoot == false)
		{
			time_of_level = (timer)/60;
		}
		timer --;
		if(timer < 0 && animation_win == false)
		{
			animation_lose = true;
			player_shot = true;
		}
		
		if(animation_win == true)
		{
			image(photoGloves, shot_x - 135, shot_y - 95);
			image(photoSoccer, shot_x - 80, shot_y - 80);
			textSize(200);
			text("Saved", 0, 200);
			
			restarttimer --;
			
			if(restarttimer < 10)
			{	
			shotClock = 500;
			shoot = false;
			shot = false;
			shot_x = random(175, 1336);
			shot_y = random(215, 730);
			player_shot = false;
			animation_lose = false;
			animation_win = false;
			restarttimer = 100;
			score += 1;
			if (score > 10)
			{
				timer = 140;

			}
			else
			{
			timer = 200 - score * 6;
			}
			time_of_level = (timer-80)/60;
			
			}
			
		}
		if(animation_lose == true)
		{
			image(photoSoccer, shot_x - 80, shot_y - 80);
			textSize(50);
			text("This game sucks why are you even playing it!", 200, 400);
		}
	if(player_shot == false)
		{
		textSize(32);
		text(time_of_level, width /2, height - 50);
	}
		textSize(32);
		text(score, width-50, 30);
		
		 if (keyPressed) {
			    if (key == 'r' || key == 'R') {
			    	shotClock = 500;
			    	shoot = false;
			    	shot = false;
			    	shot_x = random(175, 1336);
			    	shot_y = random(215, 730);
			    	player_shot = false;
			    	animation_lose = false;
			    	animation_win = false;
			    	timer = 200;
			    	restarttimer = 100;
			    	score = 0;
			    	timer = 200;
			    	time_of_level = (timer-80)/60;
			    }
		 }	 
	}
	
	public void ball() {
		if(shoot == true)
		{	
			if(mouseX > shot_x-50 && mouseX < shot_x+50)
			{
				if(mouseY > shot_y-50 && mouseY < shot_y+50)
				{
					animation_win = true;
				}			
			}
			else
			{
				animation_lose = true;
			}
			shoot = false;
		}	
	}
}
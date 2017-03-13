package com.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Rectangle
{
	private static final long serialVersionUID = -1594301247050138060L;
	
	private float speedX;
	private float speedY;
	
	private float prevX, prevY;
	
	public Player() 
	{
		x = 0;//1440 / 2;
		y = 0;//960 / 2;
		width = 16;
		height = 16;
		speedX = 0;
		speedY = 0;
	}
	public Player(float x, float y, float width, float height) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speedX = 150;
		speedY = 150;
	}
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, width, height);
	}
	public void setSpeedX(float speed) 
	{
		speedX = speed;
	}
	public void setSpeedY(float speed) 
	{
		speedY = speed;
	}
	public float getSpeedX() 
	{
		return speedX;
	}
	public float getSpeedY() 
	{
		return speedY;
	}
	public void movePlayer() 
	{
		if (Gdx.input.isKeyPressed(Input.Keys.W)) 
		{
			prevY = y;
			y += speedY;
		}	
		if (Gdx.input.isKeyPressed(Input.Keys.S)) 
		{
			prevY = y;
			y -= speedX;
		}	
		if (Gdx.input.isKeyPressed(Input.Keys.A))
		{
			prevX = x;
			x -= speedX;
		}	
		if (Gdx.input.isKeyPressed(Input.Keys.D))
		{
			prevX = x;
			x += speedX;
		}
		
	}
	public float getPrevX() 
	{
		return prevX;
	}
	public float getPrevY() 
	{
		return prevY;
	}
	public Rectangle getOffsetBounds() 
	{
		return new Rectangle(x + speedX * Gdx.graphics.getDeltaTime(), y + speedY * Gdx.graphics.getDeltaTime(),
							16, 16);
	}
}

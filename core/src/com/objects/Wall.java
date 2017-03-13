package com.objects;

import com.badlogic.gdx.math.Rectangle;

public class Wall extends Rectangle
{
	public Wall(float x, float y, float width, float height) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, width, height);
	}
}

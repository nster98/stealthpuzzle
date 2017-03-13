package com.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class ObjectHandler 
{
	private ArrayList<Wall> walls;
	private ShapeRenderer render;
	private Player player;
	
	public static boolean overlapping = false;
	
	public ObjectHandler() 
	{
		render = new ShapeRenderer();
		render.setAutoShapeType(true);
		
		walls = new ArrayList<Wall>();
		player = new Player();
		
		for (int x = 0; x < 1440; x += 64)
			for (int y = 0; y < 960; y += 64) 
			{
				if (!(x % 128 == 0)) 
				{
					if (!(y % 128 == 0))	
						spawnWalls(x, y, 32, 32);
				}
			}
	}
	public void render() 
	{
		render.begin();
		
		render.set(ShapeType.Filled);
		render.setColor(Color.RED);
		
		for (int i = 0; i < walls.size(); i++) 
		{
			render.rect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
		}
		
		render.set(ShapeType.Filled);
		render.setColor(Color.BLUE);
		render.rect(player.x, player.y, player.width, player.height);
	
		player.movePlayer();
		
		if (Gdx.input.isKeyPressed(Input.Keys.W)) player.setSpeedY(150 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.A)) player.setSpeedX(150 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.S)) player.setSpeedY(150 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.D)) player.setSpeedX(150 * Gdx.graphics.getDeltaTime());
		
		if (player.x < 0) player.x = 0;
		if (player.x > 1440 - 16) player.x = 1440 - 16;
		if (player.y < 0) player.y = 0;
		if (player.y > 960 - 16) player.y = 960 - 16;
		
		for (int i = 0; i < walls.size(); i++)
		{	
			Rectangle tempPlayer = player.getOffsetBounds();
			
			if (tempPlayer.overlaps(walls.get(i)))
			{
				player.x = player.getPrevX();
				player.y = player.getPrevY();
				break;
			}
		}
		
		
		
		
		
		render.end();
	}
	private void spawnWalls(float x, float y, float width, float height) 
	{
		for (int i = 0; i < 300; i++) 
		{
			walls.add(new Wall(x, y, width, height));
		}
	}
}

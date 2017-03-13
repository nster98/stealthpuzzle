package com.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.objects.ObjectHandler;

public class Game extends ApplicationAdapter 
{
	private SpriteBatch batch;
	private ShapeRenderer render;
	private Texture img;
	private OrthographicCamera camera;
	private ObjectHandler handler;
	
	@Override
	public void create () 
	{
		batch = new SpriteBatch();
		render = new ShapeRenderer();
		//img = new Texture("badlogic.jpg");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1440, 960);
		render.setAutoShapeType(true);
		
		handler = new ObjectHandler();
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		render.begin();
		handler.render();
		//batch.draw(img, 0, 0);
		render.end();
		batch.end();
	}
	
	@Override
	public void dispose () 
	{
		batch.dispose();
		//img.dispose();
		render.dispose();
		
	}
}

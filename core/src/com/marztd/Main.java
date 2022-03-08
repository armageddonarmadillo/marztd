package com.marztd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	Random r = new Random();
	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("bg_snow.png"));
		font = new BitmapFont();
	}

	@Override
	public void render () {
		update();

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		font.draw(batch, ""+UI.wave, 15, 575);
		for(Zombie z : zombies) z.draw(batch);
		batch.end();
	}

	public void update(){
		spawn_zombies();

		for(Zombie z : zombies) z.update();

		housekeeping();
	}

	public void housekeeping(){
		for(Zombie z : zombies) if(!z.active) { zombies.remove(z); break; }
	}

	public void spawn_zombies(){
		if(zombies.size() > 0) return;

		UI.wave++;
		for(int i = 0; i < 10; i++){
			zombies.add(new Zombie(1024 + i * 70, r.nextInt(400)));
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

package com.marztd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Zombie {
    int x, y, w, h;
    Texture texture;

    Zombie(int x, int y){
        this.x = x;
        this.y = y;
        w =  35;
        h = 50;
        texture = new Texture(Gdx.files.internal("Zombie.png"));
    }

    void update(){
        x -= 1;
    }

    void draw(SpriteBatch b) {
        b.draw(texture, x, y, w, h);
    }
}

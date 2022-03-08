package com.marztd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Zombie {
    int x, y, w, h;
    Texture texture;
    boolean active = true;

    //Animation Stuff
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time = 0.2f;
    int cols = 4, rows = 1;

    Zombie(int x, int y){
        this.x = x;
        this.y = y;
        texture = new Texture(Gdx.files.internal("Zombies.png"));
        w =  texture.getWidth() / cols;
        h = texture.getHeight() / rows;
        init_animation();
    }

    void init_animation() {
        // splits texture into individual cells
        TextureRegion[][] sheet = TextureRegion.split(texture, w, h);

        // init number of frames to total frames created (vertical + horizontal)
        frames = new TextureRegion[rows * cols];

        // loop thru sheet and fill frames array in order
        int index = 0;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                frames[index++] = sheet[r][c];

            anim = new Animation(frame_time, frames);
    }

    void update(){
        x -= 3;
        active = !(x < -w);
    }

    void draw(SpriteBatch b) {
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frame_time, true);
        b.draw(frame, x, y, w, h);
    }
}

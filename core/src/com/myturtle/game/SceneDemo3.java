package com.myturtle.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;


public class SceneDemo3 implements ApplicationListener {
    public class MyActor extends Actor {
        Texture texture = new Texture("badlogic.jpg");
        public boolean started = false;

        public MyActor(){
            setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
        }

        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(texture,this.getX(),this.getY());
        }
    }
    private Stage stage;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        MyActor myActor = new MyActor();

        MoveToAction moveAction = new MoveToAction();
        moveAction.setPosition(1000f, 0f);
        moveAction.setDuration(5f);
        myActor.addAction(moveAction);

        stage.addActor(myActor);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
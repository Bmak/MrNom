package com.glowman.androidgames.mrnom;

import java.util.List;

import com.glowman.android.framework.Game;
import com.glowman.android.framework.Graphics;
import com.glowman.android.framework.Input.TouchEvent;
import com.glowman.android.framework.Screen;

public class HelpScreen extends Screen {
	private final int HELP_1 = 0;
	private final int HELP_2 = 1;
	private final int HELP_3 = 2;
	
	int selectedHelp = 0;
	
	
	public HelpScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		
		for(int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP) {
				if(event.x > 256 && event.y > 416 ) {
					selectedHelp++;
					if (selectedHelp > HELP_3) {
						selectedHelp = 0;
						game.setScreen(new MainMenuScreen(game));
					}
					if(Settings.soundEnabled) {
						Assets.click.play(1);
						return;
					}
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		switch (selectedHelp) {
			case HELP_1:
				g.drawPixmap(Assets.help1, 64, 100);
				g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
				break;
			case HELP_2:
				g.drawPixmap(Assets.help2, 64, 100);
				g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
				break;
			case HELP_3:
				g.drawPixmap(Assets.help3, 64, 100);
				g.drawPixmap(Assets.buttons, 256, 416, 0, 128, 64, 64);
				break;
		}
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

package com.glowman.androidgames.mrnom;

import com.glowman.android.framework.Screen;
import com.glowman.android.framework.impl.AndroidGame;


public class MrNomGame extends AndroidGame {
	
	@Override
	public Screen getStartScreen() {
		return new LoadingScreen(this);
	}
}

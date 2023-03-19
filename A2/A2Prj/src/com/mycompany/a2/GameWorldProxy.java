package com.mycompany.a2;

public interface GameWorldProxy {
	public int getAntLivesLeft();
    public int getGameClock();
    public IIterator<GameObject> getGameObjectsIterator();
}

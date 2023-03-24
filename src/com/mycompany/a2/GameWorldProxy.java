package com.mycompany.a2;

public interface GameWorldProxy {
	public int getAntLivesLeft();
    public int getGameClock();
    public void setSound();
    public String getSound();
    public void map();
    public IIterator<GameObject> getGameObjectsIterator();
}

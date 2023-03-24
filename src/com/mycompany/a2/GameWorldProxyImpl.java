package com.mycompany.a2;

public class GameWorldProxyImpl {
	private GameWorld gw;
	public GameWorldProxyImpl(GameWorld gw) {
		// TODO Auto-generated constructor stub
		this.gw = gw;
	}
	public int getAntLivesLeft() {
        return gw.getAntLivesLeft();
    }

    public int getGameClock() {
        return gw.getGameClock();
    }
    
    public void setSound() {
    	gw.setSound();
    }
    
    public String getSound() {
    	return gw.getSound();
    }

    public IIterator<GameObject> getGameObjectsIterator() {
        return gw.getGameObjects().getIterator();
    }
    
    public void map() {
    	gw.map();
    }

}

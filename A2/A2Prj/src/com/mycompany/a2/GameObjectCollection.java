package com.mycompany.a2;

import java.util.ArrayList;

public class GameObjectCollection implements ICollection<GameObject> {
	// fields and methods
    private ArrayList<GameObject> collection;
    public GameObjectCollection() {
      collection = new ArrayList<GameObject>();
    }
    public void add(GameObject item) {
      collection.add(item);
    }
    public IIterator<GameObject> getIterator() {
      return new GameObjectIterator();
    }
    
    // private inner class implementing IIterator interface
    private class GameObjectIterator implements IIterator<GameObject> {
        private int currentPosition = 0;
        
      @Override
      public boolean hasNext() {
          return currentPosition < collection.size();
      }

      @Override
      public GameObject getNext() {
          GameObject gameObject = collection.get(currentPosition);
          currentPosition++;
          return gameObject;
      }

      @Override
      public int size() {
          return collection.size();
      }
  
      @Override
      public GameObject elementAt(int index) {
          if (index < 0 || index >= collection.size()) {
              throw new IndexOutOfBoundsException();
          }
          return collection.get(index);
      }
    // rest of the class

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
		
	}
}

}

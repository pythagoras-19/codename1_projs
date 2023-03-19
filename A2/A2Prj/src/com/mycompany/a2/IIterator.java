package com.mycompany.a2;

public interface IIterator<GameObject> {
	boolean hasNext();
	GameObject getNext();
	GameObject elementAt(int index);
	int size();
	void remove();
}

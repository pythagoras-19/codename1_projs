package com.mycompany.a2;

import java.util.ArrayList;

public interface ICollection<GameObject> {
	void add(GameObject item);
	IIterator<GameObject> getIterator();
}

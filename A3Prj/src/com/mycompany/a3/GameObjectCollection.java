package com.mycompany.a3;

import java.util.Vector;

public class GameObjectCollection implements ICollection {
	private Vector<GameObject> objectCollection;
	
	public GameObjectCollection() {
		objectCollection = new Vector<GameObject>();
	}

	@Override
	public void add(GameObject newObject) {
		// TODO Auto-generated method stub
		objectCollection.add(newObject);
		
	}

	@Override
	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new ObjectIterator();
	}
	
	
	//private inner iterator class.
	private class ObjectIterator implements IIterator {
		private int index;
		
		public ObjectIterator() {
			index = -1;
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (objectCollection.size() <= 0 || objectCollection.size() - 1 == index) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public GameObject getNext() {
			// TODO Auto-generated method stub
			index++;
			return objectCollection.get(index);
		}
		
		@Override 
		public void remove(GameObject removeObject) {
			objectCollection.remove(removeObject);
			
		}

	}
	
}

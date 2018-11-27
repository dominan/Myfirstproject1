package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.entities.tile.Tile;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Item extends Tile {
	protected int _duration = -1; // -1 is infinite, duration in lifes
	protected boolean _active = false;
	public Item(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	public abstract void setValues();

	/*(public void removeLive() {
		if(_duration > 0)
			_duration--;

		if(_duration == 0)
			_active = false;
	}*/
}

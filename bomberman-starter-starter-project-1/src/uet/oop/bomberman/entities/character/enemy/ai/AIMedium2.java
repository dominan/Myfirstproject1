package uet.oop.bomberman.entities.character.enemy.ai;

import java.util.List;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium2 extends AI {
	Bomber _bomber;
	Enemy _e;
	List<Bomb> _bombs;
	public AIMedium2(Bomber bomber, Enemy e, Board board) {
		_bomber = bomber;
		_e = e;
                _bombs= board.getBombs();
	}

	@Override
	public int calculateDirection() {
		// TODO: cài đặt thuật toán tìm đư�?ng đi
            for(int i = 0; i <_bombs.size(); i++) {
            if(_bombs.get(i).getXTile() > _e.getXTile()) return 3;
            else if(_bombs.get(i).getXTile() < _e.getXTile()) return 1;
            else if(_bombs.get(i).getYTile() < _e.getYTile()) return 2;
            else
                return 0;
        }
		int vertical = random.nextInt(2);
		if(vertical == 1) {
			int v = calculateRowDirection();
			if(v != -1)
				return v;
			else
				return calculateColDirection();

		} else if(vertical==0){
			int h = calculateColDirection();

			if(h != -1)
				return h;
			else
				return calculateRowDirection();
		}else {
			return random.nextInt(4);
		}
	}
	protected int calculateColDirection() {
		if(_bomber.getXTile() < _e.getXTile())
			return 3;
		else if(_bomber.getXTile() > _e.getXTile())
			return 1;

		return -1;
	}

	protected int calculateRowDirection() {
		if(_bomber.getYTile() < _e.getYTile())
			return 0;
		else if(_bomber.getYTile() > _e.getYTile())
			return 2;
		return -1;
	}
}

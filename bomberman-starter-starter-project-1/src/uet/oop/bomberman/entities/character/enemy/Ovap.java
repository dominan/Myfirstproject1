/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uet.oop.bomberman.entities.character.enemy;

/**
 *
 * @author Minh Anh
 */



import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.character.enemy.ai.AILow;
import uet.oop.bomberman.entities.character.enemy.ai.AIMedium;
import uet.oop.bomberman.graphics.Sprite;

public class Ovap extends Enemy {
	
	public Ovap(int x, int y, Board board) {
		super(x, y, board, Sprite.ovape_dead, Game.getBomberSpeed(), 2000);
		
		_sprite = Sprite.ovape_right1;
		
		_ai = new AILow();
		_direction  = _ai.calculateDirection();
	}
	
	@Override
	protected void chooseSprite() {
        switch (_direction) {
            case 0:
            case 1:
                if (_moving)
                    _sprite = Sprite.movingSprite(Sprite.ovape_right1, Sprite.ovape_right2, Sprite.ovape_right3, _animate, 60);
                else
                    _sprite = Sprite.ovape_left1;
                break;
            case 2:
            case 3:
                if (_moving)
                    _sprite = Sprite.movingSprite(Sprite.ovape_left1, Sprite.ovape_left2, Sprite.ovape_left3, _animate, 60);
                else
                    _sprite = Sprite.ovape_left1;
                break;
        }
    }
}

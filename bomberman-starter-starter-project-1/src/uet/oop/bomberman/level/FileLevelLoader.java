package uet.oop.bomberman.level;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Balloon;
import uet.oop.bomberman.entities.character.enemy.Oneal;
import uet.oop.bomberman.entities.tile.Grass;
import uet.oop.bomberman.entities.tile.Portal;
import uet.oop.bomberman.entities.tile.Wall;
import uet.oop.bomberman.entities.tile.destroyable.Brick;
import uet.oop.bomberman.entities.tile.item.BombItem;
import uet.oop.bomberman.entities.tile.item.FlameItem;
import uet.oop.bomberman.entities.tile.item.SpeedItem;
import uet.oop.bomberman.exceptions.LoadLevelException;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import uet.oop.bomberman.entities.character.enemy.Doll;
import uet.oop.bomberman.entities.character.enemy.Minvo;
import uet.oop.bomberman.entities.character.enemy.Kondoria;
import uet.oop.bomberman.entities.character.enemy.Ovap;
import uet.oop.bomberman.entities.character.enemy.Pass;
public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đ�?c được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;
	
	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) throws LoadLevelException {
		// TODO: đ�?c dữ liệu từ tệp cấu hình /levels/Level{level}.txt
		// TODO: cập nhật các giá trị đ�?c được vào _width, _height, _level, _map

		try{
			URL Path= java.net.URL.class.getResource("/levels/level"+ level+".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(Path.openStream()));
			String s = br.readLine();
			_level=Integer.parseInt(s.substring(0, 1));
			_height=Integer.parseInt(s.substring(2, 4));
			_width=Integer.parseInt(s.substring(5));
			_map= new char[_height][_width];
			String line;
			for(int i=0; i<_height; i++){
				line = br.readLine();
				for(int j=0; j<_width; j++){
					_map[i][j]= line.charAt(j);
				}
			}
			br.close();
		}catch(IOException e){
			return;
		}
	}

	@Override
	public void createEntities() {
		// TODO: tạo các Entity của màn chơi
		// TODO: sau khi tạo xong, g�?i _board.addEntity() để thêm Entity vào game

		// TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
		// TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
		// thêm Wall
		for (int x = 0; x < _width; x++) {
			for (int y = 0; y < _height; y++) {
				int pos = x + y * _width;
				switch (_map[y][x]){
					case '*'://Thêm brick
						int xB = x, yB = y;
						_board.addEntity(xB + yB * _width,
								new LayeredEntity(xB, yB,
										new Grass(xB, yB, Sprite.grass),
										new Brick(xB, yB, Sprite.brick)
								)
						);
						break;
					case '#':
						_board.addEntity(pos, new LayeredEntity(x,y, new Grass(x,y,Sprite.grass), new Wall(x,y,Sprite.wall)));
						break;
					case 'p'://thêm Bomber
						int xBomber = y, yBomber = x;
						_board.addCharacter( new Bomber(Coordinates.tileToPixel(xBomber), Coordinates.tileToPixel(yBomber) + Game.TILES_SIZE, _board) );
						Screen.setOffset(0, 0);
						_board.addEntity(xBomber + yBomber * _width, new Grass(xBomber, yBomber, Sprite.grass));
						break;
					case '1'://thêm Ballon
						int xE = x, yE = y;
						_board.addCharacter( new Balloon(Coordinates.tileToPixel(xE), Coordinates.tileToPixel(yE) + Game.TILES_SIZE, _board));
						_board.addEntity(xE + yE * _width, new Grass(xE, yE, Sprite.grass));
						break;

					case 'f'://thêm FlameItem
						int xI = x, yI = y;
						_board.addEntity(xI + yI * _width,
								new LayeredEntity(xI, yI,
										new Grass(xI ,yI, Sprite.grass),
										new FlameItem(xI, yI, Sprite.powerup_flames),
										new Brick(xI, yI, Sprite.brick)
								)
						);
						break;
					case 's'://thêm Speeditem
						int xS = x, yS = y;
						_board.addEntity(xS + yS * _width,
								new LayeredEntity(xS, yS,
										new Grass(xS ,yS, Sprite.grass),
										new SpeedItem(xS, yS, Sprite.powerup_speed),
										new Brick(xS, yS, Sprite.brick)
								)
						);
						break;
					case 'b'://thêm Bombitem
						int xb = x, yb = y;
						_board.addEntity(xb + yb * _width,
								new LayeredEntity(xb, yb,
										new Grass(xb ,yb, Sprite.grass),
										new BombItem(xb, yb, Sprite.powerup_bombs),
										new Brick(xb, yb, Sprite.brick)
								)
						);
						break;
					case 'x'://Thêm Portal
						int xP = x, yP = y;
						_board.addEntity(xP + yP * _width,
								new LayeredEntity(xP, yP,
										new Grass(xP ,yP, Sprite.grass),
										new Portal(xP, yP, Sprite.portal,_board),
										new Brick(xP, yP, Sprite.brick)
								)
						);
						break;
					case '2':
						int xO = x, yO = y;
						_board.addCharacter( new Oneal(Coordinates.tileToPixel(xO), Coordinates.tileToPixel(yO) + Game.TILES_SIZE, _board));
						_board.addEntity(xO + yO * _width, new Grass(xO, yO, Sprite.grass));
						break;
                                        case '4':
						int xM = x, yM = y;
						_board.addCharacter( new Minvo(Coordinates.tileToPixel(xM), Coordinates.tileToPixel(yM) + Game.TILES_SIZE, _board));
						_board.addEntity(xM + yM * _width, new Grass(xM, yM, Sprite.grass));
						break;
                                        case '3':
						int xD = x, yD = y;
						_board.addCharacter( new Doll(Coordinates.tileToPixel(xD), Coordinates.tileToPixel(yD) + Game.TILES_SIZE, _board));
						_board.addEntity(xD + yD * _width, new Grass(xD, yD, Sprite.grass));
						break;
                                        case '5':
						int xK = x, yK = y;
						_board.addCharacter( new Kondoria(Coordinates.tileToPixel(xK), Coordinates.tileToPixel(yK) + Game.TILES_SIZE, _board));
						_board.addEntity(xK + yK * _width, new Grass(xK, yK, Sprite.grass));
						break;
                                        case '6':
                                            int xOv = x, yOv = y;
						_board.addCharacter( new Ovap(Coordinates.tileToPixel(xOv), Coordinates.tileToPixel(yOv) + Game.TILES_SIZE, _board));
						_board.addEntity(xOv + yOv * _width, new Grass(xOv, yOv, Sprite.grass));
						break;
                                        case '7':
                                            int xPa = x, yPa = y;
						_board.addCharacter( new Pass(Coordinates.tileToPixel(xPa), Coordinates.tileToPixel(yPa) + Game.TILES_SIZE, _board));
						_board.addEntity(xPa + yPa * _width, new Grass(xPa, yPa, Sprite.grass));
						break;
					default:
						_board.addEntity(pos, new Grass(x, y, Sprite.grass));
						break;
				}
			}
		}                    						
	}

}

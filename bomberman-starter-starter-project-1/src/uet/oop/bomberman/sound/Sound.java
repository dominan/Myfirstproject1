package uet.oop.bomberman.sound;



import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class Sound {
    public static Sound instance;

    public static final String Menu = "menu.wav";
    public static final String PlayGame = "playgame.mid";
    public static final String Bomb = "newbomb.wav";
    public static final String BomberDie = "bomber_die.wav";
    public static final String EnemyDie = "monster_die.wav";
    public static final String BombBang = "bomb_bang.wav";
    private HashMap<String, AudioClip> audio;

    public static Sound getInstance(){
        if(instance == null){
            instance = new Sound();
        }
        return instance;
    }

    public Sound(){
        audio = new HashMap<>();
        loadAllAudio();
    }

    public void loadAllAudio(){
        putAudio(PlayGame);
        putAudio(Bomb);
        putAudio(BombBang);
        putAudio(BomberDie);
        putAudio(EnemyDie);
    }

    public void putAudio(String name){
        try{
        AudioClip au = Applet.newAudioClip(Sound.class.getResource("/sound/"+name));
        audio.put(name, au);}catch (NullPointerException e){
            System.out.println("loi");
        }
    }

    public AudioClip getAudio(String name){
        return audio.get(name);
    }

    public void stop(){
        getAudio(PlayGame).stop();
    }

    public static void main(String[] args) {

        Sound.getInstance().getAudio(Sound.PlayGame).loop();
    }
}

package uet.oop.bomberman.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class Sound {
    public static Sound instance;
    public static final String Menu = "menu.wav";
    public static final String PlayGame = "play.wav";
    public static final String Bomb = "newbomb.wav";
    public static final String BomberDie = "bomber_die.wav";
    public static final String EnemyDie = "monster_die.wav";
    public static final String BombBang = "bomb_bang.wav";
    public static final String Oversound = "over.wav";
    
    public static final String Winsound = "win.wav";
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
        putAudio(Oversound);
        putAudio(Winsound);
    }

    public void putAudio(String name){

            AudioClip au = Applet.newAudioClip(Sound.class.getResource("/sound/"+name));
            audio.put(name, au);

    }

    public AudioClip getAudio(String name){
        return audio.get(name);
    }

    public void stop(){
        getAudio(PlayGame).stop();
    }
}

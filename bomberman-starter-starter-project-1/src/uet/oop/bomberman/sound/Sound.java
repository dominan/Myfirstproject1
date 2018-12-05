package uet.oop.bomberman.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class Sound {
    public static Sound instance;   
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
        AudioClip au = Applet.newAudioClip(Sound.class.getResource("/sound/"+PlayGame));
        audio.put(PlayGame, au);
        AudioClip au1 = Applet.newAudioClip(Sound.class.getResource("/sound/"+Bomb));
        audio.put(Bomb, au1);
        AudioClip au2 = Applet.newAudioClip(Sound.class.getResource("/sound/"+BombBang));
        audio.put(BombBang, au2);
        AudioClip au3 = Applet.newAudioClip(Sound.class.getResource("/sound/"+BomberDie));
        audio.put(BomberDie, au3);
        AudioClip au4 = Applet.newAudioClip(Sound.class.getResource("/sound/"+EnemyDie));
        audio.put(EnemyDie, au4);
        AudioClip au5 = Applet.newAudioClip(Sound.class.getResource("/sound/"+Oversound));
        audio.put(Oversound, au5);
        AudioClip au6 = Applet.newAudioClip(Sound.class.getResource("/sound/"+Winsound));
        audio.put(Winsound, au6);       
    }
    public AudioClip getAudio(String name){
        return audio.get(name);
    }

}

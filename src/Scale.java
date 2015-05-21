import java.util.LinkedList;

/**
 * Created by Lovisa on 2015-05-19.
 */
public class Scale {
    private LinkedList<String> whiteScale;
    private LinkedList<String> blackScale;

    public Scale(){
    	whiteScale = new LinkedList<String>();
        for(int i = 3; i < 6; i++) {
            whiteScale.add("audio/c" + i + ".mp3");
            whiteScale.add("audio/d" + i + ".mp3");
            whiteScale.add("audio/e" + i + ".mp3");
            whiteScale.add("audio/f" + i + ".mp3");
            whiteScale.add("audio/g" + i + ".mp3");
            whiteScale.add("audio/a" + i + ".mp3");
            whiteScale.add("audio/b" + i + ".mp3");
        }

        blackScale = new LinkedList<String>();
        for(int i = 3; i < 6; i++){
            blackScale.add("audio/cc" + i + ".mp3");
            blackScale.add("audio/dd" + i + ".mp3");
            blackScale.add("audio/ff" + i + ".mp3");
            blackScale.add("audio/gg" + i + ".mp3");
            blackScale.add("audio/aa" + i + ".mp3");
        }

    }

    public LinkedList<String> getWhiteScale () {
        return whiteScale;
    }

    public LinkedList<String> getBlackScale () {
        return blackScale;
    }

}
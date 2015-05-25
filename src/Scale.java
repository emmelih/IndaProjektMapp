import java.util.LinkedList;

/**
 * A class that saves the fileadresses for the notes in two separate linkedlists. One for the black keys and one for the white keys. This is made in a separate clas to make the KeybaordGUI class a little smaller.
 * 
 * @author Lovisa von Heine and Emmeli Hanson 
 * @date 2015-05-19.
 */
public class Scale {
    private LinkedList<String> whiteScale;
    private LinkedList<String> blackScale;

    /**
     * Constructor, in which the LinkedLists are initialized and created.
     */
    public Scale(){
    	//For the white keys
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

        //For the black keys
        blackScale = new LinkedList<String>();
        for(int i = 3; i < 6; i++){
            blackScale.add("audio/cc" + i + ".mp3");
            blackScale.add("audio/dd" + i + ".mp3");
            blackScale.add("audio/ff" + i + ".mp3");
            blackScale.add("audio/gg" + i + ".mp3");
            blackScale.add("audio/aa" + i + ".mp3");
        }

    }

    /**
     * Method that returns the list of fileadresses (Strings) for the white notes.
     * 
     * @return blackScale The linkedList for the white notes.
     */
    public LinkedList<String> getWhiteScale () {
        return whiteScale;
    }
    
    /**
     * Method that returns the list of fileadresses (Strings) for the black notes.
     * 
     * @return blackScale The linkedList for the black notes.
     */

    public LinkedList<String> getBlackScale () {
        return blackScale;
    }

}

import java.util.LinkedList;


/**
 * This class records and plays the keyboardkeys pressed.
 * 
 * @author emmeli
 *
 */
public class Recorder{
	
	boolean recording;
	boolean playing;
	LinkedList<String> recorded;
	LinkedList<String> toPlay;
	MusicPlayer player;
	
	/**
	 * Contstructor. Creates a Recorder with a given MusicPlayer as argument.
	 * 
	 * @param player The given MusicPLayer to be used for playing.
	 */
	public Recorder(MusicPlayer player){
		
		this.player = player;
		recorded = new LinkedList<String>();
		toPlay = new LinkedList<String>();
		recording = false;
		playing = false;
		
	}
	
	/**
	 * Starts and stops recording depending on if the boolean recorded
	 * is true or false. 
	 * 
	 */
	public void startStopRecording(){
		//start recording
		if (recording == false){
			recording = true;
		}
		//stop recording
		else if(recording == true){
			recording = false;
			
		}
	}
	
	/**
	 * Returns the boolean recording so that the KeyboardGUI can know if notes 
	 * are to be recorded or not (and if possible start a blinking red dot).
	 * 
	 * 
	 * @return recording True if notes are being recorded, if not false.
	 */
	public boolean getIfRecording(){
		return recording;
	}
	
	/**
	 * Saves the filenames of the played keys in a linked list.
	 * 
	 * @param filename The filename of the note to be saved.
	 */
	public void saveNotes(String filename){
		recorded.add(filename);
		
	}
	
	/**
	 * Plays recorded notes from recorded list and changes the playing boolean to true if
	 * something is playing.
	 * 
	 */
	public void playRecorded(){
			playing = true;
			player.startPlaying(recorded, 50);
	}
	
	public void stopPlaying(){
		player.stop();
		playing = false;
	}
	
	/**
	 * To check if the recorded list is playing.
	 * @return playing True if something is playing.
	 */
	public boolean getPlaying(){
		return playing;
	}
	
	/**
	 * Clears the recorded list.
	 */
	public void clearRecording(){
		recorded.clear();
	}
}
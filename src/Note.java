/**
 * Created by Lovisa on 2015-05-18.
 */
public class Note {
    private String filename;

    /**
     * Constructor
     * @param filename
     */
    public Note(String filename) {
        setFile(filename);
    }

    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Set filename
     * @param filename
     */
    private void setFile(String filename) {
        this.filename = filename;
    }
}

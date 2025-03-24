import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    // Test the constructor to ensure correct initialisation
    @Test
    public void testConstructor() {
        Song song = new Song("Ed Sheeran", "Shape of You");
        // Check that the artist and title are correctly set
        assertEquals("Ed Sheeran", song.getArtist(), "Artist should be Ed Sheeran");
        assertEquals("Shape of You", song.getTitle(), "Title should be Shape of You");
        // Check that the play count is a random value (between 0 and 999)
        assertTrue(song.getPlayCount() >= 0 && song.getPlayCount() < 1000, "Play count should be between 0 and 999");
    }

    // Test the play() method to check if play count increments correctly
    @Test
    public void testPlay() {
        Song song = new Song("Ed Sheeran", "Shape of You");
        int initialPlayCount = song.getPlayCount();
        song.play();  // Simulate playing the song
        assertEquals(initialPlayCount + 1, song.getPlayCount(), "Play count should increment by 1");
    }

    // Test the toString() method to check if it returns the correct string representation
    @Test
    public void testToString() {
        Song song = new Song("Ed Sheeran", "Shape of You");
        String expectedString = "Artist: Ed Sheeran, Title: Shape of You, Plays: " + song.getPlayCount();
        assertEquals(expectedString, song.toString(), "toString should return the correct string representation");
    }

    // Test the getter methods to ensure they return correct values
    @Test
    public void testGetArtist() {
        Song song = new Song("Ed Sheeran", "Shape of You");
        assertEquals("Ed Sheeran", song.getArtist(), "Artist should be Ed Sheeran");
    }

    @Test
    public void testGetTitle() {
        Song song = new Song("Ed Sheeran", "Shape of You");
        assertEquals("Shape of You", song.getTitle(), "Title should be Shape of You");
    }

    @Test
    public void testGetPlayCount() {
        Song song = new Song("Ed Sheeran", "Shape of You");
        assertTrue(song.getPlayCount() >= 0 && song.getPlayCount() < 1000, "Play count should be between 0 and 999");
    }
}
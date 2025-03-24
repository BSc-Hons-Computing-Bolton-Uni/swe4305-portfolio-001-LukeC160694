import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
// Represents a song with an artist, title, and play count
class Song {
    private String artist;
    private String title;
    private int playCount;

    // Constructor initialises artist, title, and sets play count to a random value
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
        this.playCount = new Random().nextInt(1000); // Random play count between 0 and 999
    }

    // Getter methods
    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayCount() {
        return playCount;
    }

    // Simulates playing a song by increasing play count
    public void play() {
        playCount++;
    }

    // Returns a string representation of the song
    @Override
    public String toString() {
        return "Artist: " + artist + ", Title: " + title + ", Plays: " + playCount;
    }
}

// Represents a playlist of songs
class Playlist {
    private String name;
    private ArrayList<Song> playlistSongs;

    public Playlist(String name) {
        this.name = name;
        this.playlistSongs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        playlistSongs.add(song);
    }

    public void viewSongs() {
        if (playlistSongs.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Songs in Playlist: " + name);
            for (Song song : playlistSongs) {
                System.out.println(song);
            }
        }
    }

    public void playSong(String title) {
        for (Song song : playlistSongs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                song.play();
                System.out.println("Playing from playlist: " + song);
                return;
            }
        }
        System.out.println("Song not found in the playlist.");
    }
}

// Main class for managing the music streaming service
public class Main {
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlists;
    private Scanner scanner;

    // Constructor initialises the song list and scanner
    public Main() {
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        scanner = new Scanner(System.in);
        addDefaultSongs();
    }

    // Adds default songs with random play counts
    private void addDefaultSongs() {
        songs.add(new Song("The Weeknd", "Blinding Lights"));
        songs.add(new Song("Lady Gaga & Bruno Mars", "Die With A Smile"));
        songs.add(new Song("Harry Styles", "As It Was"));
        songs.add(new Song("Kendrick Lemar & SZA", "Luther"));
        songs.add(new Song("Ed Sheeran", "Shape of You"));
        songs.add(new Song("Billie Eilish", "Bad Guy"));
        songs.add(new Song("Drake", "God's Plan"));
        songs.add(new Song("Juice WRLD", "Lucid Dreams"));
        songs.add(new Song("Chase & Status & Stormzy", "BACKBONE"));
        songs.add(new Song("Post Malone", "Circles"));
    }

    // Allows the user to add a new song
    public void addSong() {
        System.out.print("Enter artist name: ");
        String artist = scanner.nextLine();
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();
        songs.add(new Song(artist, title));
        System.out.println("Song added successfully!");
    }

    // Allows the user to remove a song by title
    public void removeSong() {
        System.out.print("Enter song title to remove: ");
        String title = scanner.nextLine();
        Iterator<Song> iterator = songs.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Song removed successfully!");
                return;
            }
        }
        System.out.println("Song not found.");
    }

    // Prints all songs in the list
    public void printAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the list.");
            return;
        }
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    // Prints songs that have more than a specified number of plays
    public void printSongsOverPlays() {
        System.out.print("Enter minimum number of plays: ");
        int minPlays = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean found = false;
        for (Song song : songs) {
            if (song.getPlayCount() > minPlays) {
                System.out.println(song);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found with more than " + minPlays + " plays.");
        }
    }

    // Simulates playing a song by increasing its play count
    public void playSong() {
        System.out.print("Enter song title to play: ");
        String title = scanner.nextLine();
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                song.play();
                System.out.println("Playing: " + song);
                return;
            }
        }
        System.out.println("Song not found.");
    }

    // Creates a new playlist
    public void createPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        playlists.add(new Playlist(name));
        System.out.println("Playlist created successfully!");
    }

    // Adds a song to a playlist
    public void addSongToPlaylist() {
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        Playlist playlist = findPlaylistByName(playlistName);
        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.print("Enter song title to add: ");
        String title = scanner.nextLine();
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                playlist.addSong(song);
                System.out.println("Song added to playlist.");
                return;
            }
        }
        System.out.println("Song not found in library.");
    }

    // Views songs in a playlist
    public void viewPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        Playlist playlist = findPlaylistByName(name);
        if (playlist != null) {
            playlist.viewSongs();
        } else {
            System.out.println("Playlist not found.");
        }
    }

    // Plays a song from a playlist
    public void playFromPlaylist() {
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        Playlist playlist = findPlaylistByName(playlistName);
        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.print("Enter song title to play: ");
        String title = scanner.nextLine();
        playlist.playSong(title);
    }

    // Helper method to find a playlist by name
    private Playlist findPlaylistByName(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(name)) {
                return playlist;
            }
        }
        return null;
    }

    // Displays the menu and handles user input
    public void menu() {
        while (true) {
            System.out.println("\nMusic Streaming Service");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Print All Songs");
            System.out.println("4. Print Songs Over X Plays");
            System.out.println("5. Play a Song");
            System.out.println("6. Exit");
            System.out.println("7. Create Playlist");
            System.out.println("8. Add Song to Playlist");
            System.out.println("9. View Playlist");
            System.out.println("10. Play Song from Playlist");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addSong();
                case 2 -> removeSong();
                case 3 -> printAllSongs();
                case 4 -> printSongsOverPlays();
                case 5 -> playSong();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                case 7 -> createPlaylist();
                case 8 -> addSongToPlaylist();
                case 9 -> viewPlaylist();
                case 10 -> playFromPlaylist();
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        Main app = new Main();
        app.menu();
    }
}

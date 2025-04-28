package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * 
 * @author
 */
public class SongList {
    private static SongList instance; // Singleton instance
    private static ArrayList<Song> songs; // List of songs

    /**
     * Private constructor to prevent instantiation
     */
    private SongList() {
        // Initialize songs list by fetching data from the DataLoader
        songs = DataLoader.getSongs();
        if (songs == null) {
            songs = new ArrayList<>();
        }
    }

    /**
     * Public method to get the singleton instance of SongList
     * 
     * @return the single instance of SongList
     */
    public static SongList getInstance() {
        if (instance == null) {
            instance = new SongList();
        }
        return instance;
    }

    /**
     * Method to get the list of songs
     * 
     * @return the list of songs
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Method to get a song by its title
     * 
     * @param title the title of the song
     * @return the song with the given title, or null if not found
     */
    public Song getSongByTitle(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }

    /**
     * Adds a new song to the list
     * 
     * @param id              the song ID
     * @param title           the song title
     * @param artist          the song artist
     * @param author          the song author
     * @param genre           the song genre
     * @param duration        the song duration
     * @param tempo           the song tempo
     * @param defTimeSigNumer the default time signature numerator
     * @param defTimeSigDenom the default time signature denominator
     * @param defKeySig       the default key signature
     * @param measureList     the list of measures for the song
     * @return the newly created song
     */
    public Song addSong(UUID id,
            String title,
            String artist,
            UUID author,
            String genre,
            String duration,
            String tempo,
            int defTimeSigNumer,
            int defTimeSigDenom,
            KeySig defKeySig,
            ArrayList<Measure> measureList) {
        Song newSong = new Song(id, title, artist, author, genre, duration, tempo, defTimeSigNumer, defTimeSigDenom,
                defKeySig, measureList);
        songs.add(newSong); // Add the new song to the list
        return newSong;
    }

    /**
     * Plays a chosen song using JFugue Player
     * 
     * @param chosenSong the song to be played
     */
    public void playSong(Song chosenSong) {
        try {
            Player player = new Player();
            Pattern songPattern = new Pattern();
            songPattern.setTempo(Integer.parseInt(chosenSong.getTempo()));
            songPattern.setInstrument("piano"); // Set the instrument to piano
            for (Measure measure : chosenSong.getMeasureList()) {
                for (Note note : measure.getNoteList()) {
                    songPattern.add(note.getPitch().toString() + note.getAccidental().toString() + note.getOctave()
                            + note.getLength());
                }
                Measure.getNotePlacement(measure);
            }
            player.play(songPattern); // Play the song
        } catch (Exception e) {
            System.out.println("Problem encountered while playing the song.");
        }
    }

    /**
     * Get a list of song titles by a specific artist
     * 
     * @param artist the artist name
     * @return a list of songs by the artist
     */
    public ArrayList<Song> getSongTitlesWithArtist(String artist) {
        ArrayList<Song> matchingArtistSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                matchingArtistSongs.add(song);
            }
        }
        return matchingArtistSongs;
    }

    /**
     * Get a list of song titles
     * 
     * @return a string representation of song titles
     */
    public String getSongTitles() {
        StringBuilder songTitles = new StringBuilder();
        for (Song song : songs) {
            songTitles.append("\n").append(song.getTitle());
        }
        return songTitles.toString();
    }

    /**
     * Save songs to persistent storage
     */
    public void saveSongs() {
        DataWriter.saveSongs(songs); // Call DataWriter to save songs
    }
}
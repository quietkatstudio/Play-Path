package com.frost_byte;

import java.util.ArrayList;
import java.util.List;

import com.model.Accidentals;
import com.model.Measure;
import com.model.Song;
import com.model.SongList;
import com.model.Note;
import com.model.Pitches;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PlaySongController {

    @FXML
    private Label songTitle;

    @FXML
    private Label songArtist;

    @FXML
    private Button playButton;

    @FXML
    private ImageView tubaImage;

    private Song currentSong;
    private Timeline animationTimeline;

    @FXML
    public void initialize() {
        System.out.println("PlaySongController loaded!");
        playButton.setOnAction(event -> {
            System.out.println("HERE IS OUR TEMPO! " + currentSong.getTempo());
            playSong(currentSong);
            startTubaAnimation();
        });
    }

    public void setSong(Song song) {
        if (song != null) {
            songTitle.setText(song.getTitle());
            songArtist.setText(song.getArtist());
            currentSong = song;
        }
    }

    private void playSong(Song song) {
        if (song != null) {
            System.out.println("Trying to play song: " + song.getTitle());
            Thread musicThread = new Thread(() -> {
                currentSong.setTempo(currentSong.getTempo());
                SongList.getInstance().playSong(song);
            });
            musicThread.start();
        }
    }

    private void startTubaAnimation() {
        if (animationTimeline != null) {
            animationTimeline.stop();
        }

        List<Note> allNotes = new ArrayList<>();

        if (currentSong != null && currentSong.getMeasureList() != null) {
            for (Measure measure : currentSong.getMeasureList()) {
                allNotes.addAll(measure.getNoteList());
            }
        }

        animationTimeline = new Timeline();

        double cumulativeTime = 0.0; // in seconds

        for (Note note : allNotes) {
            final Note currentNote = note;

            animationTimeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(cumulativeTime),
                            event -> {
                                System.out.println("Current note: " + currentNote.getPitch() + currentNote.getOctave());
                                updateTubaImageBasedOnNote(currentNote);
                            }));

            // Update cumulativeTime based on the note's duration
            // Assuming your Note class has a getDuration() method returning a double in
            // seconds
            cumulativeTime += note.getDurationInSeconds(Integer.parseInt(currentSong.getTempo()));
        }

        animationTimeline.setCycleCount(1);
        animationTimeline.play();
    }

    private void updateTubaImageBasedOnNote(Note note) {
        String binaryFilename = mapNoteToBinaryFilename(note);
        try {
            Image newImage = new Image(getClass().getResource("/images/" + binaryFilename + ".PNG").toExternalForm());
            tubaImage.setImage(newImage);
            System.out.println("Updated tuba image to: " + binaryFilename + ".PNG");
        } catch (Exception e) {
            System.out.println("Failed to load image for: " + binaryFilename);
            e.printStackTrace();
        }
    }

    /**
     * Maps a Note to a binary filename based on its pitch, accidental, and octave.
     */
    private String mapNoteToBinaryFilename(Note note) {
        Pitches pitch = note.getPitch();
        int octave = note.getOctave();
        String accidental = note.getAccidental();

        // Using switch-case to handle flats, sharps, and naturals for each pitch and
        // octave
        switch (accidental) {
            case "B": // Flat notes
                switch (pitch) {
                    case C:
                        if (octave == 2)
                            return "111";
                        else if (octave == 3)
                            return "110";
                        else if (octave == 4)
                            return "110";
                        break;
                    case D:
                        if (octave == 2)
                            return "011";
                        else if (octave == 3)
                            return "010";
                        else if (octave == 4)
                            return "010";
                        break;
                    case E:
                        if (octave == 2)
                            return "100";
                        else if (octave == 3)
                            return "100";
                        else if (octave == 4)
                            return "100";
                        break;
                    case F:
                        if (octave == 2)
                            return "010";
                        else if (octave == 3)
                            return "010";
                        else if (octave == 4)
                            return "010";
                        break;
                    case G:
                        if (octave == 2)
                            return "011";
                        else if (octave == 3)
                            return "011";
                        else if (octave == 4)
                            return "011";
                        break;
                    case A:
                        if (octave == 2)
                            return "100";
                        else if (octave == 3)
                            return "100";
                        else if (octave == 4)
                            return "100";
                        break;
                    case B:
                        if (octave == 2)
                            return "000";
                        else if (octave == 3)
                            return "000";
                        else if (octave == 4)
                            return "000";
                        break;
                    default:
                        return "000";
                }
                break;

            case "#": // Sharp notes
                switch (pitch) {
                    case C:
                        if (octave == 2)
                            return "011";
                        else if (octave == 3)
                            return "010";
                        else if (octave == 4)
                            return "010";
                        break;
                    case D:
                        if (octave == 2)
                            return "100";
                        else if (octave == 3)
                            return "100";
                        else if (octave == 4)
                            return "100";
                        break;
                    case E:
                        if (octave == 2)
                            return "000";
                        else if (octave == 3)
                            return "000";
                        else if (octave == 4)
                            return "000";
                        break;
                    case F:
                        if (octave == 2)
                            return "011";
                        else if (octave == 3)
                            return "011";
                        else if (octave == 4)
                            return "011";
                        break;
                    case G:
                        if (octave == 2)
                            return "100";
                        else if (octave == 3)
                            return "100";
                        else if (octave == 4)
                            return "100";
                        break;
                    case A:
                        if (octave == 2)
                            return "000";
                        else if (octave == 3)
                            return "000";
                        else if (octave == 4)
                            return "000";
                        break;
                    case B:
                        if (octave == 2)
                            return "101";
                        else if (octave == 3)
                            return "100";
                        else if (octave == 4)
                            return "100";
                        break;
                    default:
                        return "000";
                }
                break;

            default: // Natural notes
                switch (pitch) {
                    case C:
                        if (octave == 2)
                            return "101";
                        else if (octave == 3)
                            return "100";
                        else if (octave == 4)
                            return "100";
                        break;
                    case D:
                        if (octave == 2)
                            return "110";
                        else if (octave == 3)
                            return "000";
                        else if (octave == 4)
                            return "000";
                        break;
                    case E:
                        if (octave == 2)
                            return "010";
                        else if (octave == 3)
                            return "010";
                        else if (octave == 4)
                            return "010";
                        break;
                    case F:
                        if (octave == 2)
                            return "101";
                        else if (octave == 3)
                            return "000";
                        else if (octave == 4)
                            return "000";
                        break;
                    case G:
                        if (octave == 2)
                            return "110";
                        else if (octave == 3)
                            return "110";
                        else if (octave == 4)
                            return "110";
                        break;
                    case A:
                        if (octave == 2)
                            return "010";
                        else if (octave == 3)
                            return "010";
                        else if (octave == 4)
                            return "010";
                        break;
                    case B:
                        if (octave == 2)
                            return "111";
                        else if (octave == 3)
                            return "110";
                        else if (octave == 4)
                            return "110";
                        break;
                    default:
                        return "000";
                }
                break;
        }

        return "000"; // Default value in case no match is found
    }

}

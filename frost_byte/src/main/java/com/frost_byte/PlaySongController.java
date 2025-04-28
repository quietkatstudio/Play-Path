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

        // Collect all notes from all measures
        if (currentSong != null && currentSong.getMeasureList() != null) {
            for (Measure measure : currentSong.getMeasureList()) {
                allNotes.addAll(measure.getNoteList());
            }
        }

        animationTimeline = new Timeline();

        for (int i = 0; i < allNotes.size(); i++) {
            final int noteIndex = i;
            animationTimeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(i),
                            event -> {
                                Note currentNote = allNotes.get(noteIndex);
                                System.out.println("Current note: " + currentNote.getPitch() + currentNote.getOctave());
                                updateTubaImageBasedOnNote(currentNote);
                            }));
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
     * Maps a note to its tuba binary valve combination (e.g., 010, 101, etc.)
     */
    private String mapNoteToBinaryFilename(Note note) {
        // Retrieve the pitch and octave of the note
        Pitches pitch = note.getPitch();
        int octave = note.getOctave();
        String accidental = note.getAccidental();
        if (accidental.equals("B")) {
            if (pitch == Pitches.C) {
                if (octave == 1)
                    return "000"; // Cb1
                if (octave == 2)
                    return "000"; // Cb2
                if (octave == 3)
                    return "000"; // Cb3
                if (octave == 4)
                    return "000"; // Cb4
                if (octave == 5)
                    return "010"; // Cb5
            } else if (pitch == Pitches.D) {
                if (octave == 1)
                    return "010"; // Db1
                if (octave == 2)
                    return "010"; // Db2
                if (octave == 3)
                    return "010"; // Db3
                if (octave == 4)
                    return "010"; // Db4
                if (octave == 5)
                    return "010"; // Db5
            } else if (pitch == Pitches.E) {
                if (octave == 1)
                    return "000"; // Eb1
                if (octave == 2)
                    return "000"; // Eb2
                if (octave == 3)
                    return "000"; // Eb3
                if (octave == 4)
                    return "000"; // Eb4
                if (octave == 5)
                    return "000"; // Eb5
            } else if (pitch == Pitches.F) {
                if (octave == 1)
                    return "001"; // Fb1
                if (octave == 2)
                    return "001"; // Fb2
                if (octave == 3)
                    return "001"; // Fb3
                if (octave == 4)
                    return "001"; // Fb4
                if (octave == 5)
                    return "001"; // Fb5
            } else if (pitch == Pitches.G) {
                if (octave == 1)
                    return "001"; // Gb1
                if (octave == 2)
                    return "001"; // Gb2
                if (octave == 3)
                    return "001"; // Gb3
                if (octave == 4)
                    return "001"; // Gb4
                if (octave == 5)
                    return "001"; // Gb5
            } else if (pitch == Pitches.A) {
                if (octave == 1)
                    return "000"; // Ab1
                if (octave == 2)
                    return "000"; // Ab2
                if (octave == 3)
                    return "000"; // Ab3
                if (octave == 4)
                    return "000"; // Ab4
                if (octave == 5)
                    return "000"; // Ab5
            } else if (pitch == Pitches.B) {
                if (octave == 1)
                    return "001"; // Bb1
                if (octave == 2)
                    return "001"; // Bb2
                if (octave == 3)
                    return "001"; // Bb3
                if (octave == 4)
                    return "001"; // Bb4
                if (octave == 5)
                    return "001"; // Bb5
            }
        }
        if (accidental.equals("#")) {
            if (pitch == Pitches.C) {
                if (octave == 1)
                    return "010"; // Cb1
                if (octave == 2)
                    return "010"; // Cb2
                if (octave == 3)
                    return "010"; // Cb3
                if (octave == 4)
                    return "000"; // Cb4
                if (octave == 5)
                    return "010"; // Cb5
            } else if (pitch == Pitches.D) {
                if (octave == 1)
                    return "010"; // Db1
                if (octave == 2)
                    return "010"; // Db2
                if (octave == 3)
                    return "010"; // Db3
                if (octave == 4)
                    return "010"; // Db4
                if (octave == 5)
                    return "010"; // Db5
            } else if (pitch == Pitches.E) {
                if (octave == 1)
                    return "000"; // Eb1
                if (octave == 2)
                    return "000"; // Eb2
                if (octave == 3)
                    return "000"; // Eb3
                if (octave == 4)
                    return "000"; // Eb4
                if (octave == 5)
                    return "000"; // Eb5
            } else if (pitch == Pitches.F) {
                if (octave == 1)
                    return "001"; // Fb1
                if (octave == 2)
                    return "001"; // Fb2
                if (octave == 3)
                    return "001"; // Fb3
                if (octave == 4)
                    return "001"; // Fb4
                if (octave == 5)
                    return "001"; // Fb5
            } else if (pitch == Pitches.G) {
                if (octave == 1)
                    return "001"; // Gb1
                if (octave == 2)
                    return "001"; // Gb2
                if (octave == 3)
                    return "001"; // Gb3
                if (octave == 4)
                    return "001"; // Gb4
                if (octave == 5)
                    return "001"; // Gb5
            } else if (pitch == Pitches.A) {
                if (octave == 1)
                    return "000"; // Ab1
                if (octave == 2)
                    return "000"; // Ab2
                if (octave == 3)
                    return "000"; // Ab3
                if (octave == 4)
                    return "000"; // Ab4
                if (octave == 5)
                    return "000"; // Ab5
            } else if (pitch == Pitches.B) {
                if (octave == 1)
                    return "001"; // Bb1
                if (octave == 2)
                    return "001"; // Bb2
                if (octave == 3)
                    return "001"; // Bb3
                if (octave == 4)
                    return "001"; // Bb4
                if (octave == 5)
                    return "001"; // Bb5
            }
        }

        if (pitch == Pitches.C) {
            if (octave == 1)
                return "010"; // C1
            if (octave == 2)
                return "010"; // C2
            if (octave == 3)
                return "010"; // C3
            if (octave == 4)
                return "000"; // C4
            if (octave == 5)
                return "010"; // C5
        } else if (pitch == Pitches.D) {
            if (octave == 1)
                return "010"; // D1
            if (octave == 2)
                return "010"; // D2
            if (octave == 3)
                return "011"; // D3
            if (octave == 4)
                return "011"; // D4
            if (octave == 5)
                return "011"; // D5
        } else if (pitch == Pitches.E) {
            if (octave == 1)
                return "010"; // E1
            if (octave == 2)
                return "010"; // E2
            if (octave == 3)
                return "001"; // E3
            if (octave == 4)
                return "001"; // E4
            if (octave == 5)
                return "001"; // E5
        } else if (pitch == Pitches.F) {
            if (octave == 1)
                return "010"; // F1
            if (octave == 2)
                return "010"; // F2
            if (octave == 3)
                return "100"; // F3
            if (octave == 4)
                return "100"; // F4
            if (octave == 5)
                return "100"; // F5
        } else if (pitch == Pitches.G) {
            if (octave == 1)
                return "010"; // G1
            if (octave == 2)
                return "010"; // G2
            if (octave == 3)
                return "000"; // G3
            if (octave == 4)
                return "000"; // G4
            if (octave == 5)
                return "000"; // G5
        } else if (pitch == Pitches.A) {
            if (octave == 1)
                return "010"; // A1
            if (octave == 2)
                return "010"; // A2
            if (octave == 3)
                return "010"; // A3
            if (octave == 4)
                return "010"; // A4
            if (octave == 5)
                return "010"; // A5
        } else if (pitch == Pitches.B) {
            if (octave == 1)
                return "010"; // B1
            if (octave == 2)
                return "010"; // B2
            if (octave == 3)
                return "100"; // B3
            if (octave == 4)
                return "100"; // B4
            if (octave == 5)
                return "100"; // B5
        }

        // Default to open (no valves pressed) if pitch not matched
        return "000";
    }
}

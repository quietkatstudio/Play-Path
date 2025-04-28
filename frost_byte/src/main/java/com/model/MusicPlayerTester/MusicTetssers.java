package com.model.MusicPlayerTester;


import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class MusicTetssers {
    
    public static void main(String[] args) {
        // Test the play method with a sample pattern
        Pattern pattern = new Pattern("C D E F G A B C5q");
        Player player = new Player();
        player.play(pattern);
    }
}

package com.model;

/**
 * 
 * @author 
 */
public class MusicApplication {
    private User user;
    private Song song;
    private ChooseInstrument instrument;
    
    //teacher example
    // public boolean login(String userName, String password){
    //     return UserList.getInstance().login(userName,password);
    // }



    // private String login(String userName){
    //     return " ";
    // }

    /**
     * 
     * @param user
     * @return
     */
    private String register(User user){
        return " ";
    }

    /**
     * 
     * @param song
     * @return
     */
    private Song makeSong(Song song){
        return song;
    }

    /**
     * 
     * @param songList
     * @return
     */
    private SongList getAllSongs(SongList songList){
        return songList;
    }

    /**
     * 
     * @param instrument
     * @return
     */
    private ChooseInstrument chooseInstrument(ChooseInstrument instrument){
        return instrument;
    }

    /**
     * 
     * @param lesson
     * @return
     */
    private Lesson assignLesson(Lesson lesson){
        return lesson;
    }

    /**
     * 
     * @param student
     * @return
     */
    private Student assignToClass(Student student){
        return student;
    }

}

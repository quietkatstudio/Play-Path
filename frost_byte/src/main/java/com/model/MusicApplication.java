package com.model;

/**
 * 
 * @author
 */
public class MusicApplication {
    private User user;
    private Song song;
    private ChooseInstrument instrument;

    // teacher example
    // public boolean login(String userName, String password){
    // return UserList.getInstance().login(userName,password);
    // }

    // private String login(String userName){
    // return " ";
    // }

    /**
     * 
     * @param user
     * @return
     */
    public String register(User user) {
        return " ";
    }

    /**
     * 
     * @param song
     * @return
     */
    public Song makeSong(Song song) {
        return song;
    }

    /**
     * 
     * @param songList
     * @return
     */
    public SongList getAllSongs(SongList songList) {
        return songList;
    }

    /**
     * 
     * @param instrument
     * @return
     */
    public ChooseInstrument chooseInstrument(ChooseInstrument instrument) {
        return instrument;
    }

    /**
     * 
     * @param lesson
     * @return
     */
    public Lesson assignLesson(Lesson lesson) {
        return lesson;
    }

    /**
     * 
     * @param student
     * @return
     */
    public Student assignToClass(Student student) {
        return student;
    }

}

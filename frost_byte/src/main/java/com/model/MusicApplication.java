package com.model;

/**
 * 
 * @author
 */
public class MusicApplication {
    private User user;
    private Song song;
    private SongList songs;
    private ChooseInstrument instrument;
    private UserList users;
    
    //teacher example
    public boolean login(String userName, String password){
        User user =  UserList.getInstance().login(userName,password);
        if(user != null){
            return true;
        }
        return false;

    // teacher example
    public boolean login(String userName, String password) {
        // return UserList.getInstance().login(userName,password);
        return true;
    }

    // private String login(String userName){
    // return " ";
    // }

    /**
     * 
     * @param user
     * @return
     */
    public void register(String userName, String firstName, String lastName, String email, String password,
            Boolean isTeacher) {
        // add user to the list to be saved in json
        users.addUser(userName, firstName, lastName, email, password, isTeacher);

    }

    public String getFirstName(String username){
        return user.getFirstName();
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
    private SongList getAllSongs() {
        return songs;
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

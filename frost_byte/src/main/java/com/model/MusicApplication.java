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
        // return UserList.getInstance().login(userName,password);
        return true;
    }

    

    // private String login(String userName){
    //     return " ";
    // }

    /**
     * 
     * @param user
     * @return
     */
    public void register(String userName, String firstName,String lastName, String email, String password, Boolean isTeacher){
        //add user to the list to be saved in json
        users.addUser(userName, firstName, lastName, email, password, isTeacher);

        
        
    }

    /**
     * 
     * @param song
     * @return
     */
    public Song makeSong(Song song){
        return song;
    }

    /**
     * 
     * @param songList
     * @return
     */
    private SongList getAllSongs(){
        return songs;
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

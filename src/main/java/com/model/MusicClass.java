package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * musicClass has a list of students, a class code(id), a list of lessons, can
 * make a class code, delete a class, add a lesson to the list of
 * 
 * @author
 */
public class MusicClass {
    private ArrayList<Student> musicClass;
    private UUID musClassCode;
    private ArrayList<Lesson> assignments;

    /**
     * 
     * @param musicClass
     * @param assignments
     */
    public MusicClass(ArrayList<Student> musicClass, ArrayList<Lesson> assignments) {
        this.musicClass = musicClass;
        this.assignments = assignments;
    }

    /**
     * 
     * @return
     */
    public UUID makeClassCode() {
        this.musClassCode = UUID.randomUUID();
        return musClassCode;
    }

    /**
     * 
     * @param musClassCode
     */
    public void deleteClass(String musClassCode) {
        musicClass.remove(musClassCode);
    }

    /**
     * 
     */
    public void addAssignment() {

    }
}

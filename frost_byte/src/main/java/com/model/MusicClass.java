package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class MusicClass {
    private ArrayList<Student> musicClass;
    private UUID musClassCode;
    private ArrayList<Lesson> assignments;
    
    public MusicClass(ArrayList<Student> musicClass, ArrayList<Lesson> assignments){
        this.musicClass = musicClass;
        this.assignments = assignments;
    }
    private UUID makeClassCode(){
        this.musClassCode = UUID.randomUUID();
        return musClassCode;
    }
     private void deleteClass(String musClassCode){
        musicClass.remove(musClassCode);
     }
     private void addAssignment(){

     }
}

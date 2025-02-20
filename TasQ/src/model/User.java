package TasQ.src.model;

import java.util.ArrayList;

public class User {
    int userID;
    String name;
    int exp;
    ArrayList<Boolean> completedTasks = new ArrayList<Boolean>();

    //Constructor for initialization
    public User(){
        this.userID = userID;
        this.name = name;
        this.exp = exp;
        this.completedTasks = completedTasks;
    }


    //Getters
    public int getUserID(){ return userID;}
    public String getName(){ return name;}
    public int getExp(){ return exp;}
    public ArrayList<Boolean> getCompletedTasks(){ return completedTasks;}
    

    //Setters
    public void setName(String name){this.name = name;}
    public void setCompletedTasks(ArrayList<Boolean> completedTasks){this.completedTasks = completedTasks;}
    public void setExp(int exp){this.exp = exp;}
}

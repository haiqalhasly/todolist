package TasQ.src.model;

public class Task {
    private int taskID;
    private String title;
    private String description;
    private int exp;

    //Constructor for initialization
    public Task () {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.exp = exp;

    }

    //Getters
    public int getID(){ return taskID;}
    public String getTitle(){ return title;}
    public String getDescription(){ return description;}
    public int getExp(){ return exp;}

    //Setters
    public void setTitle(String title){this.title = title;}
    public void setDescription(String description){this.description = description;}
    public void setExp(int exp){this.exp = exp;}

    // Display task details (for testing)
    public void printTask() {
        System.out.println("Task ID: " + taskID);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("EXP: " + exp);
    }

}

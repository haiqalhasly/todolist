package Test;
import java.util.Scanner;

public class simpleNotesCRUD {

    //instance fields
    int ID;
    String description;
    boolean isCompleted;

    //Constructor for initialization
    public simpleNotesCRUD () {

        this.ID = ID;
        this.description = description;
        this.isCompleted = false;

    }

    //Getter and setter





    public static void main(String[] args) {
        
        //Create scanner object
        Scanner input = new Scanner(System.in);
        String notes = "";
        String[] notesList = new String[10]; 
        int count = 0;       
        while (true) {



        //Menu option
        System.out.println("Type your option : \n1. Add To-do\n2. View To-do\n3. Update To-do\n0. Exit");
        int menu = input.nextInt(); //Read user input
        System.out.println("Selected : " + menu);

        input.nextLine();


        switch (menu) {
            case 1:
                //Write To-do
                System.out.println("Write your To-do : ");
                notesList[count] = input.nextLine();
                System.out.println("Added");
                count++;
                break;
            case 2:
                //View To-do
                for (int i=0;i< count; i++){
                System.out.println(i+1 +". " + notesList[i]);
                }
                break;
            case 3:
                //Update To-do
                System.out.println("Update your To-do : ");
                notes = input.nextLine();
                System.out.println("Updated");
                break;
            case 0:
                // Exit
                System.out.println("Don't forget your to-do!");
                input.close();
                return;
            default:
                System.out.println("That is not the correct option");

        }
            
        }
        

    }
    
}

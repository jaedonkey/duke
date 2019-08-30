import java.util.Scanner;

public class Parser {
    Duke d;
    Scanner sc;


    public Parser(Duke d){
        this.d=d;
        sc = new Scanner(System.in);
        processCommands();
    }

    /**
     * @Function
     * No Params, No Return Value
     * This function handles the main CLI parsing loop
     * @UsedIn: Duke Constructor
     */
    public void processCommands(){

        //cli loop
        while(true){
            String cmd = sc.nextLine();

            if(cmd.equals("bye")){
                d.exitDuke();
            }
            else if(cmd.equals("list")){
                d.ui.listTasks();
            }
            else if(cmd.matches("done ([0-9]+)")){
                d.tasklist.taskDone(cmd);

            }
            else if(cmd.matches("delete ([0-9]+)")){
                d.tasklist.deleteTask(cmd);
            }
            else if (cmd.matches("(todo|event|deadline) .+")){  //use regex to make life easier
                d.tasklist.addTask(cmd);
            }
            else if (cmd.matches("find (.*)")){
                d.tasklist.findTask(cmd);
            }
            else if (cmd.matches("(todo|event|deadline)")){
                try {
                    throw new Duke.DukeException("☹ OOPS!!! The description of a "+cmd+" cannot be empty.");
                } catch (Duke.DukeException e) {
                    System.out.println(e);
                }
            }
            else{
                try {
                    throw new Duke.DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                } catch (Duke.DukeException e) {
                    System.out.println(e);
                }
            }
        }
    }



}

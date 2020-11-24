import java.io.File;

public class  Menu {

    public File folder;
    public Command cmnd;

    public Menu(File folder) {

        this.folder = folder;
        this.cmnd = new Command(folder);
    }

    public void menu(String[] command) {

        if (command.length == 1 && command[0].equals("ls")) {
            this.cmnd.cmndLS();
        } else if (command.length == 2 && command[0].equals("cd")) {
            File newone = this.cmnd.findFolder(command[1]);
            if (newone != null) {
                this.cmnd.cmndCD(newone);
            }
        } else if (command.length == 3 && command[0].equals("mv")) {
            this.cmnd.cmndMV(command[1], command[2]);
        } else {
            System.out.println("Command not found!");
            System.out.println("<ls>");
            System.out.println("<cd directory>");
            System.out.println("<mv name newname>");
            System.out.println("<mv name directory>");
            System.out.println("<exit>");
        }
        System.out.print("->");
    }
}
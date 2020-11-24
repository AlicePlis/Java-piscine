import java.io.File;
import java.io.IOException;

public class Command {

    public File folder;

    public Command(File file) {
        this.folder = file;
    }

    public long folderSize(File Folder) {

        long length = 0;

        for (File file : Folder.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }

    public void cmndLS() {

        for (File file : folder.listFiles()) {
            long size = 0;
            if (file.isDirectory()) {
                size = this.folderSize(file);
            } else {
                size = file.length();
            }
            System.out.printf("%s %d KB\n", file.getName(), size / 1000);
        }
    }

    public void cmndCD(File Folder) {

        if (folder.isDirectory()) {
            this.folder = Folder;
            try {
                System.out.println(folder.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File findFolder(String folderName) {

        try {
            File newone = new File(this.folder.getCanonicalPath() + "\\" + folderName);

            if (!newone.exists()) {
                System.out.println("Folder not found!");
                return (null);
            }

            if (!newone.isDirectory()) {
                System.out.printf("%s is not a folder\n", newone.getName());
                return (null);
            }
            return (newone);
        } catch (IOException e) {
            e.printStackTrace();
            return (null);
        }
    }

    public void cmndMV(String oldname, String newname) {

        try {
            File newpath = new File(folder.getCanonicalPath() + "\\" + newname);

            if (newpath.isDirectory()) {
                File oldone = new File(folder.getCanonicalPath() + "\\" + oldname);
                File newone = new File(newpath.getCanonicalPath() + "\\" + oldname);

                if (newone.exists()) {
                    System.out.printf("File %s already exists!\n", newname);
                } else if (!oldone.exists()) {
                    System.out.printf("File %s not found!\n", oldname);
                } else {
                    oldone.renameTo(newone);
                }
            } else {
                File oldone = new File(folder.getCanonicalPath() + "\\" + oldname);
                File newone = new File(folder.getCanonicalPath() + "\\" + newname);

                if (newone.exists()) {
                    System.out.printf("File %s already exists!\n", newname);
                } else if (!oldone.exists()) {
                    System.out.printf("File %s not found!\n", oldname);
                } else {
                    oldone.renameTo(newone);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package cmd;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

/**
 *
 * @author jan.himmel
 */
public class Dir extends Command{

    @Override
    public String execute(File actualDir) {
        File[] files;
        if (params.length == 1) {
            files = actualDir.listFiles();
            return dirToString(files);
        }else if(params.length == 2 && params[1].equals("-r")){//rekurze
            return recursionDir(actualDir, "-");
        }else if(params.length == 3 && params[1].equals("-e")){//extention
            FileFilter fileFilter = (File pathname) -> pathname.getName().endsWith(params[2]);
            files = actualDir.listFiles(fileFilter);
            return dirToString(files);
        }
        return "invalid parameter";
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append(String.format("%s\n", file.getName()));
            }else{
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified()) + "\n");
            }
        }
        return sb.toString();
    }
    
    private String recursionDir(File actDir, String floor){//metoda s rekurzí
        StringBuilder sb = new StringBuilder("");
        File[] files = actDir.listFiles();//list souborů
        for(File f : files){           
            if (f.isDirectory()) {//v případě, že je to složka, otevře ji a akce se zopakuje, dokud bude nacházet další
                sb.append(floor + " " + f.getName() + "\n");//aktuální patro se vypíše
                File r = new File(f.getParent() + File.separator + f.getName());
                sb.append(recursionDir(r,floor + "-"));
            }
        }
        return sb.toString();
    }
}

package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private String PATH = System.getProperty("user.home")
    + File.separator
    + "output.txt";
    
    private File currentFile = new File(PATH);

    public void setFile(final File file){
        if(file.exists()){
            this.currentFile = file;
        }
        throw new NullPointerException("The file does not exist");        
    }

    public File getCurrentFile(){
        if(currentFile.exists()){
            return this.currentFile;
        }
        throw new NullPointerException("No file has been set");
    }

    public String getCurrentFilePath(){
        if(currentFile.exists()){
            return this.currentFile.toPath().toString();
        }
        throw new NullPointerException("No file has been set");
    }

    public void saveOnCurrentFile(final String content){
        if(content.isBlank()){
            throw new IllegalArgumentException("The string is blank.");
        }
        try (PrintStream ps = new PrintStream(currentFile)){
            ps.println(content);
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}

package com.github.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class File {
    Path path;

    public File(Path path){
        this.path = path;
    }

    public String toString(){
        return path.toString();
    }

    public boolean isDirectory(){
        return true;
    }

    public void accept(Visitor visitor){
        visitor.visitFile(this);
    }

    public String getName(){
        return path.getFileName().toString();
    }

    public boolean isHidden(){
        try {
            return Files.isHidden(path);
        } catch (IOException e) {
        }
        return false;
    }

    public long getSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
        }
        return -1;
    }
}

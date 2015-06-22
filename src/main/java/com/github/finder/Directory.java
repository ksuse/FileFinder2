package com.github.finder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends File implements Iterable<File>{
    private List<File> fileList = new ArrayList<>();
    public Directory(Path path) {
        super(path);
    }

    public void add(File file){
        fileList.add(file);
    }

    public void accept(Visitor visitor){
        visitor.visitDirectory(this);
        for(File file: this){
            file.accept(visitor);
        }
    }

    @Override
    public boolean isDirectory(){
        return false;
    }

    public Iterator<File> iterator(){
        return fileList.iterator();
    }
}

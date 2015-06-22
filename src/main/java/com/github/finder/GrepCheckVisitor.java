package com.github.finder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;

public class GrepCheckVisitor extends Visitor {
    private String pattern;

    public GrepCheckVisitor(String pattern){
        this.pattern = pattern;
    }

    @Override
    public boolean visitFile(File leaf) {
        try(BufferedReader in = Files.newBufferedReader(leaf.path)){
            String line;
            while((line = in.readLine()) != null){
                if(line.indexOf(pattern) >= 0){
                    return true;
                }
            }
        } catch(IOException e){
        }
        return false;
    }

    @Override
    public boolean visitDirectory(Directory dir) {
        return false;
    }
}

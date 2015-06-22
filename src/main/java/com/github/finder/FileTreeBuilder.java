package com.github.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileTreeBuilder {
    private static FileTreeBuilder builder = new FileTreeBuilder();

    private FileTreeBuilder(){
    }

    public static FileTreeBuilder getInstance(){
        return builder;
    }

    public File build(String base){
        Path root = Paths.get(base);
        return build(root);
    }

    public File build(Path root){
        if(Files.isDirectory(root)){
            Directory dir = new Directory(root);
            try(Stream<Path> stream = Files.list(root)){
                stream.forEach(s -> dir.add(build(s)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dir;
        }
        else{
            return new File(root);
        }
    }
}

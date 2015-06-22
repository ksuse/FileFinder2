package com.github.finder;

public class NameCheckVisitor extends Visitor {
    private String name;

    public NameCheckVisitor(String name){
        this.name = name;
    }

    @Override
    public boolean visitFile(File leaf) {
        return leaf.getName().indexOf(name) >= 0;
    }

    @Override
    public boolean visitDirectory(Directory dir) {
        return dir.getName().indexOf(name) >= 0;
    }
}

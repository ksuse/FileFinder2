package com.github.finder;

import java.util.ArrayList;
import java.util.List;

public final class BaseVisitor extends Visitor{
    private List<String> files = new ArrayList<>();
    private List<Visitor> list = new ArrayList<>();

    public BaseVisitor(){
    }

    public void add(Visitor visitor){
        list.add(visitor);
    }

    public String[] getItems(){
        return files.toArray(new String[files.size()]);
    }

    @Override
    public boolean visitFile(File leaf) {
        boolean flag = true;
        for(Visitor visitor: list){
            flag &= visitor.visitFile(leaf);
        }
        if(flag){
            files.add(leaf.toString());
        }
        return flag;
    }

    @Override
    public boolean visitDirectory(Directory dir) {
        boolean flag = true;
        for(Visitor visitor: list){
            flag &= visitor.visitDirectory(dir);
        }
        if(flag){
            files.add(dir.toString());
        }
        return flag;
    }

}

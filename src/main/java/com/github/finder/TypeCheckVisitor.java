package com.github.finder;

/**
 * ファイルの種類で検査を行うための Visitor オブジェクト．
 * 
 * @author Haruaki Tamada
 */
public class TypeCheckVisitor extends Visitor {
    private String type;

    public TypeCheckVisitor(String type){
        this.type = type;
    }

    @Override
    public boolean visitFile(File leaf) {
        if(type.equals("f") || type.equals("file")){
            return true;
        }
        else if(type.equals("h") || type.equals("hidden")){
            return leaf.isHidden();
        }
        return false;
    }

    @Override
    public boolean visitDirectory(Directory dir) {
        if(type.equals("d") || type.equals("directory")){
            return true;
        }
        else if(type.equals("h") || type.equals("hidden")){
            return dir.isHidden();
        }
        return false;
    }
}

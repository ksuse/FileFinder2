package com.github.finder;

public class Finder {
    private BaseVisitor visitor;

    public Finder(Args args){
        visitor = new BaseVisitor();
        buildVisitor(args, visitor);
    }

    private Visitor buildVisitor(Args args, BaseVisitor visitor){
        if(args.getName() != null){
            visitor.add(new NameCheckVisitor(args.getName()));
        }
        if(args.getType() != null){
            visitor.add(new TypeCheckVisitor(args.getType()));
        }
        if(args.getSize() != null){
            visitor.add(new SizeCheckVisitor(args.getSize()));
        }
        if(args.getGrep() != null){
            visitor.add(new GrepCheckVisitor(args.getGrep()));
        }
        return visitor;
    }

    public String[] find(File root){
        root.accept(visitor);

        return visitor.getItems();
    }
}

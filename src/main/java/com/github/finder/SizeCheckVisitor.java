package com.github.finder;

public class SizeCheckVisitor extends Visitor {
    public static enum Equation{
        LESS_THAN, EQUALS, GREATER_THAN,
    };
    private int size;
    private Equation eq = Equation.LESS_THAN;

    public SizeCheckVisitor(String sizeString){
        char sign = sizeString.charAt(0);
        String string = sizeString.substring(1);
        size = Integer.parseInt(string);
        switch(sign){
        case '>':
            eq = Equation.GREATER_THAN;
            break;
        case '=':
            eq = Equation.EQUALS;
            break;
        case '<':
            eq = Equation.LESS_THAN;
            break;
        default:
            // ignore;
        }
    }

    @Override
    public boolean visitFile(File leaf) {
        boolean flag;
        switch(eq){
        case LESS_THAN:
            flag = leaf.getSize() < size;
            break;
        case EQUALS:
            flag = leaf.getSize() == size;
            break;
        case GREATER_THAN:
            flag = leaf.getSize() > size;
            break;
        default:
            flag = false;
        }

        return flag;
    }

    @Override
    public boolean visitDirectory(Directory dir) {
        return false;
    }
}

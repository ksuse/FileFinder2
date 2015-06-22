package com.github.finder;

import org.kohsuke.args4j.CmdLineException;

public class Main {
    public Main(String[] arguments) {
        try {
            Args args = new Args(arguments);
            Finder finder = new Finder(args);
            for (String base : args) {
                File fileTree = FileTreeBuilder.getInstance().build(base);
                String[] items = finder.find(fileTree);
                for (String item : items) {
                    System.out.println(item);
                }
            }

        } catch (CmdLineException e) {
        }
    }

    public static void main(String[] args) {
        new Main(args);
    }
}

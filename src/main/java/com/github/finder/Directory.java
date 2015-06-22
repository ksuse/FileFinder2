package com.github.finder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ディレクトリを表すクラス．
 *
 * @author Haruaki Tamada
 */
public class Directory extends File implements Iterable<File> {
    private List<File> fileList = new ArrayList<>();

    public Directory(Path path) {
        super(path);
    }

    /**
     * 与えられたVisitorを使って，このディレクトリ構造を渡り歩く(traverse)． このディレクトリに対して，
     * {@link Visitor#visitDirectory(Directory) <code>visitDirectory</code>}
     * を呼び出した後，このディレクトリが持つエントリそれぞれに対して， {@link File#accept(Visitor)
     * <code>accept</code>}メソッドを呼び出す．
     */
    public void accept(Visitor visitor) {
        visitor.visitDirectory(this);
        for (File file : this) {
            file.accept(visitor);
        }
    }

    /**
     * このディレクトリに含まれるファイルを追加する．
     * 
     * @param file
     */
    public void add(File file) {
        fileList.add(file);
    }

    /**
     * このメソッドは常に　-1 を返す．
     */
    @Override
    public long getSize() {
        return -1;
    }

    /**
     * ディレクトリか否かを返す． このメソッドは常に true を返す．
     */
    @Override
    public boolean isDirectory() {
        return true;
    }

    /**
     * このディレクトリに含まれるエントリの列挙を返す．
     */
    @Override
    public Iterator<File> iterator() {
        return fileList.iterator();
    }
}

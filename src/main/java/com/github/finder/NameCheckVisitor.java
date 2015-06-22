package com.github.finder;

/**
 * 名前で検査を行うための Visitor オブジェクト．
 * 
 * @author Haruaki Tamada
 */
public class NameCheckVisitor extends Visitor {
    private String name;

    /**
     * 名前で検査を行う Visitor オブジェクトを作成するためのコンストラクタ．
     * @param name 名前のパターン．
     */
    public NameCheckVisitor(String name){
        this.name = name;
    }

    /**
     * 与えられた<code>File</code>オブジェクトがコンストラクタで与えられた名前のパターンを持っていれば true を返す．
     * そうでなければ　false を返す．
     */
    @Override
    public boolean visitFile(File leaf) {
        return leaf.getName().indexOf(name) >= 0;
    }

    /**
     * 与えられた<code>Directory</code>オブジェクトがコンストラクタで与えられた名前のパターンを持っていれば true を返す．
     * そうでなければ　false を返す．
     */
    @Override
    public boolean visitDirectory(Directory dir) {
        return dir.getName().indexOf(name) >= 0;
    }
}

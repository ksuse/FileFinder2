package com.github.finder;

/**
 * 基本となるVisitorオブジェクト．
 * 
 * @author Haruaki Tamada
 */
public abstract class Visitor {
    /**
     * 引数で受け取ったファイルが条件のファイルであれば，trueを返す．
     * 条件に合わなければ，false を返す．
     * 条件は，このVisitorインターフェースの実装クラスが定めるものとする．
     * @param leaf 検査対象のファイル
     * @return
     */
    public abstract boolean visitFile(File leaf);

    /**
     * 引数で受け取ったディレクトリが条件のディレクトリであれば，trueを返す．
     * 条件に合わなければ，false を返す．
     * 条件は，このVisitorインターフェースの実装クラスが定めるものとする．
     * @param dir 検査対象のディレクトリ
     * @return
     */
    public abstract boolean visitDirectory(Directory dir);
}

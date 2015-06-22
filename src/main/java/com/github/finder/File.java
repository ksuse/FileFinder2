package com.github.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class File {
    Path path;

    public File(Path path) {
        this.path = path;
    }

    /**
     * Visitor がこの構造を渡り歩く(traverse)． Fileオブジェクトに対して呼び出されると， このオブジェクトを対象に
     * {@link Visitor#visitFile(File) <code>visitFile</code>}を呼び出し，終了する．
     * 
     * @param visitor
     */
    public void accept(Visitor visitor) {
        visitor.visitFile(this);
    }

    /**
     * ファイル名を返す．
     * 
     * @return
     */
    public String getName() {
        return path.getFileName().toString();
    }

    /**
     * ファイルサイズを返す．ファイルサイズ取得時に入出力エラーが起こった場合は，-1 を返す．
     * 
     * @return ファイルサイズを返す．
     */
    public long getSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
        }
        return -1;
    }

    /**
     * ディレクトリか否かを返す．このメソッドは常に false を返す．
     * 
     * @return 常に false．
     */
    public boolean isDirectory() {
        return false;
    }

    /**
     * 隠しファイルか否かを返す．
     * 
     * @return 隠しファイルであれば，true，そうでなければ false．また，入出力エラーが起こった場合も false を返す．
     */
    public boolean isHidden() {
        try {
            return Files.isHidden(path);
        } catch (IOException e) {
        }
        return false;
    }

    /**
     * このファイルが表すパスを文字列で返す．
     */
    public String toString() {
        return path.toString();
    }
}

package com.github.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileTreeBuilder {
    /**
     * このクラスの唯一のインスタンス．
     */
    private static FileTreeBuilder builder = new FileTreeBuilder();

    /**
     * 他のクラスからインスタンスが作られないよう，private宣言している．
     */
    private FileTreeBuilder(){
    }

    /**
     * このクラスの唯一のインスタンスを返す．
     * @return このクラスの唯一のインスタンス．
     */
    public static FileTreeBuilder getInstance(){
        return builder;
    }

    /**
     * 与えられた文字列が表すパスの <code>File</code> オブジェクトを作成し，返す．
     * @param base 作成する<code>File</code>オブジェクトのパスを表す文字列．
     * @return 作成された<code>File</code>オブジェクト．
     */
    public File build(String base){
        Path root = Paths.get(base);
        return build(root);
    }

    /**
     * 与えられた{@link Path}が表す <code>File</code> オブジェクトを作成し，返す．
     * @param base 作成する<code>File</code>オブジェクトのパス．
     * @return 作成された<code>File</code>オブジェクト．
     */
    public File build(Path root){
        if(Files.isDirectory(root)){
            Directory dir = new Directory(root);
            try(Stream<Path> stream = Files.list(root)){
                stream.forEach(s -> dir.add(build(s)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dir;
        }
        else{
            return new File(root);
        }
    }
}

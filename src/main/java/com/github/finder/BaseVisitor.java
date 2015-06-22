package com.github.finder;

import java.util.ArrayList;
import java.util.List;

/**
 * 他のVisitorを使い，検索結果をまとめるためのVisitor．
 * 
 * @author Haruaki Tamada
 */
public final class BaseVisitor extends Visitor{
    private List<String> files = new ArrayList<>();
    private List<Visitor> list = new ArrayList<>();

    public BaseVisitor(){
    }

    /**
     * 検索を行う Visitor を追加する．
     * 
     * @param visitor
     */
    public void add(Visitor visitor){
        list.add(visitor);
    }

    /**
     * 検索結果を返す．
     * @return 検索結果．
     */
    public String[] getItems(){
        return files.toArray(new String[files.size()]);
    }

    /**
     * ファイルを対象に，検査を行う．
     * 全てのVisitorが true を返した場合に検索結果に対象のファイルが追加される．
     * Visitorが一つもない場合は，当該ファイルは検索結果に追加され，trueを返す．
     * Visitor が一つでも false を返すと，検索結果には含まれず，このメソッドは　false を返す．　
     */
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

    /**
     * ディレクトリを対象に検査を行う．
     * 全てのVisitorが true を返した場合に検索結果に対象のファイルが追加される．
     * Visitorが一つもない場合は，当該ファイルは検索結果に追加され，trueを返す．
     * Visitor が一つでも false を返すと，検索結果には含まれず，このメソッドは　false を返す．　
     */
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

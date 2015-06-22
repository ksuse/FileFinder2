# 2015年度 ソフトウェア工学II 第12回 デザインパターン

[FileFinder](http://github.com/ksuse/FileFinder)と同じ題材を
デザインパターンを使って作ってみたプロジェクト．

なお，[FileFinder](http://github.com/ksuse/FileFinder)で出された宿題の
参考としては，このプロジェクトは役立ちません．[FileFinder](http://github.com/ksuse/FileFinder)の
Issue にプログラムの断片がありますので，そちらを参照して下さい．
このプロジェクトのソースコードを参考にした場合，そのチームの宿題は未提出として扱います．

以下のデザインパターンを利用している．

* Builderパターン．
* Singletonパターン．
* Compositeパターン．
* Visitorパターン．

## Compositeパターン

* 木構造を扱うときによく使われるパターン．
    * 葉と節を同じように扱う．
    * このプロジェクトにおける，File と Directoryが同一に扱われている．

## Visitorパターン

* 複雑な構造をスキャンするためのパターン．
    * このプロジェクトでは，ディレクトリ階層を表す File, Directory を順に辿っていくときに使っている．
    * また，条件により，異なる Visitor オブジェクトを作成して走査時に利用している．

## Builderパターン

* 初期化手順を細分化して複雑なオブジェクトを作成する．
    * GoF が紹介する Builder パターンを簡略化して利用している．



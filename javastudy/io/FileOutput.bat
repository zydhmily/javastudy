@echo off
echo コピー元を入力してください。
set /P FILE=%1
echo コピー先を入力してください。
set /P FILE2=%2
javac /Users/zydhmily/Desktop/javaStudy/javastudy/io/FileCopy.java
java /Users/zydhmily/Desktop/javaStudy/javastudy/io/FileCopy %FILE% %FILE2%
@echo off
echo コピー元を入力してください。
set /P FILE=%1
echo コピー先を入力してください。
set /P FILE2=%2
java FileCopy %FILE% %FILE2%
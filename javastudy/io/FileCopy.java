package javastudy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		//缓冲区大小
		int bufferValue = 4096;
		//声明输入流对象
		FileInputStream input = null;
		//声明输出流对象
		FileOutputStream output = null;
		try {
			//给输入流对象赋予入力文件path
			input = new FileInputStream(args[0]);
			//给输出流对象赋予出力文件path
			output = new FileOutputStream(args[1]);
			//声明一个缓冲区数组变量
			byte[] buffer = new byte[bufferValue];
			//声明记录读入字节数变量
			int byteCnt = 0;
			//循环读入文件内容
			while ((byteCnt = input.read(buffer, 0, bufferValue)) != -1) {
				//输出读入内容到输出流对象
				output.write(buffer, 0, byteCnt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//输入流对象不为null时关闭输入流
				if (input != null) {
					input.close();
				}
				//输出流对象不为null时关闭输出流
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("无法关闭输入输出流，请联系系统管理员");
			}
		}
	}
}
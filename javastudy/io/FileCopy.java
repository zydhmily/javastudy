package javastudy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	//缓冲区大小
	private static final int BLOCK_SIZE = 4096;

	public static void main(String[] args) {
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
			byte[] bytes = new byte[BLOCK_SIZE];
			//声明记录读入字节数变量
			int totalNumber;
			
			//循环读入文件内容
			while ((totalNumber = input.read(bytes)) != -1) {
				//输出读入内容到输出流对象
				output.write(bytes, 0, totalNumber);
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

			}
		}
	}
}
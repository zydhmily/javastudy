package javastudy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(args[0]);
            output = new FileOutputStream(args[1]);
            byte[] bytes= new byte[1024];
            int i = input.read(bytes,0,1024);
            while (i != -1) {
                output.write(bytes,0,i);
                i = input.read(bytes,0,1024);
            }
        } catch (IOException e) {
            System.out.println("运用输入输出流时发生错误")
        } finally {
            try {
                if (input != null) {
                input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                System.out.println("无法关闭输入输出流，请联系系统管理员")
            }            
        }                
    }
}
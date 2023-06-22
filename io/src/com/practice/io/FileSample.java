package com.practice.io;

import java.io.File;
import java.io.IOException;

public class FileSample {
    public static void main(String[] args) {
        File f = new File("");
        File d = new File("");

        try {
            boolean r1 = f.createNewFile();
            System.out.println(f.getPath() + "文件創建是否成功：" + r1);
            System.out.println(f.getPath() + "是否存在：" + f.exists());
            System.out.println(f.getPath() + "是否是目錄：" + f.isDirectory());
            System.out.println(f.getPath() + "是否是文件：" + f.isFile());
            System.out.println(f.getPath() + "的大小：" + f.length());
            System.out.println(f.getPath() + "的文件名：" + f.getName());

            boolean r2 = f.delete();
            System.out.println(f.getPath() + "文件是否刪除成功：" + r2);
            System.out.println(f.getPath() + "是否存在：" + f.exists());

            boolean r3 = d.mkdirs();
            System.out.println("[" + d.getPath() + "]目錄是否創建成功：" + r3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

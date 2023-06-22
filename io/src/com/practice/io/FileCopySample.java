package com.practice.io;

import java.io.*;

public class FileCopySample {
    public static void main(String[] args) {
        File source = new File("");
        File target = new File("");
        InputStream fis = null;
        OutputStream fos = null;
        try {
            // 實例化 InputStream 對象
            fis = new FileInputStream(source);
            // 實例化 OutputStream 對象
            fos = new FileOutputStream(target);

            byte[] bs = new byte[1024];
            int len;
            while((len = fis.read(bs)) != -1) {
                System.out.println(len);
                fos.write(bs, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 通過 finally 塊確保 fis/fos 對象執行 close 方法，且 fos 依賴 fis，所以必須先 close
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

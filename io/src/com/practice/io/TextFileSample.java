package com.practice.io;

import java.io.*;

public class TextFileSample {
    public void readTextFile() {
        Reader reader = null;
        try {
            File file = new File("");
            reader = new FileReader(file);
            int ch = 0;
            while ((ch = reader.read()) != -1) {
                System.out.println((char)ch); // UTF-8 編碼集
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    // 關閉 reader 對象
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeTextFile() {
        Writer writer = null;
        try {
            File file = new File("");
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file);
            writer.write("這是一個新文件");
            writer.append(":Append內容");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void isrSample() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            File file = new File("");
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "UTF-8");
            StringBuffer buffer = new StringBuffer();
            while(isr.ready()) {
                buffer.append((char)isr.read());
//                System.out.println((char)isr.read());
            }
            System.out.println(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 利用 OutputStreamWriter 寫入文本文件
    public void oswSample() {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            File file = new File("");
            // 創建文件
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write("這是一個新文件！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
                // 實際上 fos 沒關閉也沒關係，因為上面的 osw 就是依賴於 fos，所以 osw 關閉時，也會同步關閉 fos，但建議還是寫上
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readBuffer() {
        Reader reader = null;
        BufferedReader br = null;
        try {
            File file = new File("");
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TextFileSample sample = new TextFileSample();
//        sample.writeTextFile();
//        sample.readTextFile();
//        sample.isrSample();
//        sample.oswSample();
        sample.readBuffer();
    }
}

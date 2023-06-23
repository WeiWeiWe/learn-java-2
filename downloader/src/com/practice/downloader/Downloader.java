package com.practice.downloader;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Downloader {
    private Integer threadNum = 10;
    /**
     * 下載單個文件保存到本地
     * @param source 原圖片的網址
     * @param targetDir 目標目錄，要確保已存在
     */
    public void download(String source, String targetDir) {
        InputStream is = null;
        OutputStream os = null;

        try {
            String fileName = source.substring(source.lastIndexOf('/') + 1);
            File targetFile = new File(targetDir + "/" + fileName);
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            URL url = new URL(source);
            URLConnection connection = url.openConnection();
            is = connection.getInputStream();
            os = new FileOutputStream(targetFile);
            byte[] bs = new byte[1024];
            int len = 0;
            while((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            System.out.println("[INFO]圖片下載完畢：" + source + "\n\t  ->" + targetFile.getPath() + "(" +
                    Math.floor(targetFile.length() / 1024) + "kb)");
        } catch (IOException e ) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e ) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 從指定文件讀取下載地址，批量下載網路資源
     * @param targetDir 下載文件的存儲目錄
     * @param downloadTxt download.txt 完整目錄
     */
    public void multiDownloadFromFile(String targetDir, String downloadTxt) {
        File dir = new File(targetDir);
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("[INFO]發現下載目錄[" + dir.getPath() + "]不存在，已自動創建");
        }
        List<String> resources = new ArrayList<>();
        BufferedReader reader = null;
        ExecutorService threadPool = null;
        try {
            reader = new BufferedReader(new FileReader(downloadTxt));
            String line = null;
            while((line = reader.readLine()) != null) {
                resources.add(line);
            }
            threadPool = Executors.newFixedThreadPool(this.threadNum);
            Downloader that = this;
            for (String res:resources) {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        that.download(res, targetDir);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (threadPool != null) {
                threadPool.shutdown();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 開始多線程下載
     * @param propDir config.properties 所在目錄
     */
    public void start(String propDir) {
        // 指定 config.properties 完整路徑
        File propFile = new File(propDir + "\\config.properties");
        // 實例化 Properties 屬性類
        Properties properties = new Properties();
        Reader reader = null;
        try {
            // 實例化 FileReader 對象
            reader = new FileReader(propFile);
            // properties 對象讀取配置文件
            properties.load(reader);
            // 通過 getProperty 方法得到對應的選項值
            String threadNum = properties.getProperty("thread-num");
            this.threadNum = Integer.parseInt(threadNum);
            String targetDir = properties.getProperty("target-dir");

            // 讀取 download.txt 進行多線程下載
            this.multiDownloadFromFile(targetDir, propDir + "\\download.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Downloader downloader = new Downloader();
//        downloader.start("");
    }
}

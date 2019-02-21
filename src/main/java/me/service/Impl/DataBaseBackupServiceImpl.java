package me.service.Impl;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Author: wt
 * @Date: 2019/2/21 9:36
 */
public class DataBaseBackupServiceImpl {
    private static InputStream inputStream = null;
    private static Properties properties = null;

    static {
        try {
            inputStream = new FileInputStream(new File("F:\\IDEA\\news-system\\src\\main\\resources\\database.properties"));
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backup() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String backupFileName = dateFormat.format(new Date()) + ".sql";
        String saveCommand = "mysqldump "
                + "-h " + properties.getProperty("database.url") + " "
                + "-u " + properties.getProperty("database.user") + " "
                + "-p" + properties.getProperty("database.password") + " "
                + "> " + properties.getProperty("database.savePath") + backupFileName;
        System.out.println(saveCommand);

        StringBuffer dosCommand = new StringBuffer();
        dosCommand.append("cmd.exe /c \"").append(saveCommand).append("\"");
        /*
         * 执行cmd命令
         */
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(dosCommand.toString());
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(process.getInputStream()));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

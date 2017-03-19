package com.basicjava.io;

import java.io.*;
import java.util.List;

/**
 * Created by peter on 2017/3/19.
 * 实现基本的文件查找，删除，复制，剪切等功能
 */
public class BasicIO {

    public static void main(String[] args) throws IOException {
        String sourceFileName = "E:\\eclipse-jee-juno-SR2-win32-x86_64.zip";
        String descPath = "E://素材";
       cutFile(sourceFileName,descPath);

    }

    public static void getFileFullPath(String fileName, String basePath, List resultList) {
        File[] directories = new File(basePath).listFiles();
        for (int i = 0; i < directories.length; i++) {
           if(directories[i].isHidden())continue;
            if(directories[i].isFile()){
                if(fileName.equals(directories[i].getName()))
                    resultList.add(directories[i].getAbsolutePath());
            }else{
                if(directories[i].isDirectory()&&directories[i].list().length>0)
                    getFileFullPath(fileName,directories[i].getAbsolutePath(),resultList);
            }

        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
    }

    public static void copyFile(String sourceFileName, String descPath) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("start copy: "+startTime);
        File sourceFile = new File(sourceFileName);
        File descFile = new File(descPath,sourceFile.getName());
        FileInputStream input = new FileInputStream(sourceFile);
        FileOutputStream output = new FileOutputStream(descFile);
        int length;
        byte[] data = new byte[1024*1024];
        while ((length=input.read(data))!=-1){
            output.write(data,0,length);
        }
        input.close();
        output.close();
        System.out.println("finish copy: "+(System.currentTimeMillis()-startTime)/1000);
    }

    public static void cutFile(String sourceFileName, String descPath) throws IOException {
       copyFile(sourceFileName,descPath);
       new File(sourceFileName).delete();
    }
}

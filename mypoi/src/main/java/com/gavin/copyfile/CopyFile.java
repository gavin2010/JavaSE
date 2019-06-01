package com.gavin.copyfile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args){
        //String file = "H:/SafeGene.xls";
        copyFile(args[0]);

    }

    /**
     * 复制文件入口函数
     * @param file
     */
    public static void copyFile(String file){
        if(null == file){
            return;
        }
        File f = new File(file);
        if(!f.exists() || !f.isFile()){
            return;
        }

        Workbook wb = null;
        FileOutputStream out = null;
        try {
            wb = new HSSFWorkbook(new FileInputStream(f));
            out = new FileOutputStream(f.getParentFile().getPath()+"abc.abc");
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != wb){
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

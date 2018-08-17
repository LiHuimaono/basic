package com.llxh.basic.base.utils.sort;

import org.hibernate.engine.jdbc.ReaderInputStream;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void insertSort(int [] nums){
        int len = nums.length;
        int temp;
        for (int i = 1;i<len;i++){
            temp = nums[i];
            int j = i-1;
            while (j>=0 && temp<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
    }

    public static void main(String[] args)  {
        File file = new File("D:\\bbb.txt");
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        List<String> txtList = new LinkedList<>();
        try {
            FileInputStream stream = new FileInputStream(file);
            streamReader = new InputStreamReader(stream,"GBK");
            bufferedReader = new BufferedReader(streamReader);
            while (true){
                String s = bufferedReader.readLine();
                if (s == null)break;
                txtList.add(s);
            }
            for (int i = 0;i<txtList.size();i++){
                String line = txtList.get(i);
                if (line.contains("开户机构")){
                    System.out.println(line);
                    String content = txtList.get(i+1);
                    System.out.println(content);
                    String[] lines = line.split("");
                    String[] contents = content.split("");
                    for (int j=0;j<lines.length;j++){
                        if (lines[j].equals("开")){
                            System.out.print(j+"        ");
                            System.out.print(content.substring(j,j+5)+"       ");
                        }
                        if (lines[j].equals("账")){
                            System.out.print(j+"      ");
                            System.out.print(content.substring(j,j+21));
                            System.out.println();
                            break;
                        }
                    }

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (streamReader != null){
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

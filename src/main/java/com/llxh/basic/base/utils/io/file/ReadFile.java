package com.llxh.basic.base.utils.io.file;

import java.io.*;
import java.util.*;

public class ReadFile {
    private static final List<String> titles;
    static {
        titles = new ArrayList<String>();
        titles.add("开户机构");
        titles.add("账号");
        titles.add("子账户类别");
        titles.add("册号");
        titles.add("序号");
        titles.add("客户类型");
        titles.add("合同类型");
        titles.add("产品类型");
        titles.add("产品子类");
        titles.add("产品名称");
        titles.add("账户名称");
        titles.add("议价利率类型");
        titles.add("议价利率值");
        titles.add("交易码");
        titles.add("交易流水");
        titles.add("交易时间");
        titles.add("付息方式");
        titles.add("转息账户");
        titles.add("续存类型");
        titles.add("经办柜员");
        titles.add("授权柜员");
    }
    public List<Map<String,String>> readFile(String filePath){
        List<Map<String,String>> resultList = new ArrayList<>();

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
            bufferedReader = new BufferedReader(inputStreamReader);
            List<String> txtList = new ArrayList<>();
            while (true){
                String s = bufferedReader.readLine();
                if (s==null)break;
                if (s.contains(titles.get(0))&&s.contains(titles.get(1))&&s.contains(titles.get(2))) {
                    txtList.add(s);
                    s = bufferedReader.readLine();
                    txtList.add(s);
                }
            }
            dataPro(txtList);
        }catch (IOException e){
            e.printStackTrace();
        }

        return resultList;
    }
    private void dataPro(List<String> txtlist) throws UnsupportedEncodingException {

        List<Map<String,String>> resultList = new ArrayList<>();
        for (int i=0;i<txtlist.size();i++){
            String s1 = txtlist.get(i);
            i++;
            String s2 = txtlist.get(i);
            byte[] bytes = s1.getBytes("GBK");

            byte[] bytes1 = s2.getBytes("GBK");
            Map<String,String> result = new LinkedHashMap<>();
            for (int j=0;j<titles.size();j++){
                byte[] bytes2 = titles.get(j).getBytes("GBK");
                int start =indexOfBytes(bytes,bytes2);
                int end;
                if (j+1 == titles.size()){
                    end = 7;
                }else {
                    byte[] bytes3 =titles.get(j+1).getBytes("GBK");
                    end = indexOfBytes(bytes,bytes3)-start;
                }
                String dataValue = new String(bytes1,start,end,"GBK").trim();
                result.put(titles.get(j),dataValue);
            }
            resultList.add(result);
        }
        resultList.forEach(stringStringMap -> {
            System.out.println(stringStringMap.toString());
        });
    }
    private int indexOfBytes(byte[] bytes1,byte[] bytes2){
        boolean flag = true;
        int index = -1;
        int len = bytes2.length;
        int k = 0;
        for (int i=0;i<bytes1.length;i++){
            for (int j=k;j<bytes2.length;j++){
                if (bytes1[i] == bytes2[j]){
                    len--;
                    k++;
                    if (flag){
                        index = i;
                        flag = false;
                    }
                    break;
                }else {
                    k=0;
                    len = bytes2.length;
                    flag = true;
                    index = -1;
                    break;
                }
            }
            if (len == 1){
                break;
            }
        }
        return index;
    }
}

package com.llxh.basic.base.utils.io.file;

public class ArrayIndexOfUtils {

    /**
     * 查找target在source第一次出现的位置，必须连续的完整包含target的第一次出现的index
     * @param source 源数组
     * @param target  需要查找位置的数组
     * @return target in source first index
     */
    public static int BytesIndexOf(byte[] source,byte[] target){
        boolean firstFlag = true;
        int index = -1;
        int k = 0;
        for (int i=0;i<source.length;i++){
            byte s = source[i];
            byte t = target[k];
            if (s == t){
                if (firstFlag) {
                    index = i;
                    firstFlag = false;
                }
                k++;
            }else {
                k=0;
                index = -1;
                firstFlag = true;
            }
            if (k == target.length-1){
                break;
            }
        }
        return index;
    }
}

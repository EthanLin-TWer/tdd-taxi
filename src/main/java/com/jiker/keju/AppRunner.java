package com.jiker.keju;

import java.io.*;

public class AppRunner {

    public static void main(String[] args) throws IOException {
        /*TODO
          args[0]为resources下的测试数据文件名。
          读取测试数据文件作为你程序的输入参数，
          并将结果保存到receipt变量中。
         */
        String testDataFile = "src/main/resources/testData.txt";
        final FileInputStream fileInputStream = new FileInputStream(testDataFile);
        final InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer result = new StringBuffer();
        String text = null;
        while((text = bufferedReader.readLine()) != null){
            result.append(text + "\n");
        }
        String input = result.toString();

        String receipt = "";
        System.out.println(input);
        System.out.println(receipt);
    }
}

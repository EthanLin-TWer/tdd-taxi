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
        String input = readFileAsString(testDataFile);

        String receipt = TaximeterPrinter.process(input);
        System.out.println(receipt);
    }

    private static String readFileAsString(String testDataFile) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(testDataFile);
        final InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder result = new StringBuilder();
        String text = "";
        while((text = bufferedReader.readLine()) != null){
            result.append(text).append("\n");
        }

        return result.toString();
    }
}

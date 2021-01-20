package learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        LIneCallBack<Integer> sumCallBack = (line, value) -> value + Integer.parseInt(line);
        return lineReadTemplate(filepath, sumCallBack, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        LIneCallBack<Integer> multiplyCallBack = (line, value) -> value * Integer.parseInt(line);
        return lineReadTemplate(filepath, multiplyCallBack, 1);
    }

    public <T> T lineReadTemplate(String filepath, LIneCallBack<T> callBack, T initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            T res = initVal;
            String line;
            while ((line = br.readLine()) != null) {
                callBack.doSomethingWithLine(line, res);
            }
            return res;
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
            throw e;
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

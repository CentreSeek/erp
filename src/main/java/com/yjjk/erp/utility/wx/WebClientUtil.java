package com.yjjk.erp.utility.wx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
/**
 * Created by Administrator on 2018/8/21.
 * http请求帮助类
 */
public class WebClientUtil {
    private static String charset = "utf-8";
    private static Integer connectTimeout = null;
    private static Integer socketTimeout = null;
    private static String proxyHost = null;
    private static Integer proxyPort = null;


    public static String doGet(String url, HashMap<String,String> params) throws Exception {
        url = url+"?";
        for (String key: params.keySet())
        {
            url = String.format("%s%s=%s&",url,key, URLEncoder.encode(params.get(key),"utf-8"));
        }
        URL localURL = new URL(url);

        HttpURLConnection httpURLConnection = (HttpURLConnection)localURL.openConnection();
        httpURLConnection.setDoInput(true);        //设置输入流采用字节流
        httpURLConnection.setDoOutput(true);        //设置输出流采用字节流
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Charset", charset);

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        //响应失败
        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }

        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }

        return resultBuffer.toString();
    }

    public static String doPost(String url, HashMap<String,String> params) throws Exception {

        /* Translate parameter map to parameter date string */
        StringBuffer parameterBuffer = new StringBuffer();
        for (String key: params.keySet())
        {
            parameterBuffer.append(String.format("%s%s=%s&",url,key, URLEncoder.encode(params.get(key),"utf-8")));
        }
        URL localURL = new URL(url);

        HttpURLConnection httpURLConnection = (HttpURLConnection) localURL.openConnection();

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);        //设置输入流采用字节流
        httpURLConnection.setDoOutput(true);        //设置输出流采用字节流
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Charset", charset);

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.write(parameterBuffer.toString());
            outputStreamWriter.flush();
            //响应失败
            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }
            //接收响应流
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }

        return resultBuffer.toString();
    }
}


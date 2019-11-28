package com.yjjk.erp.utility;

import java.io.*;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class DownLoadFile {

	public static String downloadFile(String name,HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		// 获取指定目录下的第一个文件
//		File scFileDir = new File("E://music_eg");
//		File TrxFiles[] = scFileDir.listFiles();
//		
//		String fileName = TrxFiles[0].getName(); // 下载的文件名

		// 如果文件名不为空，则进行下载
		if (name != null) {
			// 设置文件路径
			String realPath = "E://music_eg/";
			File file = new File(realPath, name);

			// 如果文件名存在，则进行下载
			if (file.exists()) {

				// 配置文件下载
				response.setHeader("content-type", "application/octet-stream");
				response.setContentType("application/octet-stream");
				// 下载文件能正常显示中文
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode(name, "UTF-8"));

				// 实现文件下载
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					System.out.println("Download the song successfully!");
				} catch (Exception e) {
					System.out.println("Download the song failed!");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}

}

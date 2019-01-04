package com.dinesh.ds.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {


	private static final String ABS_PATH = "C:\\eclipse-workspace\\MySpringProejct\\WebContent\\assets\\images\\";
	private static String REAL_PATH = null ;
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code)
	
	{
		
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		
		System.out.println(REAL_PATH);
		
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		
		try {
			
		file.transferTo(new File(REAL_PATH+code+".jpg"));

		file.transferTo(new File(ABS_PATH+code+".jpg"));
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return true;
		
	}
	
}

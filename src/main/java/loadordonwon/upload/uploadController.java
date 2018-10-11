/**
 * 
 */
package loadordonwon.upload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @功能:
 * @项目名:test
 * @作者:zzh
 * @日期:2018年9月3日下午5:09:05
 */
@RestController
public class uploadController {
	@PostMapping("/upload")
	public String uploadByPost(HttpServletRequest request,@RequestParam("file") MultipartFile file,@RequestParam("to") String to
			,@RequestParam("from") String from,@RequestParam("title") String title,@RequestParam("content") String content){
		
		System.out.println(to+" "+from+" "+title+" "+content);
	
		String filePath="";
	    if (!file.isEmpty()) {
	        try{
	            filePath=PathUtil.uploadPath+file.getOriginalFilename();//上传文件到指定路径
	            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(new File(filePath)));
	            out.write(file.getBytes());
	            out.flush();
	            out.close();
	            emailUtil.sendEmail(to, from, title, content, filePath);
	            System.out.println("上传成功");
	        	emailUtil.sendEmail(to, from, title, content, filePath);
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    else{
	    	filePath="";
	    	emailUtil.sendEmail(to, from, title, content, filePath);
	    	 return "upload";
	    }
	    return "upload";
	}
}

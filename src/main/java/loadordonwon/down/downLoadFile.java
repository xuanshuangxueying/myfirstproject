/**
 * 
 */
package loadordonwon.down;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @功能:
 * @项目名:email
 * @作者:zzh
 * @日期:2018年9月6日上午9:33:52
 */
@RestController
public class downLoadFile {
	//文件下载相关代码
	@RequestMapping("/download")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
	    String fileName = "aim_test.txt";// 设置文件名，根据业务需要替换成要下载的文件名
	    if (fileName != null) {
	        //设置文件路径
	        String realPath = "D://aim//";
	        File file = new File(realPath , fileName);
	        if (file.exists()) {
	            response.setContentType("application/force-download");// 设置强制下载不打开
	            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
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
	                System.out.println("success");
	            } catch (Exception e) {
	                e.printStackTrace();
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

	@RequestMapping("/download2")
	public String downloadFile2(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		return null;
	}

}

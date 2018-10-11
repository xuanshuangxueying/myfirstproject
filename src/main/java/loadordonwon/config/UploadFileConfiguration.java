/**
 * 
 */
package loadordonwon.config;

/**
 * @功能:
 * @项目名:test
 * @作者:zzh
 * @日期:2018年9月3日下午5:49:52
 */
import javax.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class UploadFileConfiguration {
	 @Bean
	    public MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        // 置文件大小限制 ,超出此大小页面会抛出异常信息
	        factory.setMaxFileSize("20MB"); //KB,MB
	        // 设置总上传数据总大小
	        factory.setMaxRequestSize("30MB");
	        // 设置文件临时文件夹路径
	        // factory.setLocation("E://test//");
	        // 如果文件大于这个值，将以文件的形式存储，如果小于这个值文件将存储在内存中，默认为0
	        // factory.setMaxRequestSize(0);
	        return factory.createMultipartConfig();
	    }
}
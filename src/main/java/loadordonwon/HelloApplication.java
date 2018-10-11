/**
 * 
 */
package loadordonwon;

/**
 * @功能:
 * @项目名:test
 * @作者:zzh
 * @日期:2018年9月3日下午5:05:46
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages="loadordonwon")
public class HelloApplication {

    public static void main(String[] args) {
       // SpringApplication.run(HelloApplication.class, args);
        SpringApplication application = new SpringApplication(HelloApplication.class);
        //关闭banner横幅
        //application.setBannerMode(Mode.OFF);
        application.run(args);
    }

}

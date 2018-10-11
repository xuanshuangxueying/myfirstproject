/**
 * 
 */
package loadordonwon.upload;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MailSSLSocketFactory;



 
public class emailUtil{
  public static void sendEmail( String to,String from,String title,String content,String filePath)  {
    // 指定发送邮件的主机为 smtp.qq.com
      String host = "smtp.qq.com";//QQ 邮件服务器
 
      // 获取系统属性
      Properties properties = System.getProperties();
     
      // 设置邮件服务器
      properties.setProperty("mail.smtp.host", host);
  
      properties.put("mail.smtp.auth", "true");
      // 关于QQ邮箱，还要设置SSL加密
      try { 
    	  MailSSLSocketFactory sf = new MailSSLSocketFactory();
	      sf.setTrustAllHosts(true);
	      properties.put("mail.smtp.ssl.enable", "true");
	      properties.put("mail.smtp.ssl.socketFactory", sf);
	      }
      catch(Exception e){
    	  e.printStackTrace();
      }
     
      // 获取默认session对象
      Session session = Session.getInstance(properties,new Authenticator(){
        public PasswordAuthentication getPasswordAuthentication(){
         return new PasswordAuthentication("1637010331@qq.com", "pdpqxdbgojwbdgif"); //发件人邮件用户名、密码
        }
       });
 
      try{
    	  
    	  // 创建默认的 MimeMessage 对象。
          MimeMessage message = new MimeMessage(session);
  
          // Set From: 头部头字段
          message.setFrom(new InternetAddress(from));
  
          // Set To: 头部头字段
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
 
          // Set Subject: 头字段
          message.setSubject(title);
  
          // 创建消息部分
          BodyPart messageBodyPart = new MimeBodyPart();
  
          // 消息
          messageBodyPart.setText(content);
         
          // 创建多重消息
          Multipart multipart = new MimeMultipart();
  
          // 设置文本消息部分
          multipart.addBodyPart(messageBodyPart);
  
      
          
         // File file = new File("E:/新昌中学简介.txt");
          if(filePath!="") {
        	  try { 
        		   // 附件部分
                  messageBodyPart = new MimeBodyPart();
    	          File file = new File(filePath);
    	          DataSource source = new FileDataSource(file);
    	          messageBodyPart.setDataHandler(new DataHandler(source));
    	          messageBodyPart.setFileName(MimeUtility.encodeText(file.getName()));//解决附件标题乱码
    	          multipart.addBodyPart(messageBodyPart);
        	      }
              catch(Exception e){
            	  e.printStackTrace();
              }
        	 
	     }
          // 发送完整消息
          message.setContent(multipart);
          //   发送消息
          Transport.send(message);
          System.out.println("发送成功");
      }catch (MessagingException mex) {
         mex.printStackTrace();
   }
}}
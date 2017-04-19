import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

public class Mail2Test2
{

    public static void main(String[] args) throws MessagingException, IOException
    {

        Map<String,String> map= new HashMap<String,String>();
        Mail2Test mail = new Mail2Test("285257188@qq.com","kjylpsaqamgrcbcc");
        map.put("mail.smtp.host", "smtp.qq.com");

        //暂时未成功，需要调试
        /*SendMail mail = new SendMail("14789****@sina.cn","***miya");
        map.put("mail.smtp.host", "smtp.sina.com");*/
        map.put("mail.smtp.auth", "true");
        map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        map.put("mail.smtp.port", "465");
        map.put("mail.smtp.socketFactory.port", "465");
        mail.setPros(map);
        mail.initMessage();
        /*
         * 添加收件人有三种方法：
         * 1,单人添加(单人发送)调用setRecipient(str);发送String类型
         * 2,多人添加(群发)调用setRecipients(list);发送list集合类型
         * 3,多人添加(群发)调用setRecipients(sb);发送StringBuffer类型
         */
        for(int i=1;i<11;i++){
	        List<String> list = new ArrayList<String>();
	        list.clear();
	        mail.setRecipient("312748974@qq.com");
	        /*String defaultStr = "283942930@qq.com,429353942@qq.com,2355663819@qq.com,381766286@qq.com;
	        StringBuffer sb = new StringBuffer();
	        sb.append(defaultStr);
	        sb.append(",8888888@qq.com");
	        mail.setRecipients(sb);*/
	        String str = "第"+String.valueOf(i)+"封";
	        mail.setSubject(str);
	        //mail.setText("谢谢合作");
	        mail.setDate(new Date());
	        mail.setFrom("MY");
	//      mail.setMultipart("D:你你你.txt");
	        mail.setContent(str+str+str, "text/html; charset=UTF-8");
	        /*List<String> fileList = new ArrayList<String>();
	        fileList.add("D:1.jpg");
	        fileList.add("D:activation.zip");
	        fileList.add("D:dstz.sql");
	        fileList.add("D:软件配置要求.doc");
	        mail.setMultiparts(fileList);*/
	        mail.sendMessage();
        }
        //System.out.println(mail.sendMessage());
    }

}
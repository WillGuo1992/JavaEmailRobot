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

        //��ʱδ�ɹ�����Ҫ����
        /*SendMail mail = new SendMail("14789****@sina.cn","***miya");
        map.put("mail.smtp.host", "smtp.sina.com");*/
        map.put("mail.smtp.auth", "true");
        map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        map.put("mail.smtp.port", "465");
        map.put("mail.smtp.socketFactory.port", "465");
        mail.setPros(map);
        mail.initMessage();
        /*
         * ����ռ��������ַ�����
         * 1,�������(���˷���)����setRecipient(str);����String����
         * 2,�������(Ⱥ��)����setRecipients(list);����list��������
         * 3,�������(Ⱥ��)����setRecipients(sb);����StringBuffer����
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
	        String str = "��"+String.valueOf(i)+"��";
	        mail.setSubject(str);
	        //mail.setText("лл����");
	        mail.setDate(new Date());
	        mail.setFrom("MY");
	//      mail.setMultipart("D:������.txt");
	        mail.setContent(str+str+str, "text/html; charset=UTF-8");
	        /*List<String> fileList = new ArrayList<String>();
	        fileList.add("D:1.jpg");
	        fileList.add("D:activation.zip");
	        fileList.add("D:dstz.sql");
	        fileList.add("D:�������Ҫ��.doc");
	        mail.setMultiparts(fileList);*/
	        mail.sendMessage();
        }
        //System.out.println(mail.sendMessage());
    }

}
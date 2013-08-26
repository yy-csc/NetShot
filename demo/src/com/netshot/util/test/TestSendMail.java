package com.netshot.util.test;

import com.netshot.util.MailSenderInfo;
import com.netshot.util.MailSimpleSender;

public class TestSendMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setValidate(false);
//		mailInfo.setUserName("yhu2@csc.com");// your email address
//		mailInfo.setPassword("xxxxxx");// password of the mail box
		mailInfo.setFromAddress("CSC_OSM_Admin@csc.com");// set the sender
		mailInfo.setToAddress(new String[]{"yhu2@csc.com", "wxu9@csc.com"});// set the recipient
		mailInfo.setSubject("This is the Title of your EMail");// set the title

//		mailInfo.setContent("<font color='red'><b>This is the Body of the EMail</b></font>");
//		MailSimpleSender.sendMail(mailInfo, false);// send text formatting

		mailInfo.setContent("<font color='red'><b>This is the Body of the EMail</b></font>");
		MailSimpleSender.sendMail(mailInfo, true);// send HTML text formatting
	}

}

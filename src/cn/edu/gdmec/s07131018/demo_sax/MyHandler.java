package cn.edu.gdmec.s07131018.demo_sax;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.UserDataHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.R.integer;

public class MyHandler extends DefaultHandler {
	private User user;
	private List<User> users;
	private String content;
	
	public List<User> getUsers(){
		return users;
	}
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		this.users = new ArrayList<User>();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if("user".equals(localName)){
			user = new User();
			user.setId(Integer.parseInt(attributes.getValue("id")));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		if("name".equals(localName)){
			user.setName(content);
		}
		if("password".equals(localName)){
			user.setPassword(content);
		}
		if("user".endsWith(localName)){
			users.add(user);
			user=null;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		content = new String(ch,start,length);
	}
	
}

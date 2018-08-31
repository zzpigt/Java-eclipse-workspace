package cn.zzpigt.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import cn.zzpigt.bean.Student;

public class DemoSAX {
	public static void main(String[] args) {
		
	}
	
	public static List<Student> parse() {
		List<Student> list = new ArrayList<>();
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser saxParse = spf.newSAXParser();
			saxParse.parse(new FileInputStream("student.xml"), new MyHandler());
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public class MyHandler extends DefaultHandler{

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
		}

		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			
			
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			super.endElement(uri, localName, qName);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
		}
		
	}
}

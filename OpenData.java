package com.opendata;
import java.io.*;
import java.util.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;
import java.lang.*;
import java.net.URL;


public class OpenData {

	public static void main(String[] args)throws IOException {
		URL url = new URL("http://140.116.165.74/qry/qry001.php?dept_no=F7");
		//URL url = new URL("http://www.dgbas.gov.tw/ct.asp?xItem=13213&CtNode=3504&mp=1");
		Document doc = Jsoup.parse(url, 3000);  
		Element jsElms = doc.select("table").get(0);  
		Iterator <Element> iter = jsElms.select("tr").iterator();  
		while(iter.hasNext())  
		{  
			System.out.println( iter.next().text());
		}
		
	}

}

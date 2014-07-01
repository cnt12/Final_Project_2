package com.opendata;
import java.io.*;
import java.util.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;
import java.lang.*;
import java.net.URL;



public class OpenData {

		
	 public  void parse_teacher()throws IOException{

		 
		String input;
		System.out.println("請輸入你要查詢的課程老師名稱:");
		Scanner sc = new Scanner(System.in);
		input = sc.next();
		System.out.println("輸入資料查詢中，請稍後......");
		 URL url = new URL("http://140.116.165.74/qry/qry001.php?dept_no=F7");
		
		Document doc = Jsoup.parse(url, 3000);  
		Element jsElms = doc.select("table").get(0);  
		Iterator <Element> iter = jsElms.select("td").iterator();  
		
		boolean find = false;
		String mt = null;
		
		while(iter.hasNext())  
		{  
			mt = iter.next().text();
			if(mt.equals(input)){
				System.out.println(mt+"的確有");
				find = true;
				break;
			}
				
			
		}
		if(!find)
			System.out.println("找不到與 "+mt+" 的相關資料");
		System.out.println("-----------------");
	}
	 
	 public static void main(String args[])throws IOException {
			
			OpenData op = new OpenData();
			
		    while(true)
			op.parse_teacher();
			
		}

	 
}


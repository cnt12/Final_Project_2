package com.opendata;
import java.io.*;
import java.util.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;
import java.lang.*;
import java.net.URL;
import org.json.*;



public class OpenData {

	private  URL url = null;
	String[] EE_Courses={"E2","F7","N2","P7","P9","Q1","Q3","Q5"};
	String[] SS_Courses={"D2","D4","D5","D8","U1","U2","U3","U5","U6","U7"};
	String[] MS_Courses={"H1","H2","H3","H4","H5","R0","R1","R2","R3","R4","R5","R6","R7","R8","R9","RA","RB","RD","RZ"};
	
	
	
		
	OpenData(){
		
	}
	public  int parse_teacher(String url_str,String input)throws IOException{

		 
		//String input;
		
		//Scanner sc = new Scanner(System.in);
		//input = sc.next();
		//System.out.println("輸入資料查詢中，請稍後......");
		url = new URL(url_str);
		
		Document doc = Jsoup.parse(url, 3000);  
		Element jsElms = doc.select("table").get(0);  
		ListIterator <Element> iter = jsElms.select("td").listIterator();  
		
		boolean find = false;
		String mt = null;
		
		while(iter.hasNext())  
		{  
			
			mt = iter.next().text();
			//Iterator <Element> col = 
			if(input.equals(mt)){
				//System.out.println("找到了"+mt);
				for(int i=0;i<12;i++)
				if(iter.hasPrevious()==true)iter.previous();
				
				mt = iter.next().text();
				for(int i=0;i<22;i++){
					System.out.print(mt+" ");
					if(iter.hasNext())mt = iter.next().text();
					else break;}
				
				System.out.println("");
				find = true;
				break;
			}
				
			
		}
		if(!find){
			//System.out.println("找不到與 "+mt+" 的相關資料");
			//System.out.println("-----------------");
			return 0;
		}else{
			//System.out.println("-----------------");
			return 1;
		}
			
		
	}
	public void teacher_finder(){
		System.out.println("請輸入你要找的學院(預設是EE)");
		System.out.println("EE 表示 電機資訊學院");
		System.out.println("SS 表示 社會科學學院");
		System.out.println("MS 表示 管理學院");
		System.out.print("你的選擇是: ");
		Scanner sc = new Scanner(System.in);
		String opt = sc.next();
		String url_orig = "http://140.116.165.74/qry/qry001.php?dept_no=";
		String tea = null;
		try{
			if(opt.equals("SS")){
				System.out.println("請輸入你要查詢的課程老師名稱:");
				tea = sc.next();
				System.out.println("輸入資料查詢中，請稍後......");
				for(String str:SS_Courses){
				String url_add = url_orig + str;
				parse_teacher(url_add,tea);
				}
				System.out.println("搜索結束");
			}else if(opt.equals("MS")){
				System.out.println("請輸入你要查詢的課程老師名稱:");
				tea = sc.next();
				System.out.println("輸入資料查詢中，請稍後......");
				for(String str:MS_Courses){
				String url_add = url_orig + str;
				parse_teacher(url_add,tea);
				}
				System.out.println("搜索結束");
				
			}else{
				System.out.println("請輸入你要查詢的課程老師名稱:");
				tea = sc.next();
				System.out.println("輸入資料查詢中，請稍後......");
				for(String str:EE_Courses){
				String url_add = url_orig + str;
				parse_teacher(url_add,tea);
				//System.out.println(url_add+" "+tea);
				}	
				System.out.println("搜索結束");
				
			}
		
		}catch(IOException e){e.printStackTrace();}
		
	}
	 public static void main(String args[])throws IOException {
			
			OpenData op = new OpenData();
			//String str1 = "http://140.116.165.74/qry/qry001.php?dept_no=F7";
			//System.out.println("請輸入你要查詢的課程老師名稱:");
			op.teacher_finder();
			
		}

	 
}


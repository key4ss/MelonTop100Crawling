package model;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crwaling {
	public static void main(String[] args) {
		final String url="https://www.melon.com/chart/index.htm"; // top100
		final String url2="https://www.melon.com/album/detail.htm?albumId="; // 상세보기
		Document doc=null; // top100
		Document doc1=null; // 상세보기
		DAO dao=new DAO();
		
		try {
			doc=Jsoup.connect(url).get(); // top100접속
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements e1=doc.select(".ellipsis"); // title, artist, album
		Elements e2=doc.select("div > a > img"); // album 이미지

		Iterator<Element> itr1 = e1.iterator();
		Iterator<Element> itr2 = e1.iterator();
		Iterator<Element> itr3 = e1.iterator();
		Iterator<Element> itr4 = e2.iterator();

		while(itr4.hasNext()) {
			VO vo=new VO();
			String str1=itr1.next().text(); // title
			String str2=itr1.next().text(); // artist
			String res=str2.substring(0,str2.length()/2); // artist 2번 출력하는거 자르기
			String str3=itr1.next().text(); // album
			String str4=itr4.next().attr("src"); // 이미지주소
			
			vo.setTitle(str1);
			vo.setArtist(res); 
			vo.setAlbum(str3);
			
			String s; // 상세주소 albumId값을 위한 임시변수
			if(str4.length()==107) { // 주소의 길이가 107이면
				s=str4.substring(54, str4.indexOf("_")); // 길이가 107인 주소의 albumId값
			}
			else { // 주소의 길이가 108이면
				s=str4.substring(55, str4.indexOf("_")); // 길이가 108인 주소의 albumId값
			}

			try {
				doc1=Jsoup.connect(url2+s).get(); // albumId값의 상세보기 접속
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Elements e3=doc1.select("dl.list > dd"); // 발매일, 장르, 발매사, 기획사
			Iterator<Element> itr5 = e3.iterator();
			while(itr5.hasNext()) {
				String str5=itr5.next().text(); // 발매일
				String str6=itr5.next().text(); // 장르
				String str7=itr5.next().text(); // 발매사
				String str8=itr5.next().text(); // 기획사

				vo.setDay(str5);
				vo.setGenre(str6);		
				vo.setPublisher(str7);
				vo.setAgency(str8);
			}
			dao.insert(vo);	// 추가
		}
		System.out.println("로그: 샘플데이터 저장완료!");

	}
}

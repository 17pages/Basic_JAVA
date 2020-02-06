package naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import domain.MovieDTO;
import persistence.MovieDAO;

public class NaverMovie {
	public static void main(String[] args) throws IOException{
		String base = "https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=191431&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page=";
		int page = 1;
		String url = base + page;
		int count = 0;
		int total=0;
		double scoreAvg = 0.0;
		String compare = ""; //flag
		MovieDAO mDao = new MovieDAO();
		
		//영화제목 수집
		Document movieDoc = Jsoup.connect("https://movie.naver.com/movie/bi/mi/basic.nhn?code=191431#u_skip");
		title = movieDoc.select("h3.h_movie > a:nth-child(1)").first();
		
		//페이지를 돌면서 댓글을 수집
		label:while(true) {
			//1페이지의 평점 10건 수집
		
			Document doc = Jsoup.connect(url).get();
			Elements reply = doc.select("div.score_result > ul > li");
		
		int score, regdate = 0;
		String writer, content = "";
		
		//평점 1건 수집
		for( int i = 0; < reply.size(); i++) {
			score = Integer.parseInt(reply.get(i).select("div.star_score em").text());
			content = reply.get(i).select(".score_reple > p").text();
			writer = reply.get(i).select("div.score_reple dl dt em a").text();
			regdate = Integer.parseInt(reply.get(i).select("div.score_reple dl dt em:last-child").text());
		}
				
				
				
				
				
				
				
		while(true) {
		
			
						
			String writer, basedate, subdate="";
			int score, regdate = 0;
			
			
			
			
			
			for(Element one : reply) {
				count++;
				
				writer = one.select("div.score_reple dl dt em a").text();
				score = Integer.parseInt(one.select("li div.star_score em").text());
				content =  one.select(".score_reple > p").text();
				basedate = one.select("div.score_reple dl dt em:last-child").text();
				subdate = basedate.substring(0,10);
				regdate = Integer.parseInt(subdate.replace(".", ""));
				total += score;
				
				
				MovieDTO mDto = new MovieDTO(title, content, writer, score, "naver", regdate);
				
				mDao.addMovie(mDto);
				System.out.println("▶▶▶▶▶▶▶▶▶▶▶▶▶" + count + "건◀◀◀◀◀◀◀◀◀◀◀◀◀◀");
				System.out.println("영화 : " + title);
				System.out.println("평점 : " + score);
				System.out.println("작성자 : " + writer);
				System.out.println("내용 : " + content);
				System.out.println("작성일 : " + regdate);
				
				
			}
			url= base + page;
			page++;
			
			
			comContent = content;
			if(content.equals(comContent)) {
				break;
			}
			
			
			
			
			
		}
		scoreAvg = (double)total / count;
		Double result = Math.floor(scoreAvg);
		
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒ '"+ title +"' Daum 영화 평점 수집 결과 ");
		System.out.println("▒▒ " + (page-1) + "페이지에서");
		System.out.println("▒▒ 총 " + count + "건의 평점을 수집완료");
		System.out.println("▒▒ 평균평점 : " + result + "점 :)");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

	}

}

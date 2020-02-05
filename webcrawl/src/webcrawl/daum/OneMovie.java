package webcrawl.daum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OneMovie {
	public static void main (String[] args) throws IOException{
		String url="https://movie.daum.net/moviedb/grade?movieId=134091&type=netizen";
		Document doc = Jsoup.connect(url).get();
		
		Element urls = doc.select("ul.list_review list_netizen > a.review_info");
		int count = 0;
		
		for(Element element : urls) {
			count++;
			String href = element.attr("href");
			Document docMovie = Jsoup.connect(href).get();
			
			//평점
			Elements star = docMovie.select("em.emph_grade");
			//작성자
			Elements write = docMovie.select("em.link_profile");
			//내용
			Elements content = docMovie.select("p.desc_review");
			//작성일자
			Elements days = docMovie.select("span.info_append");
			//수집
			
			

			System.out.println("▶▶▶▶▶▶▶▶▶▶▶▶▶"+count+"건◀◀◀◀◀◀◀◀◀◀◀◀◀◀");
			System.out.println("평점 : " + star.text()); 
			System.out.println("작성자 : " + write.text()); 
			System.out.println("내용 : " + content.text()); 
			System.out.println("작성일 | " + days.text()); 
		}
			
		}
		
		
	
		
		
		
	
		
	
}

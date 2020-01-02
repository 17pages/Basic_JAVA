package problem.board;

import java.util.Scanner;

public class BoardMMain {
	
	static String session = "NO"; //로그인 유무(YES : LOGIN ok)
	static String userid = ""; // 로그인 유저의 ID값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		BoardMDAO mDao = new BoardMDAO();//게시글 관련 기능
		MemberDAO mmDao = new MemberDAO();//회원관련기능
		
		int code = 0;

		while (true) {
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			System.out.println("▣▣ 허쉬 게시판");
			mDao.selectBoard();
			System.out.println("▣▣ 0. 로그인");
			System.out.println("▣▣ 1. 게시글 등록");
			System.out.println("▣▣ 2. 게시글 수정");
			System.out.println("▣▣ 3. 게시글 삭제");
			System.out.println("▣▣ 4. 게시글 조회");
			System.out.println("▣▣ 5. 게시글 검색");
			System.out.println("▣▣ 6. 게시글 정렬");
			System.out.println("▣▣ 7. 상세 게시글");
			System.out.println("▣▣ 8. 프로그램 종료");
			
			if(BoardMMain.session.contentEquals("YES")) {
			System.out.println("▣▣ " + BoardMMain.userid + " 님 재방문을 환영합니다.");
			}
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			while (true) {
				System.out.print("▣▣ 번호 >> ");
				code = sc.nextInt();

				if (code >= 0 && code <= 8) {
					break;
				} else {
					System.out.println("▣▣ 1 ~ 8 까지 올바른 값을 입력하세요.");
					continue;
				}
			}
			BoardMDAO mDAO = new BoardMDAO();

			if(code==0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 로그인할 ID와 PW를 입력해주세요.");
				System.out.print("▶▶ ID >>");
				sc.nextLine();
				String id = sc.nextLine();
				System.out.print("▶▶ PW >>");
				String pw = sc.nextLine();
				
				mmDao.login(id, pw);
			}
			else if (code == 1) {//등록
				
				if(BoardMMain.session.equals("NO")) {
					System.out.println("▶▶ 로그인이 필요한 기능입니다.");
					continue;
				}
				
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 등록할 게시글 정보를 입력해주세요.");
				System.out.print("▶▶ 제목 >>");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▶▶ 내용 >>");
				String content = sc.nextLine();
				String writer = BoardMMain.userid; //로그인한 유저 ID = 작성자
								
				mDao.insertBoard(title, content, writer);

			} else if (code == 2) {//수정
				
				
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 수정할 게시글 번호를 입력해주세요.");
				
				System.out.print("▶▶ 번호 >>");
				
				int bno = sc.nextInt();
				System.out.print("▶▶ 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▶▶ 내용 >> ");
				String content = sc.nextLine();
				System.out.print("▶▶ 작성자 >> ");
				String writer = BoardMMain.userid;
				
				mDao.updateBoard(bno, title, content, writer);

			} else if (code == 3) {//삭제
				
				
				if(BoardMMain.session.equals("NO")) {
					System.out.println("▶▶ 로그인이 필요한 기능입니다.");
					continue;
				}
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 삭제할 게시글 번호를 입력해주세요.");
				
				System.out.println("▶▶ 번호 >>");
				int bno = sc.nextInt();
				String getuser = mDao.getWriter(bno);
								
				if(BoardMMain.userid.equals(getuser)) {
					mDao.deleteBoard(bno);
					System.out.println("▶▶ " + bno + "번의 글을 삭제했습니다.");
				}else {
					System.out.println("▶▶ 게시자가 일치하지 않습니다.");
				}
				
								
				mDao.deleteBoard(bno);

			} else if (code == 4) {//조회
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 게시판을 조회합니다.");
				mDao.selectBoard();
				
			} else if (code == 5) {//검색
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 검색할 키워드를 입력하세요.");
				System.out.print("▶▶ 검색 >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				mDao.searchBoard(keyword);

			} else if (code == 6) {//정렬
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 게시판을 정렬합니다.");
				
				mDao.sortBoard();

			} else if (code == 7) {//상세게시글
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 보고싶은 게시글 번호를 입력하세요.");
				System.out.print("▶▶ 게시글번호 >> ");
				int bno = sc.nextInt();
				//mDao.viewBoard(bno);

			} else if (code == 8) {//종료
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ [프로그램 종료] ◀◀");
				System.exit(0);
			}

		}

	}
}

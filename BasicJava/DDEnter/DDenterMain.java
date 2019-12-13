package problem.DDEnter;

import java.util.Scanner;



public class DDenterMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {//반복문
			// 1. 화면에 출력하는 부분
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦ 더블디 엔터 관리 시스템");
			System.out.println("▦▦ 1. 아티스트 등록");
			System.out.println("▦▦ 2. 아티스트 수정");
			System.out.println("▦▦ 3. 아티스트 해지");
			System.out.println("▦▦ 4. 아티스트 조회");
			System.out.println("▦▦ 5. 아티스트 검색");
			System.out.println("▦▦ 6. 프로그램 종료");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");

			// 사용자가 1~6까지 입력하기전까지 계속 번호를 입력하게 도는 반복문 (경고 메시지 출력)
			// 2. 사용자가 실행할 프로그램을 입력받는 부분.
			
			int code = 0; // 지역변수라 안되니까 밖에서 선언해줌
			while (true) {
				System.out.print("번호 >> ");
				code = sc.nextInt(); //지역변수.. int code = sc.nextInt();

				// 1~6인 경우에만 무한반복을 빠져나감!
				if (code >= 1 && code <= 6) { //1보다 크거나같고 6보다 작거나 같을때, &&이기 때문에 TT여야함.
					break; // 가장 가까운 반복문 빠져나감.
				} else {
					System.out.println("▦▦ 1~6까지 올바른 값을 입력하세요.");
					continue;// 가장 가까운 반복문 빠져나감.
				}
			}//break 가 빠져나감
			// 사용자가 입력한 값 1~6인경우
			// 각 코드마다 등록, 수정, 삭제, 조회, 검색의 기능들을 메서드화 시킨다. 다 있으면 복잡하니까 클래스를 만듦. 
			// MemverDAO Class (DAO는 DB작업한다는 뜻. 데이터베이스 엑세스 오브젝트)
			
			MemberDAO mDao = new MemberDAO();//객체생성 MemberDAO의 클래스에 가서 객체 생성. 
			//생성자메서드 호출을 위해 MemberDAO감 디폴트로 생성자를 만들어줌. 그 안이 비었기때문에 다시 여기로 돌아옴. 
			if (code == 1) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("▦▦ 계약할 아티스트 정보를 입력해주세요.");
				System.out.print("▦▦ 이름 >>");
				sc.nextLine();
				String aname = sc.nextLine(); // 
				System.out.print("▦▦ 분야 >>");
				String major = sc.nextLine();
				System.out.print("▦▦ 그룹유무(Y/N) >>");
				String groupyn = sc.nextLine();
				System.out.print("▦▦ 그룹이름 >>");
				String groupnm = sc.nextLine();
				System.out.print("▦▦ 연봉 >>");
				int sal = sc.nextInt(); // 여기까지 사용자에게 값을 입력받았음.
				
				MemberDTO mDto = new MemberDTO(aname, major, groupyn, groupnm, sal); //객체생성 //memberDTO가서 값가져와 // 무슨생성자를 가져올지 구분하는법 : ()안에 5개있으니 저쪽도 다섯개 가진거 
				mDao.memInsert(mDto);

			} else if (code == 2) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("▦▦ 수정할 아티스트 번호를 입력해주세요.");
				System.out.print("▦▦ 번호 >>");
				sc.nextLine();
				String ano = sc.nextLine();
				System.out.print("▦▦ 이름 >>");
				String aname = sc.nextLine(); // 
				System.out.print("▦▦ 분야 >>");
				String major = sc.nextLine();
				System.out.print("▦▦ 그룹유무(Y/N) >>");
				String groupyn = sc.nextLine();
				System.out.print("▦▦ 그룹이름 >>");
				String groupnm = sc.nextLine();
				System.out.print("▦▦ 연봉 >>");
				int sal = sc.nextInt(); // 여기까지 사용자에게 값을 입력받았음.
				
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal);
						
				
				mDao.memUpdate(mDto);

			} else if (code == 3) {//소속 아티스트 삭제
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("▦▦ 삭제할 아티스트 번호를 입력하세요.");
				System.out.print("▦▦ 번호 >> ");
				sc.nextLine();
				String ano = sc.nextLine();
				mDao.memDelete(ano);//삭제하는 애

			} else if (code == 4) {
				mDao.memSelect();

			} else if (code == 5) {
				mDao.memSearch();

			} else if (code == 6) { //종료하는 법
					System.out.println("<프로그램 종료>");
					System.exit(0); //0은 즉시 종료라는 뜻
			}
		}
	}
}

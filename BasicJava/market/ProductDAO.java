package market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	Boolean flag; // default : false

	// 제품 등록 &추가 기능 작동시 기존에 등록된 제품인지 최초입고제품인지 판벼하는 기능

	public boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession();
		flag = false;
		try {
			result = sqlSession.selectOne("pdt.already", pname);

			if (result > 0) { // 있음
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}

	public void cntPlusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			ProductDTO pDto = new ProductDTO(pname,cnt);
			result = sqlSession.update("pdt.cntPlus", pDto);
			if (result > 0) {
				System.out.println("▥▥ 제품이 추가 입고 되었습니다.");
			} else {
				System.out.println("▥▥ 추가 입고 등록에 실패하였습니다. 관리자에게 문의하세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
	public void insertPdt(String pname, String company, int price, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("company", company);
		map.put("price", price);
		map.put("cnt", cnt);
		try {
			result = sqlSession.insert("pdt.insert", map);
			
			if(result >0) {
				System.out.println("▥▥ 제품 등록 성공");
			}else{
				System.out.println("▥▥ 제품 등록 실패. 관리자에게 문의하세요.");
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}

	public void selectProduct () {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("selectProduct");
			for(ProductDTO line : list) {
				System.out.println(line.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
	}
	
	public void searchProduct (String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			list = sqlSession.selectList("searchProduct", keyword);
			System.out.println(list.size() + " 건 이 검색되었습니다.");
			for(ProductDTO line : list) {
				System.out.println(line.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}
	public void updateProduct(String pname, int price) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("price", price);
		
		try {
			result = sqlSession.update("updateProduct", map);
			
			if(result > 0) {
				System.out.println("▥▥  " + pname + "의 정보가 수정되었습니다.");
			}else {
				System.out.println("제품 정보 수정에 실패하였습니다. 관리자에게 문의하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	public void deleteProduct(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("deleteProduct", pname);
			
			if(result>0) {
				System.out.println("▥▥ " + pname + "제품을 삭제하였습니다.");
			}else{
				System.out.println("▥▥ 제품 삭제에 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
	}
	
}

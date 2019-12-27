package com.biz.jdbc.exec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.config.DBcontract;

public class JDBC_Ex01 {
	public static void main(String[] args) {
		
		PreparedStatement pst = null;
		String sql = DBcontract.CRUD.SELECT_ALL;
		
		Connection dbconn = DBConnection.getDBConnection();
		
                          
		try {
			pst = dbconn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("=====================================");
			System.out.println("날짜\t시간\t거래구분\t거래처\t상품\t수량\t단가");
			System.out.println("-------------------------------------");
			while(rst.next()) {
				
				System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_DATE));
				System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_TIME));
				System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_INOUT));
				System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_DNAME));
				System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_PNAME));
				System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_QTY));
				System.out.print(rst.getInt(DBcontract.IO_COLIUMN.IO_PRICE));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

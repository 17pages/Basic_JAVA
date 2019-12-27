package com.biz.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.config.DBcontract;

public class IoService {

	Connection dbConn = null;
	
	public IoService() {
		this.dbConn = DBConnection.getDBConnection();
	}
	
	public void selsectAll() {
		
		PreparedStatement pst = null;
		String sql = DBcontract.CRUD.SELECT_ALL;
		
		try {
			pst = dbConn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("=====================================");
			System.out.println("SEQ\t날짜\t시간\t거래처\t상품");
			System.out.println("-------------------------------------");
			
			while(rst.next()) {
				this.listView(rst);
			}
			System.out.println("=====================================");
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void findBySeq (long io_seq) {
		
		String sql = DBcontract.CRUD.SELECT_ALL ;
		sql += " WHERE io_seq = ? ";
		
		PreparedStatement pst = null;
		
		try {
			pst = dbConn.prepareStatement(sql);
			pst.setLong(1, io_seq);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()) {
				System.out.println("===========================================");
				System.out.printf("SEQ : %d\n", rst.getLong(DBcontract.IO_COLIUMN.IO_SEQ));
				System.out.println("===========================================");
				System.out.printf("거래일자 : %s\n", rst.getString(DBcontract.IO_COLIUMN.IO_DATE));
				System.out.println("===========================================");
				System.out.printf("거래시각 : %s\n", rst.getString(DBcontract.IO_COLIUMN.IO_TIME));
				System.out.println("===========================================");
				System.out.printf("거래구분 : %s\n", rst.getString(DBcontract.IO_COLIUMN.IO_INOUT));
				System.out.println("===========================================");
				System.out.printf("거래처 : %s\n", rst.getString(DBcontract.IO_COLIUMN.IO_DNAME));
				System.out.println("===========================================");
				System.out.printf("상품명 : %s\n", rst.getString(DBcontract.IO_COLIUMN.IO_PNAME));
				System.out.println("===========================================");
				System.out.printf("수량 : %s\n", rst.getInt(DBcontract.IO_COLIUMN.IO_QTY));
				System.out.println("===========================================");
				System.out.printf("단가 : %s\n", rst.getInt(DBcontract.IO_COLIUMN.IO_PRICE));
			
			}
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listView(ResultSet rst) throws SQLException {

		System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_SEQ) + "\t");
		System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_DATE) + "\t");
		System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_TIME) + "\t");
		System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_DNAME) + "\t");
		System.out.print(rst.getString(DBcontract.IO_COLIUMN.IO_PNAME) + "\t");
	}
}

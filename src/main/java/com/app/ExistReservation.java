package com.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExistReservation {

	

	   public  boolean reservationExixts(Connection conn, int reservationId) {
	  
		try {
			
			String sql = "SELECT * FROM reservations WHERE id = " + reservationId;
			
			try (Statement statement = conn.createStatement();
					ResultSet rs = statement.executeQuery(sql)) {
				
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		

	}
}
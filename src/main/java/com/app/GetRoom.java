package com.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetRoom {

	
	  void getRoomNumber(Connection conn, Scanner sc) {
		
		try {
			
			System.out.println("Enter Reservation ID: ");
			int reservationId = sc.nextInt();
			System.out.println("Enter guest Name: ");
			String guestName = sc.next();
			
			String sql = "SELECT  r_number  FROM reservations "
					+ "WHERE id = "+ reservationId +" AND name = '" + guestName +"'";
			
			try (Statement statement = conn.createStatement();
					
					ResultSet rs = statement.executeQuery(sql)) {
				
				if (rs.next()) {
				  int roomNumber = rs.getInt("r_number");
				  System.out.println("Room Number for reservation ID: " + reservationId + " and guest " + guestName + " is: " + roomNumber);
				} else {
					System.out.println("Room not found for the given ID and guest name.");
				}
			
			} 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}


	
}

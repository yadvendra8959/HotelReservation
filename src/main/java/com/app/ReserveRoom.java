package com.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReserveRoom {

	
   public void reserveRoom(Connection conn, Scanner sc) {
		
		try {
			
			System.out.println("Enter guest name: ");
			String guestName = sc.next();
			
			System.out.println("Enter contact number: ");
			String contactNumber = sc.next();
			
			System.out.println("Enter room number: ");
			int roomNumber = sc.nextInt();
			
			String sql = "INSERT INTO reservations (name, number, r_number)"
					+ "VALUES('"+ guestName +"', "+ contactNumber + ", '"+ roomNumber +"')";
			
			try (Statement statement = conn.createStatement())  {
				
				int affectedRows = statement.executeUpdate(sql);
				
				if (affectedRows > 0) {
					System.out.println("Reservation Successful");
				}else {
					System.out.println("Reservation failed");
				}
				
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
		 
}

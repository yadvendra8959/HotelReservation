package com.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateReservation {

	
	public void updateReservation(Connection conn, Scanner sc) {
		
		ExistReservation er = new ExistReservation();
		try {
		   System.out.println("Enter reservation ID: ");
		   int reservationId = sc.nextInt();
		   sc.nextLine();
		   
		   if (!er.reservationExixts(conn, reservationId)) {
			System.out.println("Reservation not found for the given ID: ");
			return;
		}
		   
		   System.out.println("Enter new guest name: ");
		   String newGuestName = sc.next();
		   
		   System.out.println("Enter new contact Number: ");
		   String newContactNumber = sc.next();
		   
		   System.out.println("Enter new room number: ");
		   int newRoomNumber = sc.nextInt();
		   
		   String sql = "UPDATE reservations SET name = '" + newGuestName + "',"
		   		+ "number = '" + newContactNumber +"',"
		   				+ "r_number = "+ newRoomNumber +" " 
		   						+ "WHERE id = " +reservationId;
		   
		   try (Statement statement = conn.createStatement()) {
				  
			   int affectedRows = statement.executeUpdate(sql);
				   
				   if (affectedRows > 0) {
					System.out.println("Reservation Updated Successfully");
				}else {
					System.out.println("Reservation Update Failed.");
				}
				  
			
		} 
				   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}

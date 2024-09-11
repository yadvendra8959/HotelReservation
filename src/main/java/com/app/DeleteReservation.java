package com.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteReservation {

	

	public void deleteReservation(Connection conn, Scanner sc) {
		
		ExistReservation er = new ExistReservation();
		
		try {
			
			System.out.println("Enter reservation ID to delete: ");
			int reservationId = sc.nextInt();
			
			if(!er.reservationExixts(conn, reservationId)) {
				System.out.println("Reservation not found for given ID: ");
				return;
			}
			
			String sql = "DELETE FROM reservations WHERE id = " + reservationId;
			
			try (Statement statement = conn.createStatement()) {
				
				int affectedRows = statement.executeUpdate(sql);
				
				if (affectedRows >0 ) {
					System.out.println("Reservation Deleted Successfully.");
					
				}else {
					System.out.println("Reservation deletion failed.");
				}	
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

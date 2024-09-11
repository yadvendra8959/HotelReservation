package com.app;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static final String url = "jdbc:mysql://localhost:3307/hotel_db";
    public static final String username = "root";
    public static  final String password = "Root@password23";
    
    public static void main( String[] args )
    {
        
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
    	
    	try {
			Connection conn = DriverManager.getConnection(url, username, password);
		
             while(true) {
            	 System.out.println();
            	 System.out.println("Hotel Management System");
                 Scanner sc = new Scanner(System.in);
                 System.out.println("1. Reserve a Room");
                 System.out.println("2. View Reservation");
                 System.out.println("3. Get Room Number");
                 System.out.println("4. Update Reservation");
                 System.out.println("5. Delete Reservation");
                 System.out.println("0. Exit");
                 
                 int choice = sc.nextInt();
                 
                 switch (choice) {
				case 1:
					ReserveRoom reserve = new ReserveRoom();
					reserve.reserveRoom(conn, sc);
					break;
					
				case 2:
				    
					ViewReservation view = new ViewReservation();
					view.viewReservation(conn);
					break;
				
				case 3:
					
					GetRoom get = new GetRoom();
					get.getRoomNumber(conn, sc);
					break;
					
				case 4:
					
					UpdateReservation update = new UpdateReservation();
					update.updateReservation(conn, sc);
					break;
					
				case 5:
					DeleteReservation delete = new DeleteReservation();
					delete.deleteReservation(conn, sc);
					break;
					
				case 0:
					Exit exit = new Exit();
					exit.exit();
					sc.close();
					return;

				default:
					System.out.println("Invalid choice. Please try again.");
				}
            	 
             }   	
    	
    	} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	catch (InterruptedException e) {
			throw new RuntimeException();
		}
    }

	

		

    
}

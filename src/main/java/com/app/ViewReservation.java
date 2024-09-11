package com.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewReservation {

    void viewReservation(Connection conn) throws SQLException {
        String sql = "SELECT * FROM reservations";

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Current Reservation: ");
            System.out.println("*-----------------*------------*-----------------*------------------*------------------*");
            System.out.println("| Reservation ID  |    Guest   |  Contact Number  |  Room Number     | Reservation Date |");
            System.out.println("*-----------------*------------*-----------------*------------------*------------------*");

            while (resultSet.next()) {
                int reservationId = resultSet.getInt("id");
                String guestName = resultSet.getString("name");
                String contactNumber = resultSet.getString("number");
                int roomNumber = resultSet.getInt("r_number");
                // Assuming the date is of type DATE or TIMESTAMP in your database
                String reservationDate = resultSet.getDate("date").toString();

                // Corrected format specifier for contact number
                System.out.printf("| %-14d | %-10s | %-15s | %-16d | %-18s |\n",
                        reservationId, guestName, contactNumber, roomNumber, reservationDate);
            }

            System.out.println("*-----------------*------------*-----------------*------------------*------------------*");

        }
    }
}

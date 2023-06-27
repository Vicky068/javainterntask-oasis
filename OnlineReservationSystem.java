import javax.swing.JOptionPane;

public class OnlineReservationSystem {
    private static String[][] reservations = new String[100][5];
    private static int reservationCount = 0;
    
    public static void main(String[] args) {
        loginForm();
    }
    
    public static void loginForm() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:");
        String password = JOptionPane.showInputDialog(null, "Enter your password:");
        
        // Validate login credentials (dummy validation)
        if (username.equals("admin") && password.equals("admin")) {
            reservationSystem();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid login credentials. Please try again.");
            loginForm();
        }
    }
    
    public static void reservationSystem() {
        String name = JOptionPane.showInputDialog(null, "Enter your name:");
        String trainNumber = JOptionPane.showInputDialog(null, "Enter train number:");
        String classType = JOptionPane.showInputDialog(null, "Enter class type:");
        String dateOfJourney = JOptionPane.showInputDialog(null, "Enter date of journey:");
        String destination = JOptionPane.showInputDialog(null, "Enter destination:");
        
        // Generate a unique PNR number (dummy generation)
        String pnrNumber = "112245" + (reservationCount + 1);
        
        // Save reservation details
        reservations[reservationCount][0] = pnrNumber;
        reservations[reservationCount][1] = name;
        reservations[reservationCount][2] = trainNumber;
        reservations[reservationCount][3] = classType;
        reservations[reservationCount][4] = dateOfJourney;
        reservationCount++;
        
        JOptionPane.showMessageDialog(null, "Reservation successful! Your PNR number is: " + pnrNumber);
        
        int option = JOptionPane.showConfirmDialog(null, "Do you want to make another reservation?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            reservationSystem();
        } else {
            cancellationForm();
        }
    }
    
    public static void cancellationForm() {
        String pnrNumber = JOptionPane.showInputDialog(null, "Enter your PNR number:");
        
        // Find the reservation based on the PNR number
        int reservationIndex = -1;
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i][0].equals(pnrNumber)) {
                reservationIndex = i;
                break;
            }
        }
        
        if (reservationIndex != -1) {
            String reservationDetails = "PNR Number: " + reservations[reservationIndex][0] + "\n"
                    + "Name: " + reservations[reservationIndex][1] + "\n"
                    + "Train Number: " + reservations[reservationIndex][2] + "\n"
                    + "Class Type: " + reservations[reservationIndex][3] + "\n"
                    + "Date of Journey: " + reservations[reservationIndex][4];
            
            int option = JOptionPane.showConfirmDialog(null, reservationDetails + "\n\nAre you sure you want to cancel?", "Cancellation Confirmation", JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.YES_OPTION) {
                // Remove the reservation
                for (int j = reservationIndex; j < reservationCount - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservationCount--;
                
                JOptionPane.showMessageDialog(null, "Cancellation successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Cancellation canceled.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid PNR number. Please try again.");
            cancellationForm();
        }
    }
}

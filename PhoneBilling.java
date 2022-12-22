
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Kelvin Munene
J31s/15848/2015

 */
package phone.billing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class PhoneBilling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        String time1 = JOptionPane.showInputDialog(null, "The call starts at " + java.time.LocalTime.now());
        String time2 = JOptionPane.showInputDialog(null, "The call ended at ");
        String network = JOptionPane.showInputDialog(null, "Is the call being made to network A or other network?");
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date1 = simpleDateFormat.parse(time1);
        Date date2 = simpleDateFormat.parse(time2);
        long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());
        long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
        long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
        long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;
        long difference = ((differenceInHours * 60 * 60) + (differenceInMinutes * 60) + (differenceInSeconds));
        JOptionPane.showMessageDialog(null, "Difference is " + differenceInHours + " hours " + differenceInMinutes + " minutes " + differenceInSeconds + " seconds.");

        if ("other network".equals(network)) {
            double cost = (difference * 5) / 60;
            JOptionPane.showMessageDialog(null, "The call charges without tax is Kshs " + cost);
            if (difference > 120) {
                double cost1 = ((difference * 5 * 1.16) / 60);
                JOptionPane.showMessageDialog(null, "The final total call cost plus tax is Kshs " + cost1);
            }
            
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            if (dateFormat.parse(dateFormat.format(date1)).after(dateFormat.parse("06:00:00")) && dateFormat.parse(dateFormat.format(date1)).before(dateFormat.parse("18:00:00"))) {
                double expenditure = (difference * 4) / 60;
                JOptionPane.showMessageDialog(null, "The call charges without tax is Kshs " + expenditure);
                if (difference > 120) {
                    double cost2 = ((difference * 4 * 1.16) / 60);
                    JOptionPane.showMessageDialog(null, "The final total call cost plus tax is Kshs " + cost2);
                }
                
            } else {
                double expenditure1 = (difference * 3) / 60;
                JOptionPane.showMessageDialog(null, "The call charges without tax is Kshs " + expenditure1);
                if (difference > 120) {
                    double cost3 = ((difference * 3 * 1.16) / 60);
                    JOptionPane.showMessageDialog(null, "The final total call cost plus tax is Kshs " + cost3);
                }
            }
        }
    }
    // TODO code application logic here
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.omidashouri.helpers;

import com.sahandrc.calendar.PersianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author omid
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //returns array of all locales
//        Locale locales[] = SimpleDateFormat.getAvailableLocales();
            Locale locales[] =  Calendar.getAvailableLocales();;
        
        //iterate through each locale and print 
        // locale code, display name and country
        for (int i = 0; i < locales.length; i++) {

            System.out.printf("%10s - %s, %s \n", locales[i].toString(),
                    locales[i].getDisplayName(), locales[i].getDisplayCountry());

        }
        
        PersianCalendar pc= new PersianCalendar();
        

    }
}

package edu.wctc.advjava.ics.dateutilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isaac
 */
public class DateUtilitiesTest {
    
    public DateUtilitiesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of today method, of class DateUtilities.
     */
    @Test
    public void testToday() {
        DateUtilities instance = new DateUtilities();
        System.out.println(".today(): " + instance.today());
    }

    /**
     * Test of now method, of class DateUtilities.
     */
    @Test
    public void testNow() {
        DateUtilities instance = new DateUtilities();
        System.out.println(".now(): " + instance.now());
        assertTrue(instance.now().toString().contains("T"));
    }

    /**
     * Test of format method, of class DateUtilities.
     */
    @Test
    public void testFormat_LocalDate_String() {
        DateUtilities instance = new DateUtilities();
        System.out.println(".format() LocalDate: " + instance.format(instance.today(), "M-d-yy"));
    }

    /**
     * Test of format method, of class DateUtilities.
     */
    @Test
    public void testFormat_LocalDateTime_String() {
        DateUtilities instance = new DateUtilities();
        System.out.println(".format() LocalDateTime: " + instance.format(instance.now(), "M-dd-yyyy H:m"));
    }

    /**
     * Test of toLocalDate method, of class DateUtilities.
     */
    @Test
    public void testToLocalDate() {
        DateUtilities instance = new DateUtilities();
        System.out.println(".toLocalDate(): " + instance.toLocalDate("11-7-2017", "M-d-yyyy"));
    }

    /**
     * Test of toLocalDateTime method, of class DateUtilities.
     */
    @Test
    public void testToLocalDateTime() {
        DateUtilities instance = new DateUtilities();
        System.out.println(".toLocalDateTime(): " + instance.toLocalDateTime("11-7-2017 1:30", "MM-d-yyyy H:mm"));
    }

    /**
     * Test of findDuration method, of class DateUtilities.
     */
    @Test
    public void testFindDuration() {
        DateUtilities instance = new DateUtilities();
        System.out.println(".findDuration(): " + instance.findDuration(instance.now(), instance.now().plusMonths(1).plusDays(3)));
    }

    /**
     * Test of findHoursBetween method, of class DateUtilities.
     */
    @Test
    public void testFindHoursBetween() {
        DateUtilities instance = new DateUtilities();
        long result = instance.findHoursBetween(instance.now(), instance.now().plusHours(8));
        System.out.println(".findHoursBetween(): " + result);
        assertTrue(result == 8);
    }

    /**
     * Test of findDaysBetween method, of class DateUtilities.
     */
    @Test
    public void testFindDaysBetween() {
        DateUtilities instance = new DateUtilities();
        long result = instance.findDaysBetween(instance.now(), instance.now().plusDays(3));
        System.out.println(".findDaysBetween(): " + result);
        assertTrue(result == 3);
    }    
}
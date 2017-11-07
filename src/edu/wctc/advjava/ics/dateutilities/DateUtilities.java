package edu.wctc.advjava.ics.dateutilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.text.DateFormatter;

/**
 * This is a utility class containing different methods that utilize the newer
 * <b>Java 8</b> Date and Time API. These methods can be used as tools to do
 * various calculations with and general management of times and dates.
 * <p>
 * Revision History:
 * <ul>
 * <li>2017-11-02: Initial version of DateUtilities class</li>
 * <li>2017-11-07: Add JavaDoc comments</li>
 * </ul>
 * 
 * @author Isaac Stefanski, istefanski@my.wctc.edu
 * @version 1.00
 * @since 1.8
 */
public class DateUtilities {
    
    /**
     * @return current date with the default yyyy-mm-dd format.
     */
    public final LocalDate today(){
        return LocalDate.now();
    }
    
    /**
     * @return current date and time with the default yyyy-mm-ddThh:mm:ss format.
     */
    public final LocalDateTime now(){
        return LocalDateTime.now();
    }
    
    /**
     * Format a <code>LocalDate</code> according to the pattern passed in by
     * the user.
     *
     * @param date - a <code>LocalDate</code> object
     * @param pattern - a <code>String</code> object
     * @return a date formatted according to the date pattern passed in
     * @throws IllegalArgumentException if date or pattern is null
     */
    public final String format(LocalDate date, String pattern) throws IllegalArgumentException{
        if(date == null || pattern.isEmpty()){
            throw new IllegalArgumentException("Date and pattern cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(date);
    }
    
    /**
     * Format a <code>LocalDateTime</code> according to the pattern passed in
     * by the user.
     *
     * @param dateTime - a <code>LocalDateTime</code> object
     * @param pattern - a <code>String</code> object
     * @return a date formatted according to the date pattern passed in
     * @throws IllegalArgumentException if date or pattern is null
     */
    public final String format(LocalDateTime dateTime, String pattern) throws IllegalArgumentException{
        if(dateTime == null || pattern.isEmpty()){
            throw new IllegalArgumentException("Date and pattern cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(dateTime);
    }
    
    /**
     * Format a <code>LocalDate</code> from a <code>String</code> passed in by
     * the user.
     *
     * @param inputDate - a <code>LocalDate</code> object
     * @param pattern - a <code>String</code> object
     * @return a <code>LocalDate</code> formatted according to the date pattern
     * passed in by the user
     * @throws IllegalArgumentException if date string is null or does not
     * contain valid <code>LocalDate</code> content
     */
    public final LocalDate toLocalDate(String inputDate, String pattern) throws IllegalArgumentException{
        if(inputDate == null || inputDate.isEmpty() || inputDate.equals("-") || inputDate.equals(" ")){
            throw new IllegalArgumentException("Input date string is invalid");
        }
        LocalDate localDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern(pattern));
        return localDate;
    }
    
    /**
     * Format a <code>LocalDateTime</code> from a <code>String</code>.
     *
     * @param inputDateTime - a <code>LocalDate</code> object
     * @param pattern - a <code>String</code> object
     * @return a <code>LocalDateTime</code> formatted according to the pattern
     * passed in by the user
     * @throws IllegalArgumentException if date string is null or does not
     * contain valid <code>LocalDate</code> content
     */
    public final LocalDateTime toLocalDateTime(String inputDateTime, String pattern) throws IllegalArgumentException{
        if(inputDateTime == null || inputDateTime.isEmpty() || inputDateTime.equals("-")
                || inputDateTime.equals(" ") || !inputDateTime.contains(":")){
            throw new IllegalArgumentException("Input date and time string is invalid");
        }
        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTime, DateTimeFormatter.ofPattern(pattern));
        return localDateTime;
    }
    
    /**
     * Calculate a <code>Duration</code> between a start date and end date.
     * 
     * @param startDateTime - a <code>LocalDate</code> object
     * @param endDateTime - a <code>LocalDate</code> object
     * @return duration between start and end dates
     * @throws IllegalArgumentException if any date is null
     */
    public final Duration findDuration(LocalDateTime startDateTime, LocalDateTime endDateTime) throws IllegalArgumentException{
        if(startDateTime == null || endDateTime == null){
            throw new IllegalArgumentException("Start and end dates cannot be null");
        }
        Duration diff = Duration.between(startDateTime, endDateTime);
        return diff;
    }
    
    /**
     * Calculate the number of hours between two times.
     * 
     * @param startDateTime - a <code>LocalDateTime</code> object
     * @param endDateTime - a <code>LocalDateTime</code> object
     * @return a <code>long</code> with the value of the calculated duration in
     * hours between start and end times
     * @throws IllegalArgumentException if any <code>LocalDateTime</code>
     * instance passed in is null
     */
    public final long findHoursBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) throws IllegalArgumentException{
        if(startDateTime == null || endDateTime == null){
            throw new IllegalArgumentException("Start and end dates cannot be null");
        }
        Duration diff = Duration.between(startDateTime, endDateTime);
        long hours = diff.toHours();
        return hours;
    }
    
    /**
     * Calculate the number of days between two dates specified by the user.
     * 
     * @param startDateTime - a <code>LocalDate</code> object
     * @param endDateTime - a <code>LocalDate</code> object
     * @return duration in days between start and end dates
     * @throws IllegalArgumentException if any date is null
     */
    public final long findDaysBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) throws IllegalArgumentException{
        if(startDateTime == null || endDateTime == null){
            throw new IllegalArgumentException("Start and end dates cannot be null");
        }
        Duration diff = Duration.between(startDateTime, endDateTime);
        long days = diff.toDays();
        return days;
    }
}
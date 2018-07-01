package com.jackie.se.date;

import java.awt.print.PrinterAbortException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.*;
import java.util.Locale;

/**
 * The java.time package contains many classes that your programs can use to represent time and date. This is a very rich API. The key entry points for ISO-based dates are as follows:<br/>
 * The Instant class provides a machine view of the timeline.<br/>
 * The LocalDate, LocalTime, and LocalDateTime classes provide a human view of date and time without any reference to time zone.<br/>
 * The ZoneId, ZoneRules, and ZoneOffset classes describe time zones, time zone offsets, and time zone rules.<br/>
 * The ZonedDateTime class represents date and time with a time zone. The OffsetDateTime and OffsetTime classes represent date and time, or time, respectively. These classes take a time zone offset into account.<br/>
 * The Duration class measures an amount of time in seconds and nanoseconds.<br/>
 * The Period class measures an amount of time using years, months, and days.
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        format();
        parse();
        customFormat();
        dayOfWeekEnums();
        monthEnums();
        getNextMondayOnSpecificDate();
        yearMonthRelatedApi();
        monthDayRleatedApi();
        yearRleatedApi();
        dateTimeRelatedApi();
        zonedDateTimeExampleOfFlight();
        offsetDateTimeExample();
        instantRleatedApi();
        timeFieldsAndUnitRelateApi();
        predefinedTemporalAdjusters();
        customTemporalAdjuster();
        predefinedTemporalQuery();
        customTemporalQuery();
        durationAndPeriodRelateApi();
        calculateNextBirthday();
        clockRelatedApi();
    }

    private static void format() {
        System.out.println("--------format---------");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.format(DateTimeFormatter.ISO_TIME));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("--------format---------");
    }

    private static void parse() {
        System.out.println("--------parse---------");
        String dateStr = "2018-06-29";
        String timeStr = "20:01:12.367";
        String dateTimeStr = "2018-06-29T20:01:12.367";
        LocalDate date = LocalDate.parse(dateStr);
        LocalTime time = LocalTime.parse(timeStr);
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println("--------parse---------");
    }

    private static void customFormat() {
        System.out.println("--------customFormat---------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ss.SSS");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse("19890508T12:35:16.124", dateTimeFormatter);
        LocalDate date = LocalDate.parse("19890508", dateFormatter);
        LocalTime time = LocalTime.parse("12:23:14.189", timeFormatter);
        System.out.println(dateTime);
        System.out.println(date);
        System.out.println(time);
        System.out.println("--------customFormat---------");
    }

    private static void dayOfWeekEnums() {
        System.out.println("--------dayOfWeekEnums---------");
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY.plus(10);
        System.out.println(dayOfWeek);
        DayOfWeek dow = DayOfWeek.MONDAY;
        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
        System.out.println("today is:" + DayOfWeek.from(LocalDate.now()));
        System.out.println("--------dayOfWeekEnums---------");
    }

    private static void monthEnums() {
        System.out.println("--------monthEnums---------");
        System.out.println("this month is:" + Month.from(LocalDateTime.now()));
        System.out.println(Month.JANUARY.getValue());
        System.out.println(Month.JANUARY.maxLength());
        System.out.println(Month.JANUARY.length(Year.isLeap(LocalDate.now().getYear())));
        Month month = Month.AUGUST;
        Locale locale = Locale.getDefault();
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
        System.out.println("--------monthEnums---------");
    }

    private static void getNextMondayOnSpecificDate() {
        System.out.println("--------getNextMondayOnSpecificDate---------");
        LocalDate specificDate = LocalDate.of(1989, Month.MAY, 8);
        TemporalAdjuster adjuster = TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY);
        LocalDate nextMonday = specificDate.with(adjuster);
        System.out.println("the week of day of specific date:" + specificDate.getDayOfWeek());
        System.out.println(nextMonday);
        System.out.println("--------getNextMondayOnSpecificDate---------");
    }

    private static void yearMonthRelatedApi() {
        System.out.println("--------yearMonthRelatedApi---------");
        YearMonth date = YearMonth.now();
        System.out.printf("%s: %d%n", date, date.lengthOfMonth());

        YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

        YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());
        System.out.println("--------yearMonthRelatedApi---------");
    }

    private static void monthDayRleatedApi() {
        System.out.println("--------monthDayRleatedApi---------");
        MonthDay date = MonthDay.from(LocalDate.now());
        boolean validLeapYear = date.isValidYear(2011);
        System.out.printf("%s:%s%n", date, validLeapYear);
        System.out.println("--------monthDayRleatedApi---------");
    }

    private static void yearRleatedApi() {
        System.out.println("--------yearRleatedApi---------");
        LocalDate date = LocalDate.now();
        System.out.printf("today's year is:%s%n", Year.from(date).getValue());
        System.out.printf("%s is leap year:%s%n", date, Year.isLeap(date.getYear()));
        System.out.println("--------yearRleatedApi---------");
    }

    private static void dateTimeRelatedApi() {
        System.out.println("--------dateTimeRelatedApi---------");
        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n", LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n", LocalDateTime.now().minusMonths(6));
        System.out.println("--------dateTimeRelatedApi---------");
    }

    private static void zonedDateTimeExampleOfFlight() {
        System.out.println("--------zonedDateTimeExampleOfFlight---------");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
        LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        try {
            String out1 = departure.format(format);
            System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", departure);
            throw exc;
        }

// Flight is 10 hours and 50 minutes, or 650 minutes
        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
                .plusMinutes(650);

        try {
            String out2 = arrival.format(format);
            System.out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", arrival);
            throw exc;
        }

        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {

            System.out.printf("  (%s daylight saving time will be in effect.)%n",
                    arrivingZone);
        } else {
            System.out.printf("  (%s standard time will be in effect.)%n",
                    arrivingZone);
        }

        System.out.println("--------zonedDateTimeExampleOfFlight---------");
    }

    private static void offsetDateTimeExample() {
        System.out.println("--------offsetDateTimeExample---------");
        // Find the last Thursday in July 2013.
        LocalDateTime localDate = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        ZoneOffset offset = ZoneOffset.of("-08:00");

        OffsetDateTime offsetDate = OffsetDateTime.of(localDate, offset);
        OffsetDateTime lastThursday =
                offsetDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        System.out.printf("The last Thursday in July 2013 is the %sth.%n",
                lastThursday.getDayOfMonth());
        System.out.println("--------offsetDateTimeExample---------");
    }

    private static void instantRleatedApi() {
        System.out.println("--------instantRleatedApi---------");
        Instant now = Instant.now();
        System.out.println(now);
        long milliSecondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.MILLIS);
        System.out.println("seconds elapsed from epoch:" + milliSecondsFromEpoch);
        Instant timestamp = Instant.ofEpochMilli(1530424023513L);
        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                ldt.getYear(), ldt.getHour(), ldt.getMinute());
        System.out.println("--------instantRleatedApi---------");
    }

    private static void timeFieldsAndUnitRelateApi() {
        System.out.println("--------timeFieldsAndUnitRelateApi---------");
        LocalTime time = LocalTime.now();
        int mills = time.get(ChronoField.MILLI_OF_SECOND);
        System.out.println("millis of second:" + mills);
        LocalDate date = LocalDate.now();
        int qoy = date.get(IsoFields.QUARTER_OF_YEAR);
        System.out.println("quarter of year:" + qoy);
        Instant instant = Instant.now();
        boolean isSupported = instant.isSupported(ChronoUnit.YEARS);
        System.out.println("is instant support days chronoUnit:" + isSupported);
        System.out.println("--------timeFieldsAndUnitRelateApi---------");
    }

    private static void predefinedTemporalAdjusters() {
        System.out.println("--------predefinedTemporalAdjusters---------");
        LocalDate date = LocalDate.of(2000, Month.OCTOBER, 15);
        DayOfWeek dotw = date.getDayOfWeek();
        System.out.printf("%s is on a %s%n", date, dotw);

        System.out.printf("first day of Month: %s%n",
                date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.printf("first Monday of Month: %s%n",
                date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.printf("last day of Month: %s%n",
                date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.printf("first day of next Month: %s%n",
                date.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.printf("first day of next Year: %s%n",
                date.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.printf("first day of Year: %s%n",
                date.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("--------predefinedTemporalAdjusters---------");
    }

    private static void customTemporalAdjuster() {
        System.out.println("--------customTemporalAdjuster---------");
        LocalDate date = LocalDate.now();
        System.out.println("the next pay day is:" + date.with(new PayDayAdjuster()));
        System.out.println("--------customTemporalAdjuster---------");
    }

    private static void predefinedTemporalQuery() {
        System.out.println("--------predefinedTemporalQuery---------");
        TemporalQuery query = TemporalQueries.precision();
        System.out.printf("LocalDate precision is %s%n",
                LocalDate.now().query(query));
        System.out.printf("LocalDateTime precision is %s%n",
                LocalDateTime.now().query(query));
        System.out.printf("Year precision is %s%n",
                Year.now().query(query));
        System.out.printf("YearMonth precision is %s%n",
                YearMonth.now().query(query));
        System.out.printf("Instant precision is %s%n",
                Instant.now().query(query));
        System.out.println("--------predefinedTemporalQuery---------");
    }

    private static void customTemporalQuery() {
        System.out.println("--------customTemporalQuery---------");
        // Invoking the query without using a lambda expression.
        LocalDate date = LocalDate.of(1989, Month.APRIL, 4);
        Boolean isFamilyVacation = date.query(new FamilyVacations());

// Invoking the query using a lambda expression.
        Boolean isFamilyBirthday = date.query(FamilyBirthdays::isFamilyBirthday);

        if (isFamilyVacation || isFamilyBirthday) {
            System.out.printf("%s is an important date!%n", date);
        } else {
            System.out.printf("%s is not an important date.%n", date);
        }
        System.out.println("--------customTemporalQuery---------");
    }

    private static void durationAndPeriodRelateApi() {
        System.out.println("--------durationAndPeriodRelateApi---------");
        Instant t1, t2;
        t1 = Instant.now();
        t2 = Instant.now();
        long ns = Duration.between(t1, t2).toNanos();
        System.out.println("nanos between two instance:" + ns);
        Instant start = Instant.now();
        Duration gap = Duration.ofSeconds(10);
        Instant later = start.plus(gap);
        System.out.println("add ten seconds to start instant is:" + later);
        Instant previous = Instant.ofEpochMilli(1000L), current;
        current = Instant.now();
        if (previous != null) {
            System.out.println("day gap between previous instant is:" + ChronoUnit.DAYS.between(previous, current));
        }
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990, Month.JULY, 10);

        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + p2 + " days total)");
        System.out.println("--------durationAndPeriodRelateApi---------");
    }

    private static void calculateNextBirthday() {
        System.out.println("--------durationAndPeriodRelateApi---------");

        LocalDate birthday = LocalDate.of(1989, Month.MAY, 8);
        LocalDate today = LocalDate.now();
        LocalDate nextBDay = birthday.withYear(today.getYear());

//If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and " +
                p.getDays() + " days until your next birthday. (" +
                p2 + " days total)");
        System.out.println("--------durationAndPeriodRelateApi---------");
    }

    private static void clockRelatedApi() {
        System.out.println("--------clockRelatedApi---------");
        Clock clock = Clock.fixed(Instant.ofEpochMilli(0L), ZoneId.of("UTC"));
        LocalDate today = LocalDate.now(clock);
        System.out.println("use fixed clock:" + today);
        System.out.println("--------clockRelatedApi---------");
    }

    private static class PayDayAdjuster implements TemporalAdjuster {

        /**
         * The adjustInto method accepts a Temporal instance
         * and returns an adjusted LocalDate. If the passed in
         * parameter is not a LocalDate, then a DateTimeException is thrown.
         */
        @Override
        public Temporal adjustInto(Temporal input) {
            LocalDate date = LocalDate.from(input);
            int day;
            if (date.getDayOfMonth() < 15) {
                day = 15;
            } else {
                day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
            }
            date = date.withDayOfMonth(day);
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            }

            return input.with(date);
        }
    }

    private static class FamilyVacations implements TemporalQuery<Boolean> {

        // Returns true if the passed-in date occurs during one of the
        // family vacations. Because the query compares the month and day only,
        // the check succeeds even if the Temporal types are not the same.
        public Boolean queryFrom(TemporalAccessor date) {
            int month = date.get(ChronoField.MONTH_OF_YEAR);
            int day = date.get(ChronoField.DAY_OF_MONTH);

            // Disneyland over Spring Break
            if ((month == Month.APRIL.getValue()) && ((day >= 3) && (day <= 8)))
                return Boolean.TRUE;

            // Smith family reunion on Lake Saugatuck
            if ((month == Month.AUGUST.getValue()) && ((day >= 8) && (day <= 14)))
                return Boolean.TRUE;

            return Boolean.FALSE;
        }
    }

    private static class FamilyBirthdays {
        // Returns true if the passed-in date is the same as one of the
        // family birthdays. Because the query compares the month and day only,
        // the check succeeds even if the Temporal types are not the same.


        public static Boolean isFamilyBirthday(TemporalAccessor date) {
            int month = date.get(ChronoField.MONTH_OF_YEAR);
            int day = date.get(ChronoField.DAY_OF_MONTH);
// Angie's birthday is on April 3.
            if ((month == Month.APRIL.getValue()) && (day == 3))
                return Boolean.TRUE;
// Sue's birthday is on June 18.
            if ((month == Month.JUNE.getValue()) && (day == 18))
                return Boolean.TRUE;
// Joe's birthday is on May 29.
            if ((month == Month.MAY.getValue()) && (day == 29))
                return Boolean.TRUE;
            return Boolean.FALSE;
        }
    }
}

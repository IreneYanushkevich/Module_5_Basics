package by.epam.yanushkevich_irina.module5.task_3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyCalendar {
    private List<Holiday> holidays;
    private int year;

    public MyCalendar(int year) {
        holidays = new ArrayList<>();
        this.year = year;
    }

    public void addHoliday(LocalDate holiday, String name) {
        holidays.add(new Holiday(holiday, name));
        holidays.sort(Comparator.comparing(Holiday::getDate));
    }

    public void deleteHoliday(LocalDate day, String event) {
        Holiday h = new Holiday(day, event);
        if (checkIfHoliday(day)) {
            holidays.remove(h);
        }
    }

    public void addWeekend(int year, MyCalendar calendar) {
        LocalDate firstDay = LocalDate.of(year, 1, 1);
        LocalDate lastDay = LocalDate.of(year, 12, 31);
        while (firstDay.isBefore(lastDay)) {
            if (firstDay.getDayOfWeek() == DayOfWeek.SATURDAY && !checkIfHoliday(firstDay)) {
                calendar.addHoliday(firstDay, "Saturday");
            }
            if (firstDay.getDayOfWeek() == DayOfWeek.SUNDAY && !checkIfHoliday(firstDay)) {
                calendar.addHoliday(firstDay, "Sunday");
            }
            firstDay = firstDay.plusDays(1);
        }
    }

    private void addWorkingDay(MyCalendar calendar) {
        LocalDate firstDay = LocalDate.of(year, 1, 1);
        for (LocalDate d = firstDay; calendar.getYear() == d.getYear(); d = d.plusDays(1)) {
            if (!calendar.checkIfHoliday(d)) {
                calendar.addHoliday(d, "Working day");
                holidays.sort(Comparator.comparing(Holiday::getDate));
            }
        }
    }

    private boolean checkIfHoliday(LocalDate date) {
        boolean result = false;
        for (Holiday day : holidays) {
            if (date.compareTo(day.getDate()) == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void findDayFromMyCalendar(LocalDate date) {
        Holiday result = new Holiday(date, "");
        for (Holiday day : holidays) {
            if (date.compareTo(day.getDate()) == 0) {
                result = day;
            }
        }
        checkEvent(result);
    }

    private void checkEvent(Holiday date) {
        String result = "Common workday";
        if (holidays.contains(date)) {
            result = date.getEvent();
        }
        System.out.println("\n" + date.getDate() + " --> " + result);
    }

    public void printCalendar(MyCalendar calendar) {
        calendar.addWorkingDay(calendar);
        System.out.println(calendar);
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCalendar that = (MyCalendar) o;
        if (holidays == null) {
            if (that.holidays != null) {
                return false;
            }
        } else if (!holidays.equals(that.holidays)) {
            return false;
        }
        return year == that.year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((holidays == null) ? 0 : holidays.hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "\nMy calendar of the year " + year + ":" + holidays;
    }


    public class Holiday {

        private LocalDate date;
        private String event;

        public Holiday(LocalDate date, String event) {
            this.date = date;
            this.event = event;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Holiday holiday = (Holiday) o;
            if (date == null) {
                if (holiday.date != null) {
                    return false;
                }
            } else if (!date.equals(holiday.date)) {
                return false;
            }
            if (event == null) {
                return holiday.event == null;
            } else return event.equals(holiday.event);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((date == null) ? 0 : date.hashCode());
            result = prime * result + ((event == null) ? 0 : event.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return "\n" + date + " --> " + event;
        }
    }
}

package by.epam.yanushkevich_irina.module5.task_3;

import java.time.LocalDate;

public class Main {

    /* Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
       выходных и праздничных днях. */

    public static void main(String[] args) {

        int year = 2022;

        MyCalendar myCalendar = new MyCalendar(year);

        myCalendar.addHoliday(LocalDate.of(year, 1, 1), "New Year");
        myCalendar.addHoliday(LocalDate.of(year, 1, 7), "Orthodox Christmas");
        myCalendar.addHoliday(LocalDate.of(year, 3, 8), "Women’s Day");
        myCalendar.addHoliday(LocalDate.of(year, 5, 1), "Labour Day");
        myCalendar.addHoliday(LocalDate.of(year, 5, 9), "Victory Day");
        myCalendar.addHoliday(LocalDate.of(year, 7, 3), "Independence Day");
        myCalendar.addHoliday(LocalDate.of(year, 11, 7), "October Revolution Day");
        myCalendar.addHoliday(LocalDate.of(year, 12, 25), "Catholic Christmas");

        myCalendar.addWeekend(year, myCalendar);
        myCalendar.findDayFromMyCalendar(LocalDate.of(2022, 2, 1));
        myCalendar.deleteHoliday(LocalDate.of(year, 12, 24), "Saturday");

        myCalendar.printCalendar(myCalendar);
    }
}

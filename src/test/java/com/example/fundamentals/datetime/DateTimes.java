package com.example.fundamentals.datetime;

import java.time.*;
import java.time.temporal.TemporalUnit;

/**
 * java.time パッケージの実験用
 */
public class DateTimes {
    //TODO instant を生成してから、他の日時を取得するのが正しい？
    //TOTO epoch time との period, duration 初期化に使う？

    Clock clock = Clock.systemDefaultZone();
    ZoneId zone = clock.getZone();

    LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
    ZonedDateTime zonedDateTime = localDateTime.atZone(zone);
    OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

    Instant instant = zonedDateTime.toInstant();

    LocalDateTime tomorrow = localDateTime.plusDays(1L);
    Period period = Period.between(localDateTime.toLocalDate(), tomorrow.toLocalDate());
    Duration duration = Duration.between(localDateTime,tomorrow);

    LocalTime localTime = LocalTime.from(localDateTime);

    @Override
    public String toString() {
        return "DateTimes{" +
                 "\nlocalDateTime =" + localDateTime +
                ",\nzonedDateTime =" + zonedDateTime +
                ",\noffsetDateTime=" + offsetDateTime +
                ",\ninstant       =" + instant +
                ",\nlocaltime=" + localTime +
                ",\nperiod  =" + period +
                ",\nduration=" + duration +
                "\n}";
    }
}

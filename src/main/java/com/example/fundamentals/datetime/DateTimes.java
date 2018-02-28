package com.example.fundamentals.datetime;

import java.time.*;
import java.time.temporal.TemporalUnit;

public class DateTimes {
    //TODO instant を生成してから、他の日時を取得するのが正しい？
    //TOTO epoch time との period, duration 初期化に使う？
    LocalDateTime localDateTime = LocalDateTime.now();
    OffsetDateTime offsetDateTime = OffsetDateTime.from(localDateTime);
    ZonedDateTime zonedDateTime = ZonedDateTime.from(localDateTime);
    Instant instant = Instant.now();

    LocalDateTime tomorrow = localDateTime.plusDays(1L);
    Period period = Period.between(localDateTime.toLocalDate(), tomorrow.toLocalDate());
    Duration duration = Duration.between(localDateTime,tomorrow);

    LocalTime localTime = LocalTime.from(localDateTime);

    @Override
    public String toString() {
        return "DateTimes{" +
                 "\nlocalDateTime =" + localDateTime +
                ",\noffsetDateTime=" + offsetDateTime +
                ",\nzonedDateTime =" + zonedDateTime +
                ",\ninstant       =" + instant +
                ",\nlocaltime=" + localTime +
                ",\nperiod  =" + period +
                ",\nduration=" + duration +
                '}';
    }
}

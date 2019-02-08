package ru.kingsbot;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateTimeTest {

    private final SimpleDateFormat formatter = new SimpleDateFormat("mm мин ss сек");

    @Test
    public void dateTimeOutputTest() {
        long second = Instant.now().plusSeconds(60 * 15).getEpochSecond();

        long currentTime = Instant.now().getEpochSecond();
        String formatDate = formatter.format(new Date((second - currentTime) * 1000));
        Assert.assertEquals("15 мин 00 сек", formatDate);

        currentTime = Instant.now().plusSeconds(60).getEpochSecond();
        formatDate = formatter.format(new Date((second - currentTime) * 1000));
        Assert.assertEquals("14 мин 00 сек", formatDate);
    }

}

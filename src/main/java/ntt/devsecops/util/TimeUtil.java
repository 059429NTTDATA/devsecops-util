package ntt.devsecops.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeUtil {

	public static Timestamp getTimeStampFromMilisec(Long timeMillis) {
		return new Timestamp(timeMillis);
	}

	public static Timestamp getTimeStampFromMilisecTimeZero(Long timeMillis) {
		Date date = new Date(timeMillis);
		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime lastTimeOfDay = dateTime.with(LocalTime.MIN);
		return Timestamp.valueOf(lastTimeOfDay);
	}

	public static Timestamp getTimeStampFromMilisecLastTime(Long timeMillis) {
		Date date = new Date(timeMillis);
		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime lastTimeOfDay = dateTime.with(LocalTime.MAX);
		return Timestamp.valueOf(lastTimeOfDay);
	}

	public static Timestamp getCurrentTimeStamp() {
		return Timestamp.valueOf(LocalDateTime.now());
	}

	public static Timestamp getCurrentTimeStampTimeZero() {
		return Timestamp.valueOf(LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIN));
	}

	public static Timestamp getCurrentTimeStampLastTime() {
		return Timestamp.valueOf(LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MAX));
	}

	public static Timestamp getCurrentTimeStampTimeZeroFromLocalDateWithMinusDate(int nDays) {
		LocalDate ldate = LocalDateTime.now().toLocalDate();
		return Timestamp.valueOf(LocalDateTime.of(minusDate(ldate, nDays), LocalTime.MIN));
	}

	public static Timestamp getCurrentTimeStampLastTimeFromLocalDateWithMinusDate(int nDays) {
		LocalDate ldate = LocalDateTime.now().toLocalDate();
		return Timestamp.valueOf(LocalDateTime.of(minusDate(ldate, nDays), LocalTime.MAX));
	}

	public static LocalDate minusDate(LocalDate ldate, int nDays) {
		return ldate.minusDays((long) nDays);
	}

	public static String getCurrentDateStr(String formatStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		Date date = new Date();
		return formatter.format(date);
	}

	public static String getDateStrFormat(Date date, String formatStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		return formatter.format(date);
	}
}

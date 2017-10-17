package com.mitsubishi.demo.common.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * 日付処理ユーティリティ
 *
 * @author ZhangX
 *
 */
public class DateUtil {

    // 日付フォーマット YYYYMMDDHH24MISS
    public static final String DATE_PATTERN_ALL = "yyyyMMddHHmmss";
    // 日付フォーマット YYYY/MM/DD HH24:MI
    public static final String DATE_PATTERN_ALL_SEC = "yyyy/MM/dd HH:mm";
    // 日付フォーマット YYYY/MM/DD HH24:MI:SS
    public static final String DATE_PATTERN_ALL_MOL = "yyyy/MM/dd HH:mm:ss";
    // 日付フォーマット YYYYMMDD
    public static final String DATE_PATTERN_DATE = "yyyyMMdd";
    // 日付フォーマット YYYYMMDD
    public static final String DATE_CREATE_DATE = "yy-MM-dd";
    // 日付フォーマット YYYY/MM/DD
    public static final String DATE_PATTERN_DATE_MOL = "yyyy/MM/dd";
    // 日付フォーマット HH24MISS
    public static final String DATE_PATTERN_TIME = "HHmmss";
    // 日付フォーマット HH24:MI:SS
    public static final String DATE_PATTERN_TIME_MOL = "HH:mm:ss";
    // 日付フォーマット YYYYMM
    public static final String DATE_PATTERN_YEAR_MONTH = "yyyyMM";
    // 日付フォーマット YYYY/MM *
    public static final String DATE_PATTERN_YEAR_MONTH_MOL = "yyyy/MM";
    // 日付フォーマット YYYYMMDDHH24MISSSSS
    public static final String DATE_PATTERN_MS = "yyyyMMddHHmmssSSS";
    // 日付フォーマット MMM(Apr,May,Jun,…)
    public static final String DATE_PATTERN_MONTH = "MMM";

    // 24時間
    private static final int HOUR_24 = 24;

    // 60分
    private static final int MINUTES_60 = 60;

    // 60秒
    private static final int SECOND_60 = 60;

    // 1000ミリ秒
    private static final int MSEC_1000 = 1000;

    /**
     * Date型のオブジェクトをString型に変換する.
     *
     * @param date
     *            変換対象のDate
     * @param datePattern
     *            変換後の日付フォーマット
     * @return 変換後の日付文字列
     */
    public static String convertDateToString(Date date, String datePattern) {
	return (new SimpleDateFormat(datePattern)).format(date);
    }

    /**
     * String型のオブジェクトをDate型に変換する.
     *
     * @param source
     *            文字列型日時
     * @param datePattern
     *            日付フォーマット
     * @return 変換後のDate
     * @throws ParseException
     *             指定された日付フォーマットへの変換に失敗した場合にスローされる
     */
    public static Date convertStringToDate(String source, String datePattern) throws ParseException {

	// Modified by ZhangX on 20151102 for 日付変換不備修正 Begin
	// return (new SimpleDateFormat(datePattern)).parse(source);
	try {
	    LocalDate ｌｄ = LocalDate.parse(source, DateTimeFormatter.ofPattern(datePattern));
	    Instant ins = ｌｄ.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
	    return Date.from(ins);
	} catch (DateTimeParseException e) {
	    throw new ParseException(e.getMessage(), 0);
	}
	// Modified by ZhangX on 20151102 for 日付変換不備修正 End
    }

    /**
     * システム日付を取得する(yyyymmdd)
     *
     * @return date システム日付
     */
    public static Date getSysDate() {

	// カレンダー取得
	Calendar cal = Calendar.getInstance();
	Date date = new Date();
	cal.setTime(date);
	return cal.getTime();
    }

    /**
     * システム日付を取得する(yyyymmdd)
     *
     * @return date
     */
    public static String getSysDateString() {

	// カレンダー取得
	Calendar cal = Calendar.getInstance();
	Date date = new Date();
	cal.setTime(date);

	// 年月日を取得
	int yy = cal.get(Calendar.YEAR);
	int mm = cal.get(Calendar.MONTH) + 1;
	int dd = cal.get(Calendar.DATE);

	String sysDate = "";

	// 文字列フォーマットを成形
	sysDate = new DecimalFormat("0000").format(yy) + new DecimalFormat("00").format(mm)
		+ new DecimalFormat("00").format(dd);

	return sysDate;

    }

    /**
     * システム日付を取得する
     *
     * @param format
     *            フォーマット（DateUtilの定数）
     * @return システム日付
     */
    public static String getSysDateString(String format) {

	SimpleDateFormat sdf = new SimpleDateFormat(format);
	return sdf.format(getSysDate());
    }

    /**
     * Date加算/減算
     *
     * @param date
     *            加算対象Date
     * @param kind
     *            加算種類（Calender定数を設定 ex.Calender.DATE）
     * @param addValue
     *            加算する数値
     * @return 加算・減算したDate
     */
    public static Date addTime(Date date, int kind, int addValue) {

	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	cal.add(kind, addValue);
	return cal.getTime();
    }

    /**
     * 日付表現文字列の加算/減算
     *
     * @param dateString
     *            加算対象日付表現文字列
     * @param format
     *            日付表現のフォーマット(DateUtil定数)
     * @param kind
     *            加算種類（Calender定数を設定 ex.Calender.DATE）
     * @param addValue
     *            加算する数値
     * @throws ParseException
     *             指定された日付フォーマットへの変換に失敗した場合にスローされる
     * @return 加算・減算した日付表現文字列
     */
    public static String addTimeString(String dateString, String format, int kind, int addValue) throws ParseException {

	Date date = convertStringToDate(dateString, format);

	date = addTime(date, kind, addValue);

	return convertDateToString(date, format);
    }

    /**
     * 指定期間内の日数取得処理
     *
     * @param fromDate
     *            開始日付
     * @param toDate
     *            終了日付
     * @return 日数
     */
    public static Long getDifferenceDate(Date fromDate, Date toDate) {

	long dateTimeFrom = fromDate.getTime();
	long dateTimeTo = toDate.getTime();

	return (dateTimeTo - dateTimeFrom) / (HOUR_24 * MINUTES_60 * SECOND_60 * MSEC_1000);

    }

    /**
     * String型の日付をMMM形式(Apr,May,Jun,...)に変換する
     *
     * @param source
     *            文字列型日時
     * @param datePattern
     *            日付フォーマット
     * @throws ParseException
     */
    public static String convertMonthToEn(String source, String datePattern) throws ParseException {
	return convertMonthToEn(DateUtil.convertStringToDate(source, datePattern));
    }

    /**
     * Date型の日付をMMM形式(Apr,May,Jun,...)に変換する
     *
     * @param date
     *            変換対象のDate
     */
    public static String convertMonthToEn(Date date) {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	return String.format(Locale.ENGLISH, "%1$tb", calendar);
    }

}
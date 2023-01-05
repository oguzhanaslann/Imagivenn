package com.univerlist.common

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {


    const val DAY_MONTH_WITH_NAME_YEAR_FORMAT = "dd MMMM yyyy"
    const val DAY_MONTH_YEAR_FORMAT_DOT_SEPARATED = "dd.MM.yyyy"
    const val BIRTH_DATE_FORMAT = "dd/MM/yyyy"
    const val DAY_YEAR_FORMAT = "dd/yyyy"

    private fun getDateFormatter(format: String) = SimpleDateFormat(format)

    private fun getDateFormatter(format: String, locale: Locale) = SimpleDateFormat(format, locale)

    @kotlin.jvm.Throws(ParseException::class)
    fun parse(dateString: String, format: String): Date? {
        return getDateFormatter(format).parse(dateString)
    }

    // localised parse
    @kotlin.jvm.Throws(ParseException::class)
    fun parse(dateString: String, format: String, locale: Locale): Date? {
        return getDateFormatter(format, locale).parse(dateString)
    }

    // auto localised parse
    @kotlin.jvm.Throws(ParseException::class)
    fun parse(dateString: String, format: String, autoLocale: Boolean): Date? {
        return if (autoLocale) {
            parse(dateString, format, Locale.getDefault())
        } else {
            parse(dateString, format)
        }
    }

    fun format(date: Date, format: String): String {
        return getDateFormatter(format).format(date)
    }

    // localised format
    fun format(date: Date, format: String, locale: Locale): String {
        return getDateFormatter(format, locale).format(date)
    }

    // auto localised format
    fun format(date: Date, format: String, autoLocale: Boolean): String {
        return if (autoLocale) {
            format(date, format, Locale.getDefault())
        } else {
            format(date, format)
        }
    }

    fun tryFormat(date: Date?, format: String): String {
        return try {
            date?.let { format(it, format) } ?: ""
        } catch (e: ParseException) {
            ""
        }
    }

    // localised tryFormat
    fun tryFormat(date: Date?, format: String, locale: Locale): String {
        return try {
            date?.let { format(it, format, locale) } ?: ""
        } catch (e: ParseException) {
            ""
        }
    }

    // auto localised tryFormat
    fun tryFormat(date: Date?, format: String, autoLocale: Boolean): String {
        return try {
            date?.let { format(it, format, autoLocale) } ?: ""
        } catch (e: ParseException) {
            ""
        }
    }
}

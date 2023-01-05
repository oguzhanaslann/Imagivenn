package com.univerlist.common.currency

import java.math.BigDecimal
import java.text.NumberFormat
import java.text.ParseException
import kotlin.math.max

typealias BuiltInCurrency = java.util.Currency

data class Currency(
    val currencyCode: CurrencyCode,
    val amount: Double,
) {
    operator fun plus(other: Currency): Currency {
        return Currency(currencyCode, amount + other.amount)
    }

    operator fun minus(other: Currency): Currency {
        return Currency(currencyCode, amount - other.amount)
    }

    fun orZero(): Currency {
        return Currency(currencyCode, max(amount, 0.0))
    }
}

data class CurrencyBigDecimal(
    val currencyCode: CurrencyCode,
    val amount: BigDecimal,
) {
    operator fun plus(other: CurrencyBigDecimal): CurrencyBigDecimal {
        return CurrencyBigDecimal(currencyCode, amount + other.amount)
    }

    operator fun minus(other: CurrencyBigDecimal): CurrencyBigDecimal {
        return CurrencyBigDecimal(currencyCode, amount - other.amount)
    }

    fun orZero(): CurrencyBigDecimal {
        return CurrencyBigDecimal(currencyCode, amount.max(BigDecimal.ZERO))
    }

    companion object {
        fun zero(currencyCode: CurrencyCode): CurrencyBigDecimal {
            return CurrencyBigDecimal(currencyCode, BigDecimal.ZERO)
        }
    }
}


fun Currency.formatCurrency(): String {
    return formatCurrency(amount, currencyCode)
}

fun Currency.parseCurrencyOrZero(): Double? {
    return parseCurrencyOrZero(formatCurrency(), currencyCode.code)
}

fun Currency.parseCurrency(): Double? {
    return parseCurrency(formatCurrency(), currencyCode.code)
}

fun Currency.getCurrencySymbol(): String? {
    return getCurrencySymbol(currencyCode.code)
}

fun formatCurrency(amount: Double, currencyCode: String): String {
    val formatter = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = 0
    formatter.currency = BuiltInCurrency.getInstance(currencyCode)
    var formattedAmount = formatter.format(amount)
    return formattedAmount
}

@kotlin.jvm.Throws(ParseException::class)
fun parseCurrency(amount: String, currencyCode: String): Double? {
    val formatter = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = 0
    formatter.currency = BuiltInCurrency.getInstance(currencyCode)
    val parsedAmount = formatter.parse(amount)
    return parsedAmount?.toDouble()
}

fun getCurrencySymbol(currencyCode: String): String? {
    val formatter = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = 0
    formatter.currency = BuiltInCurrency.getInstance(currencyCode)
    return formatter.currency?.symbol
}

fun parseCurrencyOrZero(amount: String, currencyCode: String): Double? {
    return try {
        parseCurrency(amount, currencyCode)
    } catch (e: ParseException) {
        0.0
    }
}

private fun replaceTRYSymbolIfMatches(
    currencyCode: String,
    formattedAmount: String
): String {
    var formattedAmount1 = formattedAmount
    if (currencyCode == CurrencyCode.TRY.code && formattedAmount1.contains(CurrencyCode.TRY.code)) {
        formattedAmount1 = formattedAmount1.replace(CurrencyCode.TRY.code, "₺")
    }
    return formattedAmount1
}

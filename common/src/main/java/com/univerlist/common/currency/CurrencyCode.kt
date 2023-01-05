package com.univerlist.common.currency

enum class CurrencyCode(val code: String) {
    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),

    // turkey
    TRY("TRY"),

    // australia
    AUD("AUD"),

    // russia
    RUB("RUB"),

    // china
    CNY("CNY"),

    // japan
    JPY("JPY"),

    // canada
    CAD("CAD"),

    // india
    INR("INR"),

    // brazil
    BRL("BRL"),

    // mexico
    MXN("MXN"),
}

fun formatCurrency(amount: Double, currencyCode: CurrencyCode): String {
    return formatCurrency(amount, currencyCode.code)
}

val CurrencyCode.symbol: String
    get() = getCurrencySymbol(code) ?: ""

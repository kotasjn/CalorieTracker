package com.plcoding.core.domain.usecase

class FilterOutDigits {
    operator fun invoke(text: String) = text.filter { it.isDigit() }
}

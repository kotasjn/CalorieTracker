package com.plcoding.tracker.presentation.overview.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.plcoding.tracker.presentation.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun LocalDate.parseDateText(): String {
    val today = LocalDate.now()
    return when (this) {
        today -> stringResource(id = R.string.today)
        today.minusDays(1) -> stringResource(id = R.string.yesterday)
        today.plusDays(1) -> stringResource(id = R.string.tomorrow)
        else -> DateTimeFormatter.ofPattern("dd LLLL").format(this)
    }
}

package com.plcoding.tracker.presentation.overview

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.core.util.UIEvent
import com.plcoding.coreui.LocalSpacing
import com.plcoding.tracker.presentation.overview.components.DaySelector
import com.plcoding.tracker.presentation.overview.components.ExpandableMeal
import com.plcoding.tracker.presentation.overview.components.NutrientsHeader

@Composable
fun TrackerOverviewScreen(
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel(),
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium),
    ) {
        item {
            NutrientsHeader(state = state)
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            DaySelector(
                date = state.date,
                onPreviousDayClick = { viewModel.onEvent(TrackerOverviewEvent.OnPreviousDayClick) },
                onNextDayClick = { viewModel.onEvent(TrackerOverviewEvent.OnNextDayClick) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium),
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
        items(state.meals) {
            ExpandableMeal(
                meal = it,
                onToggleClick = { viewModel.onEvent(TrackerOverviewEvent.OnToggleMealClick(it)) },
                content = {
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

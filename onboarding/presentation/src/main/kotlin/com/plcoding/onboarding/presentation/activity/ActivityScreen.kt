package com.plcoding.onboarding.presentation.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.plcoding.core.R
import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.util.UIEvent
import com.plcoding.coreui.LocalSpacing
import com.plcoding.coreui.PreviewSurface
import com.plcoding.coreui.ScreenPreview
import com.plcoding.onboarding.presentation.components.ActionButton
import com.plcoding.onboarding.presentation.components.SelectableButton

@Composable
fun ActivityScreen(
    onNextClick: () -> Unit,
    viewModel: ActivityViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Success -> onNextClick()
                else -> Unit
            }
        }
    }

    ActivityScreenContent(
        activityLevel = viewModel.selectedActivityLevel,
        onGenderClick = {
            viewModel.onGenderClick(it)
        },
        onNextClick = {
            onNextClick.invoke()
        },
    )
}

@Composable
fun ActivityScreenContent(
    activityLevel: ActivityLevel,
    onGenderClick: (ActivityLevel) -> Unit,
    onNextClick: () -> Unit,
) {
    val spacing = LocalSpacing.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_activity_level),
                style = MaterialTheme.typography.h3,
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.low),
                    isSelected = activityLevel is ActivityLevel.Low,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { onGenderClick(ActivityLevel.Low) },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.medium),
                    isSelected = activityLevel is ActivityLevel.Medium,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { onGenderClick(ActivityLevel.Medium) },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.high),
                    isSelected = activityLevel is ActivityLevel.High,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { onGenderClick(ActivityLevel.High) },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = onNextClick,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}

@Composable
@ScreenPreview
@ShowkaseComposable(name = "ActivityScreen", group = "Screens")
fun ActivityScreenPreview() {
    PreviewSurface {
        Column {
            ActivityScreenContent(
                activityLevel = ActivityLevel.Medium,
                onGenderClick = {},
                onNextClick = {},
            )
            ActivityScreenContent(
                activityLevel = ActivityLevel.Medium,
                onGenderClick = {},
                onNextClick = {},
            )
            ActivityScreenContent(
                activityLevel = ActivityLevel.Medium,
                onGenderClick = {},
                onNextClick = {},
            )
        }
    }
}

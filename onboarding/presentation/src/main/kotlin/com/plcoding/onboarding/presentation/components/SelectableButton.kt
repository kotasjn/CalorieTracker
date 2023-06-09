package com.plcoding.onboarding.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.plcoding.coreui.ComponentPreview
import com.plcoding.coreui.LocalSpacing
import com.plcoding.coreui.PreviewSurface

@Composable
fun SelectableButton(
    text: String,
    isSelected: Boolean,
    color: Color,
    selectedTextColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.button,
) {
    val spacing = LocalSpacing.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .border(
                width = 2.dp,
                color = color,
                shape = RoundedCornerShape(100.dp),
            )
            .background(
                color = if (isSelected) color else Color.Transparent,
                shape = RoundedCornerShape(100.dp),
            )
            .clickable { onClick() }
            .padding(spacing.spaceSmall),

    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(spacing.spaceSmall),
            style = textStyle,
            color = if (isSelected) selectedTextColor else color,
        )
    }
}

@ComponentPreview
@ShowkaseComposable(name = "SelectableButton", group = "Components")
@Composable
fun SelectableButtonPreview() {
    PreviewSurface {
        Column {
            SelectableButton(
                text = "ButtonText",
                isSelected = true,
                color = MaterialTheme.colors.primaryVariant,
                selectedTextColor = Color.White,
                onClick = {},
            )
            Spacer(modifier = Modifier.height(16.dp))
            SelectableButton(
                text = "ButtonText",
                isSelected = false,
                color = MaterialTheme.colors.primaryVariant,
                selectedTextColor = Color.White,
                onClick = {},
            )
            Spacer(modifier = Modifier.height(16.dp))
            SelectableButton(
                text = "ButtonText",
                isSelected = true,
                color = MaterialTheme.colors.secondaryVariant,
                selectedTextColor = Color.White,
                onClick = {},
            )
            Spacer(modifier = Modifier.height(16.dp))
            SelectableButton(
                text = "ButtonText",
                isSelected = false,
                color = MaterialTheme.colors.secondaryVariant,
                selectedTextColor = Color.White,
                onClick = {},
            )
        }
    }
}

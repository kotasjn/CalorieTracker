package com.plcoding.onboarding.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.plcoding.coreui.ComponentPreview
import com.plcoding.coreui.LocalSpacing
import com.plcoding.coreui.PreviewSurface

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.button,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = RoundedCornerShape((100.dp)),
    ) {
        Text(
            text = text,
            style = textStyle,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(LocalSpacing.current.spaceSmall),
        )
    }
}

@ComponentPreview
@ShowkaseComposable(name = "ActionButton", group = "Components")
@Composable
fun ActionButtonPreview() {
    PreviewSurface {
        Column {
            ActionButton(
                text = "ButtonText",
                onClick = {},
                isEnabled = true,
            )
            Spacer(modifier = Modifier.height(16.dp))
            ActionButton(
                text = "ButtonText",
                onClick = {},
                isEnabled = false,
            )
        }
    }
}

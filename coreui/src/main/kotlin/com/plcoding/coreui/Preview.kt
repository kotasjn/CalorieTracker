package com.plcoding.coreui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

/**
 * Preview annotation definitions.
 */
@Preview(name = "Light preview", showBackground = true)
@Preview(name = "Dark preview", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Wide light preview", device = Devices.PIXEL_C, showBackground = true)
@Preview(
    name = "Wide dark preview",
    device = Devices.PIXEL_C,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class ScreenPreview

@Preview(name = "Light preview", showBackground = true)
@Preview(name = "Dark preview", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class ComponentPreview

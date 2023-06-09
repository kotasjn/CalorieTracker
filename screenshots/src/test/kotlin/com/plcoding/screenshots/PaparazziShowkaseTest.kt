package com.plcoding.screenshots

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.Density
import androidx.lifecycle.Lifecycle
import app.cash.paparazzi.Paparazzi
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.android.ide.common.rendering.api.SessionParams
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.plcoding.screenshots.showkase.getMetadata
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class ComponentPreview(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) {
    val content: @Composable () -> Unit = showkaseBrowserComponent.component
    override fun toString(): String =
        showkaseBrowserComponent.group + ":" + showkaseBrowserComponent.componentName
}

@RunWith(TestParameterInjector::class)
class ComponentTests {

    object ComponentPreviewProvider : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<ComponentPreview> =
            Showkase.getMetadata().componentList.filter {
                it.group == "Components"
            }.map(::ComponentPreview)
    }

    @get:Rule
    val paparazziComponent = Paparazzi(
        maxPercentDifference = 0.0,
        showSystemUi = false,
        renderingMode = SessionParams.RenderingMode.SHRINK,
    )

    @Test
    fun component_tests(
        @TestParameter(valuesProvider = ComponentPreviewProvider::class) componentPreview: ComponentPreview,
        @TestParameter(value = ["1", "2"]) fontScale: Float,
        @TestParameter(value = ["light", "dark"]) theme: String,
    ) {
        paparazziComponent.snapshot {
            compositionProvider(fontScale = fontScale, theme = theme) {
                componentPreview.content()
            }
        }
    }
}

@RunWith(TestParameterInjector::class)
class ScreenTests {

    object ScreenPreviewProvider : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<ComponentPreview> =
            Showkase.getMetadata().componentList.filter {
                it.group == "Screens"
            }.map(::ComponentPreview)
    }

    @get:Rule
    val paparazziScreen = Paparazzi(
        maxPercentDifference = 0.0,
        showSystemUi = false,
        renderingMode = SessionParams.RenderingMode.NORMAL,
    )

    @Test
    fun screen_tests(
        @TestParameter(valuesProvider = ScreenPreviewProvider::class) screenPreview: ComponentPreview,
        @TestParameter(value = ["1", "2"]) fontScale: Float,
        @TestParameter(value = ["light", "dark"]) theme: String,
    ) {
        paparazziScreen.snapshot {
            compositionProvider(fontScale = fontScale, theme = theme) {
                screenPreview.content()
            }
        }
    }
}

@Composable
private fun compositionProvider(
    fontScale: Float,
    theme: String,
    content: @Composable () -> Unit,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val configuration = if (theme == "dark") {
        Configuration(LocalConfiguration.current).apply {
            uiMode = Configuration.UI_MODE_NIGHT_YES
        }
    } else {
        LocalConfiguration.current
    }

    CompositionLocalProvider(
        LocalInspectionMode provides true,
        LocalDensity provides Density(
            density = LocalDensity.current.density,
            fontScale = fontScale,
        ),
        LocalConfiguration provides configuration,
        // Needed so that UI that uses it don't crash during screenshot tests
        LocalOnBackPressedDispatcherOwner provides object : OnBackPressedDispatcherOwner {
            override val onBackPressedDispatcher: OnBackPressedDispatcher =
                OnBackPressedDispatcher()

            override val lifecycle: Lifecycle = lifecycleOwner.lifecycle
        },
    ) {
        Box {
            content.invoke()
        }
    }
}

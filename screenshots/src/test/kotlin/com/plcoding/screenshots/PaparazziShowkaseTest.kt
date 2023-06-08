package com.plcoding.screenshots

import com.airbnb.android.showkase.annotation.ShowkaseScreenshot
import com.airbnb.android.showkase.screenshot.testing.paparazzi.PaparazziShowkaseScreenshotTest
import com.plcoding.screenshots.showkase.ShowkaseModule

@ShowkaseScreenshot(rootShowkaseClass = ShowkaseModule::class)
abstract class PaparazziShowkaseTest : PaparazziShowkaseScreenshotTest {
    companion object : PaparazziShowkaseScreenshotTest.CompanionObject
}

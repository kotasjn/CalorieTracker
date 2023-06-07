package libraries

object Build {
    private const val androidBuildToolsVersion = "7.4.2"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    const val kspVersion = "1.8.0-1.0.9"

    private const val hiltAndroidGradlePluginVersion = "2.45"
    const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"

    private const val paparazziVersion = "1.2.0"
    const val paparazziPlugin= "app.cash.paparazzi:paparazzi-gradle-plugin:$paparazziVersion"
}

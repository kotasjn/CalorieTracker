package libraries

object Compose {
    const val composeCompilerVersion = "1.4.1"
    const val composeBomVersion = "2023.03.00"

    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"
    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
    const val material = "androidx.compose.material:material"
    const val ui = "androidx.compose.ui:ui"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val runtime = "androidx.compose.runtime:runtime"

    private const val navigationVersion = "2.4.0-beta02"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val activityComposeVersion = "1.7.1"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val lifecycleVersion = "2.6.1"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}

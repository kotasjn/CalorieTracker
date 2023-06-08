import libraries.Showkase

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("app.cash.paparazzi")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(project(Modules.coreUi))
    implementation(project(Modules.onboardingPresentation))
    implementation(project(Modules.trackerPresentation))

    // Showkase dependencies
    implementation(Showkase.showkase)
    kapt(Showkase.showkaseProcessor)

    testImplementation(Showkase.showkaseTesting)
    testImplementation(Showkase.showkaseTestingPaparazzi)
    kaptTest(Showkase.showkaseProcessor)
}

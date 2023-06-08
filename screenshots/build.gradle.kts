import libraries.Compose
import libraries.Showkase
import libraries.Testing

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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
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

    implementation(platform(Compose.composeBom))
    implementation(Compose.activityCompose)
    implementation(Compose.material)

    // Showkase dependencies
    implementation(Showkase.showkase)
    kapt(Showkase.showkaseProcessor)

    testImplementation(Showkase.showkaseTesting)
    testImplementation(Testing.testParameterInjector)
    kaptTest(Showkase.showkaseProcessor)
}

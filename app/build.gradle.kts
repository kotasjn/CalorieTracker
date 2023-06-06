import libraries.AndroidX
import libraries.Coil
import libraries.Compose
import libraries.DaggerHilt
import libraries.Google
import libraries.Retrofit
import libraries.Room
import libraries.Showkase
import libraries.Testing

plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName
        multiDexEnabled = true

        testInstrumentationRunner = "com.plcoding.calorytracker.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    packagingOptions {
        resources {
            resources.excludes.addAll(
                listOf(
                    "META-INF/AL2.0",
                    "META-INF/LGPL2.1",
                    "**/attach_hotspot_windows.dll",
                    "META-INF/LICENSE.md",
                    "META-INF/LICENSE-notice.md",
                    "META-INF/licenses/ASM",
                    "META-INF/*.kotlin_module",
                ),
            )
        }
    }

    dependencies {
        // Project modules
        implementation(project(Modules.core))
        implementation(project(Modules.coreUi))
        implementation(project(Modules.onboardingPresentation))
        implementation(project(Modules.onboardingDomain))
        implementation(project(Modules.trackerPresentation))
        implementation(project(Modules.trackerDomain))
        implementation(project(Modules.trackerData))
        implementation(project(Modules.screenshots))

        // Jetpack Compose dependencies
        implementation(platform(Compose.composeBom))
        implementation(Compose.compiler)
        implementation(Compose.ui)
        implementation(Compose.uiToolingPreview)
        implementation(Compose.hiltNavigationCompose)
        implementation(Compose.material)
        implementation(Compose.runtime)
        implementation(Compose.navigation)
        implementation(Compose.viewModelCompose)
        implementation(Compose.activityCompose)

        implementation(Showkase.showkase)
        kapt(Showkase.showkaseProcessor)

        // Hilt dependencies
        implementation(DaggerHilt.hiltAndroid)
        kapt(DaggerHilt.hiltCompiler)

        // Other core AndroidX dependencies
        implementation(AndroidX.coreKtx)
        implementation(AndroidX.appCompat)

        // Coil dependency
        implementation(Coil.coilCompose)

        // Material design dependency
        implementation(Google.material)

        // Retrofit dependencies
        implementation(Retrofit.okHttp)
        implementation(Retrofit.retrofit)
        implementation(Retrofit.okHttpLoggingInterceptor)
        implementation(Retrofit.moshiConverter)

        // Room dependencies
        kapt(Room.roomCompiler)
        implementation(Room.roomKtx)
        implementation(Room.roomRuntime)

        // Testing dependencies
        testImplementation(Testing.junit4)
        testImplementation(Testing.junitAndroidExt)
        testImplementation(Testing.truth)
        testImplementation(Testing.coroutines)
        testImplementation(Testing.turbine)
        testImplementation(Testing.composeUiTest)
        testImplementation(Testing.mockk)
        testImplementation(Testing.mockWebServer)

        androidTestImplementation(Testing.junit4)
        androidTestImplementation(Testing.junitAndroidExt)
        androidTestImplementation(Testing.truth)
        androidTestImplementation(Testing.coroutines)
        androidTestImplementation(Testing.turbine)
        androidTestImplementation(Testing.composeUiTest)
        androidTestImplementation(Testing.mockkAndroid)
        androidTestImplementation(Testing.mockWebServer)
        androidTestImplementation(Testing.hiltTesting)
        kaptAndroidTest(DaggerHilt.hiltCompiler)
        androidTestImplementation(Testing.testRunner)
    }
}

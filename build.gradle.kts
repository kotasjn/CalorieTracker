// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libraries.Build.androidBuildTools)
        classpath(libraries.Build.hiltAndroidGradlePlugin)
        classpath(libraries.Build.kotlinGradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}

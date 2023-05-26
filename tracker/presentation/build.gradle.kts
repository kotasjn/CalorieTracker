import libraries.Coil

apply("$rootDir/compose-module.gradle")
plugins {
    id("app.cash.paparazzi")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.trackerDomain))

    "implementation"(Coil.coilCompose)
}

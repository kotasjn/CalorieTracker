dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CaloryTracker"

include(":app")

include(":core")

include(":coreui")

include(
    ":onboarding:presentation",
    ":onboarding:domain",
)

include(
    ":tracker:data",
    ":tracker:domain",
    ":tracker:presentation",
)

include(":screenshots")

rootProject.name = "MasikKMP"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")

include(":common:core:di")
include(":common:core:network")
include(":common:mvi")

include(":data:common-data")
include(":data:note-data:note-common-data")
include(":data:note-data:note-entry-data")
include(":data:note-data:note-list-data")

include(":domain:note-domain:note-common-domain")
include(":domain:note-domain:note-entry-domain")
include(":domain:note-domain:note-list-domain")

include(":feature:main-feature")

include(":feature:note-feature:note-entry-feature")
include(":feature:note-feature:note-list-feature")

include(":feature:order-taxi-feature")
include(":feature:photo-feature")
include(":feature:tabs-feature")
include(":feature:wishlist-feature")
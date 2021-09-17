import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlinx-serialization")
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        else -> ::iosX64
    }

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Develop.Ktor.commonCore)
                implementation(Develop.Ktor.commonJson)
                implementation(Develop.Ktor.commonLogging)
                implementation(Develop.Ktor.commonSerialization)
                implementation(Develop.Coroutines.common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies{
                implementation(Develop.Ktor.androidCore)
                implementation(Develop.Coroutines.android)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
                implementation(Develop.Coroutines.test)
            }
        }
        val iosMain by getting{
            dependencies{
                implementation(Develop.Ktor.ios)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
}
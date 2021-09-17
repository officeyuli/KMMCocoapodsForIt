object Versions{
    val ktor = "1.6.3"
    val coroutines =  "1.5.0-native-mt"
    val serialization_version = "1.5.21"

    object AndroidX {
        val core = "1.6.0"
        val lifecycle = "2.4.0-alpha02"
        val test = "1.3.0"
        val test_ext = "1.1.2"
    }
}

object Develop{
    object Ktor{
        val commonCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        val commonJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        val commonLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        val androidCore = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
        val commonSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    }

    object Coroutines{
        val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object AndroidX {
        val core_ktx = "androidx.core:core-ktx:${Versions.AndroidX.core}"

        val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycle}"
        val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.AndroidX.lifecycle}"
        val lifecycle_viewmodel_extensions = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
    }
}

object Classpath{
    val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.serialization_version}";
}

object Libs {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.KOTLIN}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
    }

    object Network {
        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
        }

        object OkHttp {
            const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
            const val mockWebserver = "com.squareup.okhttp3:mockwebserver:${Versions.OKHTTP}"
        }

        object Moshi {
            const val moshi = "com.squareup.moshi:moshi:${Versions.MOSHI}"
            const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"
            const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.MOSHI}"
        }
    }

    object Coil {
        private const val version = "1.3.0"
        const val composeCoil = "io.coil-kt:coil-compose:$version"
    }

    object Compose {
        const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.COMPOSE}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.COMPOSE}"
        const val composeMaterialIconsCore = "androidx.compose.material:material-icons-core:${Versions.COMPOSE}"
        const val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.COMPOSE}"
        const val composeAccompanistPermissions = "com.google.accompanist:accompanist-permissions:${Versions.COMPOSE_ACCOMPANIST}"
        const val composeAccompanistPager = "com.google.accompanist:accompanist-pager:${Versions.COMPOSE_ACCOMPANIST}"
        const val composeActivity = "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
        const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.COMPOSE_VIEW_MODEL}"
    }
}


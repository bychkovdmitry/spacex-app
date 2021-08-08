plugins {
    `java-library`
    kotlin("jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.core)

    implementation(Libs.Network.Retrofit.retrofit)
    kapt(Libs.Network.Moshi.codegen)
    implementation(Libs.Network.Moshi.moshi)
}
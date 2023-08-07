plugins {
    id("java-library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_1_8.majorVersion))
    }
}

dependencies {
    api(project(":domain"))
    api(libs.coroutine.android)
    implementation(libs.hilt.core)
    kapt(libs.hilt.compiler)
}
plugins {
    id("java-library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_11.majorVersion))
    }
}

dependencies {
    api(project(":domain"))
    api(libs.coroutine.android)
    implementation(libs.hilt.core)
    kapt(libs.hilt.compiler)
    testImplementation(libs.andoirdx.test)
    testImplementation(libs.junit.test)
    testImplementation(libs.assertJ.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.coroutine.test)
}
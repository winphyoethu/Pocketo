plugins {
    id("java-library")
    id("kotlin")
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
    implementation(libs.coroutine.android)
    implementation(libs.javax.inject)
    api(libs.junit.test)
    api(libs.assertJ.core)
    api(libs.mockito.kotlin)
    api(libs.mockito.core)
    api(libs.mockito.inline)
    api(libs.coroutine.test)
}
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.github.weslleystos.namegame"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.github.weslleystos.namegame"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://namegame.willowtreeapps.com/api/v1.0/\""
            )
        }
        create("qa") {
            dimension = "environment"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://namegame.willowtreeapps.com/api/v1.0/\""
            )
        }
        create("prod") {
            dimension = "environment"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://namegame.willowtreeapps.com/api/v1.0/\""
            )
        }
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    // Hilt
    implementation(libs.bundles.hilt)
    kapt(libs.bundles.hilt.kapt)

    // Retrofit
    implementation(libs.bundles.retrofit)

    // Glide
    implementation(libs.glide)

    // Unit Test
    testImplementation(libs.bundles.unit.tests)

    // Ui Test
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.bundles.ui.tests)

    debugImplementation(libs.bundles.debug)

    kaptTest(libs.bundles.hilt.kapt.test)
    kaptAndroidTest(libs.bundles.hilt.kapt.test)
}

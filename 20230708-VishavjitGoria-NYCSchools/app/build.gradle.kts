plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.nyc.myapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.nyc.myapplication"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    packagingOptions {
//        jniLibs {
//            pickFirsts += ['lib/arm64-v8a/libavcodec.so', 'lib/armeabi-v7a/libc++_shared.so', 'lib/arm64-v8a/libc++_shared.so', 'lib/x86/libc++_shared.so', 'lib/x86_64/libc++_shared.so']
//        }
        resources {
            excludes.add("META-INF/rxjava.properties")
            excludes.add("META-INF/gradle/incremental.annotation.processors")
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
//        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
//    }

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-common:2.6.1")

    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")


    //hilt
    implementation("com.google.dagger:hilt-android:2.47")
//    implementation("com.google.dagger:hilt-compiler:2.47")
    kapt ("com.google.dagger:hilt-compiler:2.47")

}
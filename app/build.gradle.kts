import Libraries.androidTestImplementationX
import Libraries.implementationX
import Libraries.testImplementationX

plugins {
    id(Config.Plugins.android)
    kotlin(Config.Plugins.kotlinAndroid)
    kotlin(Config.Plugins.kotlinKapt)
    id("dagger.hilt.android.plugin")
}

android{
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTool)

    defaultConfig{
        applicationId = ApplicationId.appId
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = Config.testRunner
    }
    buildTypes{
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true
    kotlinOptions.jvmTarget = Versions.jvm
    lintOptions.disable("ContentDescription")

    dependencies{
        implementationX(Libraries.appLibraries)
        androidTestImplementationX(Libraries.androidTestLibraries)
//        testImplementationX(Libraries.testLibraries)
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

    implementation("com.facebook.shimmer:shimmer:0.5.0")
    // to display internet images
    implementation("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson
    implementation("com.squareup.retrofit2:converter-gson:2.0.0-beta3")
    implementation("androidx.fragment:fragment-ktx:1.5.4")

    implementation("com.google.dagger:hilt-android:2.40.1")
    kapt("com.google.dagger:hilt-compiler:2.40.1")
    annotationProcessor("com.google.dagger:hilt-compiler:2.40.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.fragment:fragment-ktx:1.5.4")
}
buildscript{
    val kotlin_version by extra("1.5.10")
    val hilt_version by extra("2.40.1")
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Config.Dependencies.androidPlugin)
        classpath(Config.Dependencies.kotlinPlugin)
        classpath(Config.Dependencies.googlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${hilt_version}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri(Config.Repositories.jitPack)}
        maven { url = uri(Config.Repositories.pluginGradle)}
    }
}

tasks.register("clean", Delete::class){ delete(rootProject.buildDir)}
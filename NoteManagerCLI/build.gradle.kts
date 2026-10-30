plugins {
    kotlin("jvm") version "2.4.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("../NoteManagerLibrary/build/libs/NoteManagerLibrary-1.0-SNAPSHOT.jar"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
}

application {
    mainClass.set("MainKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

distributions {
    main{
        contents {
            from("notes.json")
        }
    }
}
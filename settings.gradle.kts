plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "NoteMan"
include("NoteManagerLibrary")
include("NoteManagerLibrary")
include("NoteManagerLibrary", "NoteManagerCLI")
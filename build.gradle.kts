import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val minecraft_version: String by project
val mod_version: String by project
val mod_group: String by project
val mod_id: String by project

plugins {
    kotlin("jvm") version "1.7.10" apply false
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("dev.architectury.loom") version "0.12.0-SNAPSHOT" apply false
}

architectury {
    minecraft = minecraft_version
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("architectury-plugin")
        plugin("dev.architectury.loom")
    }


    dependencies {
        "minecraft"("com.mojang:minecraft:${minecraft_version}")
        // The following line declares the mojmap mappings, you may use other mappings as well
    }
}

allprojects {
    version = mod_version
    group = mod_group

    tasks {
        withType<KotlinCompile>() {
            kotlinOptions.jvmTarget = "17"
        }
    }
}

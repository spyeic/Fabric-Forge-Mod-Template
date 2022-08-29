val minecraft_version: String by project
val forge_version: String by project


architectury {
    platformSetupLoomIde()
    forge()
}

loom {
    accessWidenerPath.set(file("${project(":common").projectDir}/src/main/resources/modid.accesswidener"))

    officialMojangMappings()

    forge {
        convertAccessWideners.set(true)
        extraAccessWideners.add(loom.accessWidenerPath.get().asFile.name)
        mixinConfig("modid-common.mixins.json")
        mixinConfig("modid.mixins.json")
    }
}

dependencies {
    forge("net.minecraftforge:forge:${forge_version}")
    mappings(loom.officialMojangMappings())
}
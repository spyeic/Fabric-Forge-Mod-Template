architectury {
    common("fabric", "forge")
}

dependencies {
    val fabric_loader_version: String by project
    modImplementation("net.fabricmc:fabric-loader:${fabric_loader_version}")
    mappings(loom.officialMojangMappings())
}

loom {
    accessWidenerPath.set(file("src/main/resources/modid.accesswidener"))
}
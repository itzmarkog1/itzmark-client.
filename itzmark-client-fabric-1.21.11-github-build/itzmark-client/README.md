# itzMark Client — Fabric 1.21.11

A client-side Minecraft Java mod with a custom dark red/black title screen.

## Included
- Replaces the vanilla title screen with the itzMark Client menu.
- **Singleplayer** opens Minecraft's world selection screen.
- **Multiplayer** opens Minecraft's server list.
- **Settings** opens vanilla options.
- **Mods & Modules**, **HUD Editor**, and **Cosmetics** open branded starter panels.
- **Quit Game** closes Minecraft.

The module, HUD, and cosmetics pages are UI foundations only. Gameplay modules, draggable HUD widgets, cosmetic rendering/sync, and a real mod browser are not implemented yet.

## Requirements
- Minecraft Java 1.21.11
- Fabric Loader 0.19.4 (or compatible 1.21.11 loader)
- Fabric API 0.141.1+1.21.11
- Java 21 JDK
- Gradle 8.14 or newer, or IntelliJ IDEA with Gradle project import

## Build on Windows
1. Install a Java 21 JDK.
2. Install Gradle 8.14+ (or open the project folder in IntelliJ IDEA and allow Gradle sync).
3. Open PowerShell in this folder and run:

```powershell
.\build.ps1
```

Or run `gradle build` directly. The distributable JAR should appear in `build/libs/`.

## Install
1. Install Fabric for Minecraft 1.21.11.
2. Install Fabric API matching Minecraft 1.21.11.
3. Copy the built `itzmark-client-1.0.0.jar` from `build/libs/` into `%appdata%\\.minecraft\\mods`.
4. Launch the Fabric 1.21.11 profile.

## Version configuration
The versions are in `gradle.properties`. The project uses Mojang official mappings, Java 21, Fabric Loom 1.14-SNAPSHOT, and Fabric API 0.141.1+1.21.11.

## Important
This is the initial source project, not a tested compiled JAR. The build could not be run in this environment because Gradle is not installed and outbound dependency downloads are unavailable. Run the Gradle build locally before using it, and back up your Minecraft instance before testing.

package com.itzmark.client;

import com.itzmark.client.screen.ClientPanelScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.network.chat.Component;

public final class ItzMarkHomeScreen extends Screen {
    private static final int RED = 0xFFB51F32;
    private static final int DARK = 0xE8101016;
    private static final int PANEL = 0xE91B151B;
    private static final int MUTED = 0xFFB8AEB4;

    public ItzMarkHomeScreen() {
        super(Component.literal("itzMark Client"));
    }

    @Override
    protected void init() {
        int center = this.width / 2;
        int menuWidth = Math.min(310, this.width - 40);
        int x = center - menuWidth / 2;
        int y = Math.max(155, this.height / 2 - 65);
        int h = 32;
        int gap = 8;

        addRenderableWidget(Button.builder(Component.literal("SINGLEPLAYER"), b ->
                Minecraft.getInstance().setScreen(new SelectWorldScreen(this)))
                .bounds(x, y, menuWidth, h).build());
        addRenderableWidget(Button.builder(Component.literal("MULTIPLAYER"), b ->
                Minecraft.getInstance().setScreen(new JoinMultiplayerScreen(this)))
                .bounds(x, y + h + gap, menuWidth, h).build());
        addRenderableWidget(Button.builder(Component.literal("MODS & MODULES"), b ->
                Minecraft.getInstance().setScreen(new ClientPanelScreen(this, "MODS & MODULES", "Client module manager", new String[]{"Toggle sprint  [COMING SOON]", "Keystrokes     [COMING SOON]", "FPS counter    [COMING SOON]", "Crosshair      [COMING SOON]"})))
                .bounds(x, y + (h + gap) * 2, menuWidth, h).build());
        addRenderableWidget(Button.builder(Component.literal("SETTINGS"), b ->
                Minecraft.getInstance().setScreen(new OptionsScreen(this, Minecraft.getInstance().options)))
                .bounds(x, y + (h + gap) * 3, menuWidth, h).build());
        addRenderableWidget(Button.builder(Component.literal("HUD EDITOR"), b ->
                Minecraft.getInstance().setScreen(new ClientPanelScreen(this, "HUD EDITOR", "HUD customization workspace", new String[]{"FPS / CPS display", "Coordinates", "Keystrokes", "Scoreboard layout"})))
                .bounds(x, y + (h + gap) * 4, menuWidth, h).build());
        addRenderableWidget(Button.builder(Component.literal("COSMETICS"), b ->
                Minecraft.getInstance().setScreen(new ClientPanelScreen(this, "COSMETICS", "Cosmetics preview", new String[]{"Cape slot       [COMING SOON]", "Wings           [COMING SOON]", "Emotes          [COMING SOON]"})))
                .bounds(x, y + (h + gap) * 5, menuWidth, h).build());
        addRenderableWidget(Button.builder(Component.literal("QUIT GAME"), b -> Minecraft.getInstance().stop())
                .bounds(x, Math.min(this.height - 42, y + (h + gap) * 6), menuWidth, 24).build());
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        renderBackground(g, mouseX, mouseY, partialTick);
        g.fill(0, 0, width, height, 0xCC09080D);
        // Subtle red side rails and panel frame.
        g.fill(0, 0, 5, height, RED);
        g.fill(width - 5, 0, width, height, RED);
        int panelW = Math.min(560, width - 24);
        int left = width / 2 - panelW / 2;
        g.fill(left, 18, left + panelW, 126, PANEL);
        g.fill(left, 18, left + panelW, 21, RED);
        g.fill(left, 123, left + panelW, 126, RED);
        g.drawCenteredString(font, "itzMARK", width / 2, 38, 0xFFFFFFFF);
        g.drawCenteredString(font, "CLIENT", width / 2, 57, RED);
        g.drawCenteredString(font, "MODS  •  PVP  •  PERFORMANCE", width / 2, 83, MUTED);
        g.drawCenteredString(font, "MINECRAFT 1.21.11  |  FABRIC EDITION", width / 2, 101, 0xFF8E858D);
        g.drawString(font, "itzMark Client", 14, height - 18, 0xFFDD3448);
        g.drawString(font, "v1.0.0  •  Fabric", width - font.width("v1.0.0  •  Fabric") - 14, height - 18, MUTED);
        super.render(g, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() { return false; }
}

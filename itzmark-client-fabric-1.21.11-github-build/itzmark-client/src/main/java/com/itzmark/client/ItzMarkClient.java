package com.itzmark.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;

public final class ItzMarkClient implements ClientModInitializer {
    public static final String MOD_ID = "itzmarkclient";

    @Override
    public void onInitializeClient() {
        // The title screen mixin opens the custom client interface on startup.
    }

    public static void openHome() {
        Minecraft.getInstance().setScreen(new ItzMarkHomeScreen());
    }
}

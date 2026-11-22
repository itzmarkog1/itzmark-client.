package com.itzmark.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class ClientPanelScreen extends Screen {
    private final Screen parent;
    private final String heading;
    private final String subtitle;
    private final String[] rows;

    public ClientPanelScreen(Screen parent, String heading, String subtitle, String[] rows) {
        super(Component.literal(heading));
        this.parent = parent;
        this.heading = heading;
        this.subtitle = subtitle;
        this.rows = rows;
    }

    @Override
    protected void init() {
        addRenderableWidget(Button.builder(Component.literal("BACK TO CLIENT"), b -> minecraft.setScreen(parent))
                .bounds(width / 2 - 100, height - 48, 200, 28).build());
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        renderBackground(g, mouseX, mouseY, partialTick);
        g.fill(0, 0, width, height, 0xD909080D);
        int panelW = Math.min(440, width - 30);
        int left = width / 2 - panelW / 2;
        int top = Math.max(40, height / 2 - 125);
        g.fill(left, top, left + panelW, top + 235, 0xF019141A);
        g.fill(left, top, left + panelW, top + 3, 0xFFB51F32);
        g.drawCenteredString(font, heading, width / 2, top + 20, 0xFFFFFFFF);
        g.drawCenteredString(font, subtitle, width / 2, top + 40, 0xFFB8AEB4);
        int y = top + 76;
        for (String row : rows) {
            g.fill(left + 18, y - 5, left + panelW - 18, y + 19, 0xFF251B23);
            g.fill(left + 18, y - 5, left + 21, y + 19, 0xFFB51F32);
            g.drawString(font, row, left + 30, y + 2, 0xFFE7DDE3);
            y += 32;
        }
        g.drawCenteredString(font, "More client features will be added in future builds.", width / 2, top + 212, 0xFF91858E);
        super.render(g, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() { return false; }
}

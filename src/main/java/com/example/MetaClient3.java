package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import com.example.clickgui.ClickGUI;

public class MetaClient3Client implements ClientModInitializer {
    public static KeyBinding clickGuiKey;

    @Override
    public void onInitializeClient() {
        clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Open ClickGUI", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "MetaClient3"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(clickGuiKey.wasPressed()) {
                client.setScreen(new ClickGUI());
            }
        });
    }
}

/*
 * Copyright 2018-2020
 * - Bettercolors Contributors (https://github.com/N3ROO/Bettercolors) and
 * - Bettercolors Engine Contributors (https://github.com/N3ROO/BettercolorsEngine)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.nero.bettercolors.engine.wrapper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.PlayerContainer;

/**
 * Wrapper for Minecraft 1.16
 */
public class Wrapper {

    public final static Minecraft MC = Minecraft.getInstance();
    public final static ClientPlayerEntity thePlayer = Minecraft.getInstance().player;
    public final static ClientWorld theWorld = Minecraft.getInstance().world;

    public final static Class<PlayerEntity> playerEntityClass = PlayerEntity.class;

    /**
     * @param e entity.
     * @return the team tag of the entity.
     */
    public static String exportTag(PlayerEntity e){
        String tag;
        try{
            tag = e.getDisplayName().getUnformattedComponentText().split(e.getName().getString())[0].replace(" ","");
            tag = tag.replace("§","");
        }catch(Exception exc){
            tag = "";
        }
        return tag;
    }

    /**
     * @return true if the user is in a Gui (he can't move).
     */
    public static boolean isInGui(){
        if(Wrapper.thePlayer == null) return true;
        return (Wrapper.thePlayer.isSleeping() ||
                Wrapper.thePlayer.isShowDeathScreen() ||
                !(Wrapper.thePlayer.openContainer instanceof PlayerContainer) ||
                !MC.isGameFocused());
    }
}

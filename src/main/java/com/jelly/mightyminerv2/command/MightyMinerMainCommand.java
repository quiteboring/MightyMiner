package com.jelly.mightyminerv2.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import cc.polyfrost.oneconfig.utils.commands.annotations.SubCommand;
import com.jelly.mightyminerv2.MightyMiner;
import com.jelly.mightyminerv2.util.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovingObjectPosition;

@Command(value = "mightyminer", aliases = {"mm"})
public class MightyMinerMainCommand {

    private final Minecraft mc = Minecraft.getMinecraft();

    @Main
    public void main() {
        MightyMiner.config.openGui();
    }

    @SubCommand
    public void state() {
        MovingObjectPosition mop = mc.objectMouseOver;

        if (mop == null || mop.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) {
            Logger.sendError("You currently are not looking at a block.");
            return;
        }

        IBlockState state = mc.theWorld.getBlockState(mop.getBlockPos());
        int id = Block.getStateId(state);

        Logger.sendMessage("State ID: " + id);
    }

}

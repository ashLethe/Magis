package com.github.leomagis.magis.proxy;

import com.github.leomagis.magis.container.ContainerElementalCentrifuge;
import com.github.leomagis.magis.entity.tile.TileElementalCentrifuge;
import com.github.leomagis.magis.entity.tile.client.TileElementalCentrifugeClient;
import com.github.leomagis.magis.gui.GUIElementalCentrifuge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{

    public void registerRenderers() {}

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int blockX, int blockY, int blockZ) {
        switch(ID) {
            case GUIElementalCentrifuge.GUIID:
                return new ContainerElementalCentrifuge(player, (TileElementalCentrifuge) world.getTileEntity(new BlockPos(blockX, blockY, blockZ)));
        }
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int blockX, int blockY, int blockZ) {
        switch(ID) {
            case GUIElementalCentrifuge.GUIID:
                return new GUIElementalCentrifuge((TileElementalCentrifugeClient) world.getTileEntity(new BlockPos(blockX, blockY, blockZ)), player);
        }
        return null;
    }

}

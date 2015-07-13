package com.github.leomagis.magis.render;

import com.github.leomagis.magis.entity.tile.client.TileFusionStationClient;
import com.github.leomagis.magis.model.ModelFusionStation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFusionStation extends TileEntitySpecialRenderer {

    private static final ModelFusionStation model = new ModelFusionStation();

    private static final ResourceLocation textureLocation =
            new ResourceLocation("magis:textures/blocks/SocketPlate.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks, int destroyStage) {
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.5, y+1.725, z+0.5);
        GL11.glRotated(180.0, 1.0, 0.0, 0.0);

        bindTexture(textureLocation);
        model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.03125F);

        GL11.glPopMatrix();

        TileFusionStationClient fusionStation = (TileFusionStationClient) tileEntity;
        for(int i=0;i<9;++i) {
            ItemStack stackInSlot = fusionStation.getStackInSlot(i);
            if(stackInSlot == null) {continue;}

            GL11.glPushMatrix();
            GL11.glTranslated(x+0.25+((i/3)*0.25), y+1.25, z+0.25+((i%3)*0.25));
            GL11.glRotated(((fusionStation.itemSpinTicks%80)+partialTicks)*4.5, 0.0, 1.0, 0.0);
            GL11.glScaled(0.25, 0.25, 0.25);

            Minecraft.getMinecraft().getRenderItem().func_175043_b(stackInSlot);

            GL11.glPopMatrix();
        }
    }
}

package com.github.leomagis.magis.entity.renderer;

import com.github.leomagis.magis.model.ModelFusionStation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
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
        //TODO Add item in socket rendering code
    }
}

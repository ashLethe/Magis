package com.github.leomagis.magis.entity.renderer;

import com.github.leomagis.magis.model.ModelFusionStation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderFusionStation extends TileEntitySpecialRenderer {

    private static final ModelFusionStation model = new ModelFusionStation();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float param5, int param6) {
        model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    }
}

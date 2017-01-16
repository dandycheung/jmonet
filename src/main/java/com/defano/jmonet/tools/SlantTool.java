package com.defano.jmonet.tools;

import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.base.AbstractTransformTool;
import com.defano.jmonet.model.FlexQuadrilateral;
import com.defano.jmonet.tools.util.Transform;

import java.awt.*;

public class SlantTool extends AbstractTransformTool {

    public SlantTool() {
        super(PaintToolType.SLANT);
    }

    @Override
    public void moveTopLeft(FlexQuadrilateral quadrilateral, Point newPosition) {
        quadrilateral.getTopRight().x += newPosition.x - quadrilateral.getTopLeft().x;
        quadrilateral.getTopLeft().x = newPosition.x;

        int xTranslation = (quadrilateral.getTopLeft().x - getSelectionOutline().getBounds().x) / 2;
        setSelectedImage(Transform.slant(getOriginalImage(), quadrilateral, xTranslation));
    }

    @Override
    public void moveTopRight(FlexQuadrilateral quadrilateral, Point newPosition) {
        quadrilateral.getTopLeft().x += newPosition.x - quadrilateral.getTopRight().x;
        quadrilateral.getTopRight().x = newPosition.x;

        int xTranslation = (quadrilateral.getTopLeft().x - getSelectionOutline().getBounds().x) / 2;
        setSelectedImage(Transform.slant(getOriginalImage(), quadrilateral, xTranslation));
    }

    @Override
    public void moveBottomLeft(FlexQuadrilateral quadrilateral, Point newPosition) {
        quadrilateral.getBottomRight().x += newPosition.x - quadrilateral.getBottomLeft().x;
        quadrilateral.getBottomLeft().x = newPosition.x;

        int xTranslation = ((getSelectionOutline().getBounds().x + getSelectionOutline().getBounds().width) - quadrilateral.getBottomRight().x) / 2;
        setSelectedImage(Transform.slant(getOriginalImage(), quadrilateral, xTranslation));
    }

    @Override
    public void moveBottomRight(FlexQuadrilateral quadrilateral, Point newPosition) {
        quadrilateral.getBottomLeft().x += newPosition.x - quadrilateral.getBottomRight().x;
        quadrilateral.getBottomRight().x = newPosition.x;

        int xTranslation = ((getSelectionOutline().getBounds().x + getSelectionOutline().getBounds().width) - quadrilateral.getBottomRight().x) / 2;
        setSelectedImage(Transform.slant(getOriginalImage(), quadrilateral, xTranslation));
    }
}

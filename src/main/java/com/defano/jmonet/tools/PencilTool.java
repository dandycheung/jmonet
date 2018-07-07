package com.defano.jmonet.tools;

import com.defano.jmonet.canvas.Scratch;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.base.AbstractPathTool;
import com.defano.jmonet.tools.util.CursorFactory;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Tool for drawing or erasing a single-pixel, free-form path on the canvas.
 */
public class PencilTool extends AbstractPathTool {

    private boolean isErasing = false;

    public PencilTool() {
        super(PaintToolType.PENCIL);
        setToolCursor(CursorFactory.makePencilCursor());
    }

    /** {@inheritDoc} */
    @Override
    protected void startPath(Scratch scratch, Stroke stroke, Paint fillPaint, Point initialPoint) {
        Color pixel = new Color(getCanvas().getCanvasImage().getRGB(initialPoint.x, initialPoint.y), true);
        isErasing = pixel.getAlpha() >= 128;

        renderStroke(scratch, fillPaint, new Line2D.Float(initialPoint, initialPoint));
    }

    /** {@inheritDoc} */
    @Override
    protected void addPoint(Scratch scratch, Stroke stroke, Paint fillPaint, Point lastPoint, Point thisPoint) {
        renderStroke(scratch, fillPaint, new Line2D.Float(lastPoint, thisPoint));
    }

    private void renderStroke(Scratch scratch, Paint fillPaint, Line2D stroke) {
        Graphics2D g = isErasing ?
                scratch.getRemoveScratchGraphics(this, new BasicStroke(1), stroke) :
                scratch.getAddScratchGraphics(this, new BasicStroke(1), stroke);

        g.setStroke(new BasicStroke(1));
        g.setPaint(fillPaint);
        g.draw(stroke);
    }
}

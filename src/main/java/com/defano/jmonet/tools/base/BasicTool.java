package com.defano.jmonet.tools.base;

import com.defano.jmonet.canvas.PaintCanvas;
import com.defano.jmonet.canvas.Scratch;
import com.defano.jmonet.canvas.observable.SurfaceInteractionObserver;
import com.defano.jmonet.context.GraphicsContext;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.attributes.ToolAttributes;
import com.defano.jmonet.tools.cursors.CursorManager;
import com.google.inject.Inject;

import java.awt.*;

public abstract class BasicTool implements Tool, SurfaceInteractionObserver {

    private final PaintToolType toolType;
    private PaintCanvas canvas;

    @Inject private ToolAttributes toolAttributes;
    @Inject private CursorManager cursorManager;

    public BasicTool(PaintToolType toolType) {
        this.toolType = toolType;
    }

    /**
     * Gets the cursor that should be initially displayed when activating this tool.
     * @return The default cursor.
     */
    public abstract Cursor getDefaultCursor();

    /** {@inheritDoc} */
    @Override
    public void activate(PaintCanvas canvas) {
        deactivate();
        this.canvas = canvas;
        this.canvas.addSurfaceInteractionObserver(this);

        setToolCursor(getDefaultCursor());
    }

    /** {@inheritDoc} */
    @Override
    public void deactivate() {
        if (canvas != null) {
            canvas.removeSurfaceInteractionObserver(this);
        }
    }

    /** {@inheritDoc} */
    @Override
    public Cursor getToolCursor() {
        return cursorManager == null ? null : cursorManager.getToolCursor();
    }

    /** {@inheritDoc} */
    @Override
    public void setToolCursor(Cursor toolCursor) {
        if (cursorManager != null) {
            cursorManager.setToolCursor(toolCursor, canvas);
        }
    }

    /** {@inheritDoc} */
    @Override
    public PaintCanvas getCanvas() {
        return canvas;
    }

    /** {@inheritDoc} */
    @Override
    public Scratch getScratch() {
        if (getCanvas() == null) {
            throw new IllegalStateException("Tool is not active on a canvas.");
        }

        Scratch scratch = getCanvas().getScratch();
        applyRenderingHints(scratch.getAddScratchGraphics(this, null));
        applyRenderingHints(scratch.getRemoveScratchGraphics(this, null));

        return scratch;
    }

    /** {@inheritDoc}
     * @param g*/
    @Override
    public void applyRenderingHints(GraphicsContext g) {
        switch (getToolAttributes().getAntiAliasing()) {
            case NONE:
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
                break;
            case DEFAULT:
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
                break;
            case NEAREST_NEIGHBOR:
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                break;
            case BICUBIC:
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                break;
            case BILINEAR:
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                break;
        }
    }

    /** {@inheritDoc} */
    @Override
    public PaintToolType getToolType() {
        return toolType;
    }

    /** {@inheritDoc} */
    @Override
    public ToolAttributes getToolAttributes() {
        return toolAttributes;
    }
}

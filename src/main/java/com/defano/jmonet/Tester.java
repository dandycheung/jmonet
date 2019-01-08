package com.defano.jmonet;

import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.canvas.layer.ImageLayer;
import com.defano.jmonet.canvas.layer.ImageLayerSet;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.FillTool;
import com.defano.jmonet.tools.PencilTool;
import com.defano.jmonet.tools.base.Tool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import com.defano.jmonet.tools.builder.StrokeBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tester {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            // Create and show Swing frame
            JFrame frame = new JFrame("My Pretty Picture");
            frame.setPreferredSize(new Dimension(600, 600));
            frame.setLayout(new FlowLayout());
            frame.pack();
            frame.setVisible(true);

            // Create a JMonet canvas and add it to the window
            JMonetCanvas myCanvas = new JMonetCanvas(new Dimension(400, 400));

            JScrollPane scroll = new JScrollPane();
//            scroll.setPreferredSize(new Dimension(300, 300));
            scroll.setViewportView(myCanvas);

//            myCanvas.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            myCanvas.setScale(1);
//            myCanvas.setScanlineScaleThreadhold(100);

            frame.getContentPane().add(scroll);


            BufferedImage img = new BufferedImage(6, 4, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g = img.createGraphics();
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, 40, 40);
            g.dispose();

            myCanvas.commit(new ImageLayerSet(new ImageLayer(new Point(40, 40), img, AlphaComposite.SrcOver)));

            Tool activeTool = PaintToolBuilder.create(PaintToolType.FILL)
                    .withStroke(StrokeBuilder.withShape().ofCircle(8).build())
                    .withFillPaint(Color.BLUE)
                    .withStrokePaint(Color.RED)
                    .withEraseColor(null)
                    .makeActiveOnCanvas(myCanvas)
                    .build();

        });
    }

}

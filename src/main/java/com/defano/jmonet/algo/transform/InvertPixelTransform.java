package com.defano.jmonet.algo.transform;

public class InvertPixelTransform implements PixelTransform {

    @Override
    public int transformPixel(int x, int y, int argb) {
        int alpha = 0xff000000 & argb;
        int rgb = 0x00ffffff & argb;

        // Invert preserving alpha channel
        return alpha | (~rgb & 0x00ffffff);
    }
}

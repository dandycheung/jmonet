package com.defano.jmonet.tools.builder;

import com.defano.jmonet.model.Interpolation;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

import java.awt.*;
import java.util.Optional;

@SuppressWarnings("unused")
public class DefaultToolAttributes implements ToolAttributes {

    private Observable<Interpolation> antiAliasingObservable = BehaviorSubject.createDefault(Interpolation.NONE);
    private Observable<Integer> constrainedAngleObservable = BehaviorSubject.createDefault(15);
    private Observable<Stroke> strokeObservable = BehaviorSubject.createDefault(new BasicStroke(2));
    private Observable<Paint> strokePaintObservable = BehaviorSubject.createDefault(Color.BLACK);
    private Observable<Optional<Paint>> fillPaintObservable = BehaviorSubject.createDefault(Optional.empty());
    private Observable<Optional<Color>> eraseColorObservable = BehaviorSubject.createDefault(Optional.empty());
    private Observable<Integer> shapeSidesObservable = BehaviorSubject.createDefault(5);
    private Observable<Font> fontObservable = BehaviorSubject.createDefault(new Font("Courier", Font.PLAIN, 14));
    private Observable<Color> fontColorObservable = BehaviorSubject.createDefault(Color.BLACK);
    private Observable<Double> intensityObservable = BehaviorSubject.createDefault(0.1);
    private Observable<Boolean> drawMultipleObservable = BehaviorSubject.createDefault(false);
    private Observable<Boolean> drawCenteredObservable = BehaviorSubject.createDefault(false);
    private Observable<Integer> cornerRadiusObservable = BehaviorSubject.createDefault(10);

    /** {@inheritDoc} */
    @Override
    public void setFontColorObservable(Observable<Color> fontColorObservable) {
        this.fontColorObservable = fontColorObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setStrokePaintObservable(Observable<Paint> strokePaintObservable) {
        if (strokePaintObservable != null) {
            this.strokePaintObservable = strokePaintObservable;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setStrokeObservable(Observable<Stroke> strokeObservable) {
        if (strokeObservable != null) {
            this.strokeObservable = strokeObservable;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setShapeSidesObservable(Observable<Integer> shapeSidesObservable) {
        if (shapeSidesObservable != null) {
            this.shapeSidesObservable = shapeSidesObservable;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setFontObservable(Observable<Font> fontObservable) {
        if (fontObservable != null) {
            this.fontObservable = fontObservable;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setFillPaintObservable(Observable<Optional<Paint>> fillPaintObservable) {
        this.fillPaintObservable = fillPaintObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setEraseColorObservable(Observable<Optional<Color>> eraseColorObservable) {
        this.eraseColorObservable = eraseColorObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setIntensityObservable(Observable<Double> intensityObservable) {
        this.intensityObservable = intensityObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setDrawMultipleObservable(Observable<Boolean> drawMultipleObservable) {
        this.drawMultipleObservable = drawMultipleObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setDrawCenteredObservable(Observable<Boolean> drawCenteredObservable) {
        this.drawCenteredObservable = drawCenteredObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setCornerRadiusObservable(Observable<Integer> cornerRadiusObservable) {
        this.cornerRadiusObservable = cornerRadiusObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setConstrainedAngleObservable(Observable<Integer> constrainedAngleObservable) {
        this.constrainedAngleObservable = constrainedAngleObservable;
    }

    /** {@inheritDoc} */
    @Override
    public void setAntiAliasingObservable(Observable<Interpolation> antiAliasingObservable) {
        this.antiAliasingObservable = antiAliasingObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Optional<Paint>> getFillPaintObservable() {
        return fillPaintObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Optional<Color>> getEraseColorObservable() {
        return eraseColorObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Stroke> getStrokeObservable() {
        return strokeObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Paint> getStrokePaintObservable() {
        return strokePaintObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Integer> getShapeSidesObservable() {
        return shapeSidesObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Font> getFontObservable() {
        return fontObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Color> getFontColorObservable() {
        return fontColorObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Double> getIntensityObservable() {
        return intensityObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Boolean> getDrawCenteredObservable() {
        return drawCenteredObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Boolean> getDrawMultipleObservable() {
        return drawMultipleObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Integer> getCornerRadiusObservable() {
        return cornerRadiusObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Integer> getConstrainedAngleObservable() {
        return constrainedAngleObservable;
    }

    /** {@inheritDoc} */
    @Override
    public Observable<Interpolation> getAntiAliasingObservable() {
        return antiAliasingObservable;
    }

}

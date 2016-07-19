/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.captcha;

import com.octo.captcha.component.image.color.ColorGenerator;
import java.awt.Color;

/**
 *
 * @author German17
 */
public class CaptchaColorGenerator implements ColorGenerator {

    private static final int MIN_COLOR = 5;
    private static final int MAX_COLOR = 255;
    private static final int MIN_ALPHA = 50;
    private static final int MAX_ALPHA = 150;

    @Override
    public Color getNextColor() {
        return new Color(getRandomColorValue(), getRandomColorValue(), getRandomColorValue(), getRandomAlphaValue());
    }

    private int getRandomColorValue() {
        return (int) (((MAX_COLOR - (double) MIN_COLOR) * Math.random()) + MIN_COLOR);
    }

    private int getRandomAlphaValue() {
        return (int) ((((double) MAX_ALPHA - (double) MIN_ALPHA) * Math.random()) + MIN_ALPHA);
    }
}

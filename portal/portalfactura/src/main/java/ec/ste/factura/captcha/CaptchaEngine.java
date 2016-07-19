/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.captcha;

import java.awt.Color;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FunkyBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.TwistedAndShearedRandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.BaffleTextDecorator;
import com.octo.captcha.component.image.textpaster.textdecorator.LineTextDecorator;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory; 

/**
 *
 */
public class CaptchaEngine extends ListImageCaptchaEngine {

    @Override
    protected void buildInitialFactories() {
        /**
         * Set Captcha Word Length Limitation which should not over 6
         */
        Integer minAcceptedWordLength = Integer.valueOf(4);


        Integer maxAcceptedWordLength = Integer.valueOf(4);


        Integer imageHeight = Integer.valueOf(60);


        Integer imageWidth = Integer.valueOf(150);


        Integer minFontSize = Integer.valueOf(30);


        Integer maxFontSize = Integer.valueOf(40);


        WordGenerator wordGenerator = new RandomWordGenerator(
                "a5bcde6fghj3kmn7pqr4stu8vwx9yz2");



        Color[] colors = new Color[]{
            new Color(234, 234, 234), Color.WHITE, new Color(92, 192, 255)
        };
        RandomListColorGenerator colorGenerator = new RandomListColorGenerator(colors);



        BackgroundGenerator backgroundGenerator = new FunkyBackgroundGenerator(imageWidth, imageHeight, colorGenerator);


        FontGenerator fontGenerator = new TwistedAndShearedRandomFontGenerator(minFontSize, maxFontSize);

        colors = new Color[]{
            new Color(0, 0, 0),
            new Color(0, 0, 150),
            new Color(0, 150, 0),
            new Color(150, 0, 0)
        };
        colorGenerator = new RandomListColorGenerator(colors);


        CaptchaColorGenerator captchaColorGenerator1 = new CaptchaColorGenerator();
        CaptchaColorGenerator captchaColorGenerator2 = new CaptchaColorGenerator();



        TextDecorator td[] = new TextDecorator[]{
            new BaffleTextDecorator(1, captchaColorGenerator1),
            new LineTextDecorator(1, captchaColorGenerator2)};

        TextPaster textPaster = new DecoratedRandomTextPaster(minAcceptedWordLength, maxAcceptedWordLength, colorGenerator, false, td);
        WordToImage wordToImage = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster);

        addFactory(new GimpyFactory(wordGenerator, wordToImage));
    }
}
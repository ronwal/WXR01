/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.captcha;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaServiceSingleton {

	private static final DefaultManageableImageCaptchaService instance = new DefaultManageableImageCaptchaService();
        
        static{
            instance.setCaptchaEngine(new CaptchaEngine());
        }
                

	public static ImageCaptchaService getInstance() {
		return instance;
	}
}

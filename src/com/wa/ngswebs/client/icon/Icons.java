package com.wa.ngswebs.client.icon;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

@SuppressWarnings("deprecation")
public interface Icons extends ImageBundle {
	
	@Resource("user.png")
	AbstractImagePrototype user();

	@Resource("user_kid.png")
	AbstractImagePrototype userKid();

	@Resource("user_female.png")
	AbstractImagePrototype userFemale();
	
	@Resource("bulletsidemenu.png")
	AbstractImagePrototype bulletSideMenu();
	
	@Resource("inlinemediumbanner2.png")
	AbstractImagePrototype inlineBanner();
	
	@Resource("new2.jpg")
	AbstractImagePrototype new2();
	
	@Resource("aboutus_banner.jpg")
	AbstractImagePrototype aboutUs();
	
	@Resource("image.JPG")
	AbstractImagePrototype image();
}

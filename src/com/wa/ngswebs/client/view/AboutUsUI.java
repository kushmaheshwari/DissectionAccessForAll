package com.wa.ngswebs.client.view;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.wa.ngswebs.client.icon.Resources;

public class AboutUsUI extends ContentPanel {
	private AbstractImagePrototype image;
	private Label label;

	public AboutUsUI() {
		setScrollMode(Scroll.AUTO);
		setId("centerPanelBackground");
		setStyleName("centerPanelPadding");
		addStyleName("uiContainer");
		setHeaderVisible(false);

		image = Resources.ICONS.image();
		add(image.createImage());

		String text = "<br><center><font color='orange' size='5px'>About US</font></center>";
		text += "<h2>About Us details here</h2> ";

		label = new Label();
		label.setText(text);
		add(label);

	}
}

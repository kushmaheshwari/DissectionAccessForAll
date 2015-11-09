package com.wa.ngswebs.client.view;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.wa.ngswebs.client.icon.Resources;

public class CowEyeDissectionUI extends ContentPanel {

	private ContentPanel videoPanel;
	private AbstractImagePrototype image;
	private Label label;

	public CowEyeDissectionUI() {
		setScrollMode(Scroll.AUTO);
		setId("centerPanelBackground");
		addStyleName("uiContainer");
		setHeaderVisible(false);

		image = Resources.ICONS.image();
		add(image.createImage());

		String text = "<br><center><font color='orange' size='5px'>Cow Eye Dissection</font></center>";
		text += "<h2>Cow Eye Disection Details here  </h2> ";
		label = new Label();
		label.setText(text);
		add(label);

		videoPanel = new ContentPanel();
		videoPanel.setId("jwplayer");
		videoPanel.setHeaderVisible(false);
		videoPanel.setBodyBorder(false);
		add(videoPanel);

		Timer timer = new Timer() {

			@Override
			public void run() {
				loadVideoPlayer();
			}
		};

		timer.schedule(50);
	}

	private void loadVideoPlayer() {
		if (GXT.isGecko) {
			PlayVideo("https://s3.amazonaws.com/temptxt/big_buck_bunny.ogv");
		} else if (GXT.isIE) {
			PlayVideo("https://s3.amazonaws.com/temptxt/Uqmy.mp4");
		} else if (GXT.isChrome) {
			PlayVideo("https://s3.amazonaws.com/temptxt/Uqmy.mp4");
		} else {
			PlayVideo("https://s3.amazonaws.com/temptxt/big_buck_bunny.ogv");
		}
	}

	public native void PlayVideo(String pLink) /*-{
		$wnd.JWPlayer(pLink);
	}-*/;
}

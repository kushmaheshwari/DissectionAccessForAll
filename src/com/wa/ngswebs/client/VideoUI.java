package com.wa.ngswebs.client;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.button.Button;

public class VideoUI extends ContentPanel {

	private Button mp4Button;
	private Button ogvButton;
	private ContentPanel videoPanel;
	private Label infoLabel;
	
	public VideoUI() {
		setScrollMode(Scroll.AUTO);
		setHeading("Video UI");
		setId("centerPanelBackground");
		setStyleName("centerPanelPadding");
		addStyleName("uiContainer");
		
		mp4Button = new Button("MP4 Video");
		infoLabel = new Label("Play Video From Amazon S3");
		infoLabel.setStyleAttribute("margin", "10px");
		
		mp4Button.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				if(GXT.isGecko){
					infoLabel.setText("mp4 format video not supported with JWPlayer in FF");
				}else{
					infoLabel.setText("You are watching MP4 Video.");
				}
				PlayVideo("https://s3.amazonaws.com/temptxt/Uqmy.mp4");
			}
		});
		
	    ogvButton = new Button("OGV Video");
	    
	    ogvButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(GXT.isIE){
					infoLabel.setText("ovg format video not supported with JWPlayer in IE");
				}else{
					infoLabel.setText("You are watching OGV Video.");
				}
				
				PlayVideo("https://s3.amazonaws.com/temptxt/big_buck_bunny.ogv");
			}
		});
	    
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setSpacing(10);
	    
	    hPanel.add(mp4Button);
	    hPanel.add(ogvButton);
	    add(hPanel);
	    
	    videoPanel = new ContentPanel();
	    videoPanel.setId("jwplayer");
		videoPanel.setHeaderVisible(false);
		videoPanel.setBodyBorder(false);
		add(infoLabel);
		add(videoPanel);
	}
	
	public native void PlayVideo(String pLink) /*-{
	$wnd.JWPlayer(pLink);
	}-*/;
}

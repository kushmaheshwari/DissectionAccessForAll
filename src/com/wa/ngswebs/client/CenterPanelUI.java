package com.wa.ngswebs.client;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class CenterPanelUI extends ContentPanel{

	private Label homeLabel;
	private Label aboutUsLabel;
	private Label contactUsLabel;
	
	public CenterPanelUI() {
		setHeaderVisible(false);
		setBodyBorder(false);
		setScrollMode(Scroll.NONE);
		setLayout(new FitLayout());
		
		homeLabel = new Label("Home");
		aboutUsLabel = new Label("About Us");
		contactUsLabel = new Label("Contact Us");
		
		ToolBar toolBar = new ToolBar();
		toolBar.setStyleName("toolBar");
		toolBar.setHeight(26);
		toolBar.setWidth("90%");
		
		toolBar.add(homeLabel);
		toolBar.add(aboutUsLabel);
		toolBar.add(contactUsLabel);
	    setTopComponent(toolBar);
	}
	
	public Label getHomeLabel() {
		return homeLabel;
	}
	
	public Label getAboutUsLabel() {
		return aboutUsLabel;
	}
	
	public Label getContactUsLabel() {
		return contactUsLabel;
	}
}

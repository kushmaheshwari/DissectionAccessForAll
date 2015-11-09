package com.wa.ngswebs.client;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class MainPanelUI extends ContentPanel {
	private BorderLayoutData leftData;
	private BorderLayoutData centerData;
	private BorderLayoutData rightData;
	
	private HeaderPanelUI headerPanelUI;
	private LeftPanelUI leftPanelUI;
	private CenterPanelUI centerPanelUI;
	
	@SuppressWarnings("unused")
	private UIHandler uiHandler;
	
	public MainPanelUI() {
		setHeaderVisible(false);
		setStyleName("mainPanel");
		setHeight(850);
		BorderLayout layout = new BorderLayout();
	    setLayout(layout);
	   
	    headerPanelUI = new HeaderPanelUI();
		
		BorderLayoutData headerData = new BorderLayoutData(LayoutRegion.NORTH, 100);
		headerData.setCollapsible(false);
		headerData.setHideCollapseTool(true);
		headerData.setFloatable(true); 
		
		leftPanelUI = new LeftPanelUI();
		leftData = new BorderLayoutData(LayoutRegion.WEST, 243);
		leftData.setCollapsible(true);
		leftData.setSplit(false);
		
		ContentPanel dummyRightPanel = new ContentPanel();
		dummyRightPanel.setHeaderVisible(false);
		dummyRightPanel.setBodyBorder(false);
		dummyRightPanel.setBorders(false);
		
		rightData = new BorderLayoutData(LayoutRegion.EAST, 20);
		rightData.setCollapsible(false);
		rightData.setSplit(false);
		
		centerPanelUI = new CenterPanelUI();
		centerData = new BorderLayoutData(LayoutRegion.CENTER);
		
		add(headerPanelUI, headerData);
		add(leftPanelUI, leftData);
		add(centerPanelUI, centerData);
		add(dummyRightPanel, rightData);
		
		uiHandler = new UIHandler(headerPanelUI, leftPanelUI, centerPanelUI);
	}
	
}

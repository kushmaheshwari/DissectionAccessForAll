package com.wa.ngswebs.client;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.ui.FlowPanel;

public class HeaderPanelUI extends ContentPanel{
	
	public HeaderPanelUI() {
		setLayout(new FlowLayout());
		setMonitorWindowResize(true);
		setHeaderVisible(false);
		setBorders(false);
		setBodyBorder(false);
		
		FlowPanel leftPanel = new FlowPanel();
		leftPanel.getElement().setId("logo");
		add(leftPanel, new FlowData(0, 0, 0, 10));
	}
}

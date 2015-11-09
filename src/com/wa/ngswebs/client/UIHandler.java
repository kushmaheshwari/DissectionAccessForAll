package com.wa.ngswebs.client;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.wa.ngswebs.client.view.AboutUsUI;
import com.wa.ngswebs.client.view.CatDissectionSPUI;
import com.wa.ngswebs.client.view.CatDissectionUI;
import com.wa.ngswebs.client.view.ContactUsUI;
import com.wa.ngswebs.client.view.CowEyeDissectionSPUI;
import com.wa.ngswebs.client.view.CowEyeDissectionUI;
import com.wa.ngswebs.client.view.HomeUI;
import com.wa.ngswebs.client.view.TeachersUI;
import com.wa.ngswebs.shared.StaticData;

public class UIHandler {
	
	private HomeUI homeUI;
	private AboutUsUI aboutUsUI;
	private ContactUsUI contactUsUI;
	private CowEyeDissectionUI cowEyeDissectionUI;
	private CowEyeDissectionSPUI cowEyeDissectionSPUI;
	private CatDissectionUI catDissectionUI;
	private CatDissectionSPUI catDissectionSPUI;
	private TeachersUI teachersUI;
	private VideoUI videoUI;
	
	@SuppressWarnings("unused")
	private HeaderPanelUI headerPanelUI;
	private LeftPanelUI leftPanelUI;
	private CenterPanelUI centerPanelUI;
	
	public UIHandler(HeaderPanelUI pHeaderPanelUI,LeftPanelUI pLeftPanelUI,CenterPanelUI pCenterPanelUI) {
		this.headerPanelUI = pHeaderPanelUI;
		this.leftPanelUI = pLeftPanelUI;
		this.centerPanelUI = pCenterPanelUI;
		regsiterEvents();
		loadHomeUI();
	}

	private void regsiterEvents() {
		leftPanelUI.getTreePanel().addListener(Events.OnClick, new Listener<TreePanelEvent<ModelData>>() {

			@Override
			public void handleEvent(TreePanelEvent<ModelData> be) {
				if(be.getItem().get("name").equals(StaticData.HOME)){
					loadHomeUI();
				}else if(be.getItem().get("name").equals(StaticData.COW_EYE_DISSECTION)){
					loadCowEyeDissectionUI();
				}else if(be.getItem().get("name").equals(StaticData.COW_EYE_DISSECTION_SP)){
					loadCowEyeDissectionSPUI();
				}else if(be.getItem().get("name").equals(StaticData.CAT_DISSECTION)){
					loadCatDissectionUI();
				}else if(be.getItem().get("name").equals(StaticData.CAT_DISSECTION_SP)){
					loadCatDissectionSPUI();
				}else if(be.getItem().get("name").equals(StaticData.TEACHERS)){
					loadTeachersUI();
				}else if(be.getItem().get("name").equals(StaticData.VIDEO_UI)){
					loadVideoUI();
				}
			}
		});
		
		centerPanelUI.getHomeLabel().addListener(Events.OnClick, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {
				loadHomeUI();
			}
		});
		
		centerPanelUI.getAboutUsLabel().addListener(Events.OnClick, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {
				loadAboutUsUI();
			}
		});
		
		centerPanelUI.getContactUsLabel().addListener(Events.OnClick, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {
				loadContactUsUI();
			}
		});
		
	}
	
	protected void loadContactUsUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(contactUsUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							contactUsUI = new ContactUsUI();
							loadContentPanel(contactUsUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(contactUsUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);
		
	}

	protected void loadAboutUsUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(aboutUsUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							aboutUsUI = new AboutUsUI();
							loadContentPanel(aboutUsUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(aboutUsUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);
	}

	protected void loadTeachersUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(teachersUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							teachersUI = new TeachersUI();
							loadContentPanel(teachersUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(teachersUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);
	}

	protected void loadCatDissectionSPUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(catDissectionSPUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							catDissectionSPUI = new CatDissectionSPUI();
							loadContentPanel(catDissectionSPUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(catDissectionSPUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);
	}

	protected void loadCatDissectionUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(catDissectionUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							catDissectionUI = new CatDissectionUI();
							loadContentPanel(catDissectionUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(catDissectionUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);
	}

	protected void loadCowEyeDissectionSPUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(cowEyeDissectionSPUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							cowEyeDissectionSPUI = new CowEyeDissectionSPUI();
							loadContentPanel(cowEyeDissectionSPUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(cowEyeDissectionSPUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);

	}

	protected void loadCowEyeDissectionUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(cowEyeDissectionUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							cowEyeDissectionUI = new CowEyeDissectionUI();
							loadContentPanel(cowEyeDissectionUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(cowEyeDissectionUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);

	}

	protected void loadHomeUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(homeUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							homeUI = new HomeUI();
							loadContentPanel(homeUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(homeUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);
	}

	protected void loadVideoUI() {
		centerPanelUI.mask("Loading...");
		
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				if(videoUI == null){
					RunAsyncCallback callback = new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							videoUI = new VideoUI();
							loadContentPanel(videoUI);
							centerPanelUI.unmask();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							centerPanelUI.unmask();
							Window.alert("Failed to load UI..Try Again!");
						}
					};
					GWT.runAsync(callback);
				}else{
					loadContentPanel(videoUI);
					centerPanelUI.unmask();
				}
			}
		};
		timer.schedule(100);
	}
	
	private void loadContentPanel(Widget widget) {
		centerPanelUI.removeAll();
		centerPanelUI.add(widget);
		centerPanelUI.layout();
	}
	
}

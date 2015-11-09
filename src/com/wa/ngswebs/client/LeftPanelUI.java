package com.wa.ngswebs.client;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.wa.ngswebs.client.icon.Resources;
import com.wa.ngswebs.shared.StaticData;

public class LeftPanelUI extends ContentPanel{
	
	private TreeStore<ModelData> treeStore;
	private TreePanel<ModelData> treePanel;
	
	public LeftPanelUI() {
		setHeaderVisible(false);
		setBodyBorder(false);
		setScrollMode(Scroll.NONE);
		setLayout(new FitLayout());
		
		ContentPanel contentPanel = new ContentPanel();
		VBoxLayout vBoxLayout = new VBoxLayout();
		vBoxLayout.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
		contentPanel.setLayout(vBoxLayout);
		contentPanel.setStyleName("leftPanel");
		contentPanel.addStyleName("uiContainer");
		contentPanel.setWidth("100%");
		
		treeStore = new TreeStore<ModelData>();
		treePanel = new TreePanel<ModelData>(treeStore);
		treePanel.setDisplayProperty("name");
		treePanel.setStyleName("leftTreePanel");
		treePanel.setIconProvider(new ModelIconProvider<ModelData>() {
			
			@Override
			public AbstractImagePrototype getIcon(ModelData model) {
					return Resources.ICONS.bulletSideMenu();
			}
		});
		
		ModelData m = newItem(StaticData.HOME, null);  
		treeStore.add(m, false); 
		
		m = newItem(StaticData.COW_EYE_DISSECTION, null);
		treeStore.add(m,false);
		
		m = newItem(StaticData.COW_EYE_DISSECTION_SP, null);
		treeStore.add(m,false);
		
		m = newItem(StaticData.CAT_DISSECTION, null);
		treeStore.add(m,false);
		
		m = newItem(StaticData.CAT_DISSECTION_SP, null);
		treeStore.add(m,false);
		
		m = newItem(StaticData.TEACHERS, null);
		treeStore.add(m,false);
		
//		m = newItem(StaticData.VIDEO_UI, null);
//		treeStore.add(m,false);
		
		contentPanel.add(treePanel, new VBoxLayoutData(0, 0, 0, 5));
		add(contentPanel);
	}
	
	private ModelData newItem(String text, String iconStyle) {
		ModelData m = new BaseModelData();
		m.set("name", text);
		m.set("icon", iconStyle);
		return m;
	}
	
	public TreeStore<ModelData> getTreeStore() {
		return treeStore;
	}
	
	public TreePanel<ModelData> getTreePanel() {
		return treePanel;
	}
}

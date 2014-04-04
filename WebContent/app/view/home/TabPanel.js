Ext.define('FRIUT.view.home.TabPanel', {
	extend : 'Ext.tab.Panel',
	alias : 'widget.layouttabpanel',
	
	id : 'content-panel',
	region: 'center', 
	autoScroll : false,
	bodyPadding : 0,
	activeTab : 0,
	border: true,
	frame: false,
	
	items : [ {
		id : 'HomePage',
		title : TITLE.home_page,
		iconCls : 'icon-app-home',
		layout : 'fit',
		items: [{
			//xtype: 'stockanalytic'
		}]
	}]
});
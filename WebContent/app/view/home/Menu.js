Ext.define('FRIUT.view.home.Menu', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.layoutmenu',

	region: 'west',
	
    width: 180,
    height: 300,
    title: TITLE.menu,
    iconCls: 'icon-menu',
    
    minSize: 130,
	maxSize: 300,
    containerScroll: true,
	collapsible: true,
	autoScroll: false,
	
	border: true,
	split: true,
	enableDD: false,
    
    layout: {
        // layout-specific configs go here
        type: 'accordion',
        titleCollapse: true,
        animate: false,
        activeOnTop: false
    },
    items: [{
        title: '股票分析',
        id:'stock',
        iconCls: 'icon-game',
        xtype: 'treepanel',
    	store: 'TreeMenus',
    	bodyStyle: "padding:5 5 5 5",
    	rootVisible: false,
    	
	    listeners: {
	    	'beforeexpand': function(view) {
	    		this.store.proxy.extraParams={parentId:'stock'};
	    		this.store.reload();
	        },
	        
	        'itemmousedown': function(selModel, record) {
	        	loadMenu(selModel, record);
	        }
	    }
    }]
    
	/**
	store: 'TreeMenus',

	region: 'west',
	width: 180,
	
	bodyStyle: "padding:5 5 5 5",

	title: TITLE.menu,
	iconCls: 'icon-menu',
	margins: '0 1 -1 1',

	border: true,
	split: true,
	enableDD: false,

	minSize: 130,
	maxSize: 300,
	rootVisible: false,
	containerScroll: true,
	collapsible: true,
	autoScroll: false
	**/
});

loadMenu = function(selModel, record) {
	var tabs = Ext.getCmp("content-panel");
	var tab = tabs.getComponent(record.get('id'));
	
	if (record.get('leaf')) {
		if (!tab) {
			tabs.add({
				id : record.get('id'),
				closable : true,
				title : record.get('text'),
				iconCls : record.get('iconCls'),
				layout : 'fit',
				xtype : record.get('id')
			}).show();
		} else {
			tabs.setActiveTab(tab);
		}
	} else {
		var expand = record.get('expanded');
		if (expand) {
			selModel.collapse(record);
		} else {
			selModel.expand(record);
		}
	}
}; 
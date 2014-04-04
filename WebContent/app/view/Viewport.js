Ext.define('FRIUT.view.Viewport', {
    extend: 'Ext.container.Viewport',

    layout: 'border',
   	hideBorders : true,
	
    items : [{
		xtype : 'layoutheader'
	}, {
		xtype : 'layoutbottom'
	}, {
		xtype : 'layouttabpanel'
	}, {
		xtype : 'layoutmenu'
	}]
});
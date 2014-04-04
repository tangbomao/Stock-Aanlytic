Ext.define('FRIUT.store.TreeMenus', {
	extend : 'Ext.data.TreeStore',
	
	model : 'FRIUT.model.TreeMenu',
	autoLoad: true,
	
	proxy : {
		type : 'ajax',
		url : 'menu_tree.action',
		// Send first menu parentId
		extraParams : {
			parentId : GLOBAL.PARENT_ID
		}
	}
});
Ext.define('FRIUT.model.TreeMenu', {
	extend : 'Ext.data.Model',
	
    requires: [
        'Ext.data.reader.Json'
    ],
	
	fields : [ 'id', 'text', 'iconCls']
});
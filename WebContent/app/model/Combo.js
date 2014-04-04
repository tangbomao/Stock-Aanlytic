Ext.define('FRIUT.model.Combo', {
	extend : 'Ext.data.Model',
	
    requires: [
        'Ext.data.reader.Json'
    ],
	
	fields : [ 'display', 'value']
});
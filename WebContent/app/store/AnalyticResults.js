Ext.define('FRIUT.store.AnalyticResults', {
	extend : 'Ext.data.Store',
	
	model : 'FRIUT.model.AnalyticResult',
	autoLoad: true,
	
	proxy : {
		type : 'ajax',
		url : 'stock_result.action',
		extraParams : {
			relativePlus : 1.5,
			riseDayPlus : 0.6
		},
		
		reader: {
	         type: 'json',
	         root: 'items',
	         totalProperty: 'count',
	         successProperty: 'success'
	     }
	}
});
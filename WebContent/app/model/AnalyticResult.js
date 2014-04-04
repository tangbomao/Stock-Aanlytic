Ext.define('FRIUT.model.AnalyticResult', {
	extend : 'Ext.data.Model',
	
    requires: [
        'Ext.data.reader.Json'
    ],
	
	fields : [ 'stockName', 'volume', 'totalVolume', 'relativePlus', 'riseDay', 'analyticDay', 'riseDayPlus']
});
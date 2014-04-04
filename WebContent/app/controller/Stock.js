var analyticResultStore = Ext.create('FRIUT.store.AnalyticResults');

Ext.define('FRIUT.controller.Stock', {
	extend: 'Ext.app.Controller',
    
	stores : [ 'AnalyticResults@FRIUT.store'],
	
	models : [ 'AnalyticResult@FRIUT.model' ],
	
	views: [ 'List@FRIUT.view.stock' ],
      
    refs: [  
         {ref: 'stockAnalytic', selector: 'stockanalytic'}
    ],
    
    init: function() {
        this.control({
        	'stockanalytic': {
        		cellclick: function(view, td, cellIndex, record) {
                    if (cellIndex == 0) {
                    	var stockName = record.get('stockName');
            			var code = stockName.split(".")[1] + stockName.split(".")[0];
                    	window.open("http://quote.eastmoney.com/" + code + ".html");
                    }
                }
        	}
        });
    }
});
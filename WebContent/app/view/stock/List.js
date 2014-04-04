var dwonloadProgressBar;
var analyticProgressBar;

var TaskRunner = new Ext.util.TaskRunner();
var downloadtask = {
    run : function() {
    	Ext.Ajax.request({
            url: 'stock_downloadState.action',
            success : function(response) {
                var responseJson = Ext.JSON.decode(response.responseText);
                var count = responseJson.downloadCount;
                var totalCount = responseJson.totalCount;

                var curnum = count / totalCount;
				bartext = Math.round(curnum * 1000)/10 + "%";
				dwonloadProgressBar.updateProgress(curnum, bartext);
            }
    	});
    },
    interval: 1000
};

var analytictask = {
	    run : function() {
	    	Ext.Ajax.request({
	            url: 'stock_analyticState.action',
	            success : function(response) {
	                var responseJson = Ext.JSON.decode(response.responseText);
	                var count = responseJson.analyticCount;
	                var totalCount = responseJson.totalCount;

	                var curnum = count / totalCount;
					bartext = Math.round(curnum * 1000)/10 + "%";
					dwonloadProgressBar.updateProgress(curnum, bartext);
	            }
	    	});
	    },
	    interval: 1000
	};

Ext.define('FRIUT.view.stock.List' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.stockanalytic',

    store: analyticResultStore,
    columns: [
        {header: '股票', dataIndex: 'stockName',  flex: 1},
        {header: '分析天数', dataIndex: 'analyticDay',  flex: 1},
        {header: '上涨天数', dataIndex: 'riseDay',  flex: 1},
        {header: '上涨天数比', dataIndex: 'riseDayPlus',  flex: 1},
        {header: '成交量', dataIndex: 'volume',  flex: 1},
        {header: '总成交量', dataIndex: 'totalVolume',  flex: 1},
        {header: '均量量比', dataIndex: 'relativePlus',  flex: 1}
    ],
    
    dockedItems: [{
	    xtype: 'pagingtoolbar',
	    store: analyticResultStore,
	    dock: 'bottom',
	    displayInfo: true
    }],
    

    tbar : [{
		xtype : 'numberfield',
		id : 'riseDayPlus',
		fieldLabel: '上涨天数比',
		value: 0.6
	}, {
		xtype : 'numberfield',
		id : 'relativePlus',
		fieldLabel: '均量量比大于',
		value: 1.5
	}, {
		xtype : 'button',
		text : BTN.search,
		iconCls : 'icon-search',
		handler : function() {
			var riseDayPlus = Ext.getCmp('riseDayPlus').value;
			var relativePlus = Ext.getCmp('relativePlus').value;
			analyticResultStore.proxy.extraParams = {
				riseDayPlus : riseDayPlus,
				relativePlus : relativePlus
			};
			analyticResultStore.reload();
		}
	}, '->', {
		xtype : 'button',
		text : BTN.download,
		iconCls : 'icon-download',
		handler : function() {
			dwonloadProgressBar = Ext.Msg.show({
				title : "进度条",
				msg : "股票数据下载中...",
				progress : true,
				width : 300
			});
			
			Ext.Ajax.request({
	            url: 'stock_download.action',
	            success : function(response) {
	            	TaskRunner.start(downloadtask);
	            }
	    	});
		}
	}, {
		xtype : 'button',
		text : BTN.analytic,
		iconCls : 'icon-analytic',
		handler : function() {
			Ext.Ajax.request({
	            url: 'stock_analytic.action',
	            success : function(response) {
	            	TaskRunner.start(analytictask);
	            }
	    	});
		}
	}],
});
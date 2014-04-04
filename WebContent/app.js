Ext.onReady(function(){
	Ext.application({
		name: 'FRIUT',
		appFolder: 'app',
		
		controllers: [
	        'Main',
	        'Stock'
	    ],
		launch : function() {
			Ext.create('FRIUT.view.Viewport');
		}
	});
});
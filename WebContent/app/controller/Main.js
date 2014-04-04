Ext.define('FRIUT.controller.Main', {
	extend: 'Ext.app.Controller',
    
	stores : [ 'TreeMenus@FRIUT.store', 'ComboYesNo@FRIUT.store'],
	
	models : [ 'TreeMenu@FRIUT.model', 'Combo@FRIUT.model' ],
	
	views: [ 'Header@FRIUT.view.home', 
			'Menu@FRIUT.view.home', 
			'Bottom@FRIUT.view.home', 
			'TabPanel@FRIUT.view.home'],
      
    refs: [  
         {ref: 'layoutMenu', selector: 'layoutmenu'},  
         {ref: 'layoutHeader', selector: 'layoutheader'},  
         {ref: 'layoutBottom', selector: 'layoutbottom'},  
         {ref: 'layoutTabPanel', selector: 'layouttabpanel'}
    ],
    
    init: function() {
        this.control({
        	
        });
    }
});
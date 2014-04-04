var APP = {
	name : '<font size ="20" color="green">淘书房</font>',
	welcome : '欢迎访问淘书坊',
	support : '技术支持:<a href=\'http://www.arthurcn.com/\' target=\'_blank\' style=\'text-decoration:none;\'><font color=\'#0000FF\'>杭州亚瑟网络科技</font></a>&nbsp;&nbsp;\''
};

var BTN = {
	download : '下载',
	analytic : '分析',
	login : '登陆',
	logout : '注销',
	reg : '注册',
	add : '新增',
	edit : '编辑',
	save : '保存',
	del : '删除',
	refresh : '刷新',
	search : '搜索',
	user_info : '个人信息',
	cancel : '取消',
	reset : '重置',
	confirm : '确定',
	quick_add : '快速新增',
	save_chart_online_count : '保存在线数据图表',
	save_chart_consume : '保存消费数据图表'
};

var TITLE = {
	confirm : '确认',
	tip : '提示',
	warn : '警告',
	success : '操作成功',
	failure : '操作失败',

	login : '欢迎登录',
	logout : '退出登录',
	reg : '账号注册',
	menu : '功能菜单',
	menu_manage : '菜单设置',
	menu_add : '新增菜单',
	menu_edit : '编辑菜单',
	menu_del : '删除菜单',
	css_add : '新增样式',
	css_edit : '编辑样式',
	css_del : '删除样式',
	user_add : '新增样式',
	user_edit : '编辑样式',
	user_del : '删除样式',
	reward_manage : '活动奖励配置',
	reward_add : '新增活动奖励配置',
	reward_edit : '编辑活动奖励配置',
	reward_del : '删除活动奖励配置',
	server_manage : '服务器管理',
	server_add : '新增服务器',
	server_edit : '编辑服务器',
	server_del : '删除服务器',
	activity_manage : '运营活动管理',
	activity_add : '新增运营活动',
	activity_edit : '编辑运营活动',
	activity_del : '删除运营活动',
	activity_step_manage : '运营活动步骤管理',
	activity_step_add : '新增运营活动步骤',
	activity_step_edit : '编辑运营活动步骤',
	activity_step_del : '删除运营活动步骤',
	activity_reward_manage : '运营活动奖励管理',
	activity_reward_add : '新增运营活动奖励',
	activity_reward_edit : '编辑运营活动奖励',
	activity_reward_del : '删除运营活动奖励',
	home_page : '主页',
	item_send : '道具发送',
	distribution_level : '等级分布',
	log_operate : '运营日志',
	chart_operate : '运营数据分析'
};

var LABEL = {
	account : '账号',
	password : '密码',
	menu_parent : '上级菜单',
	menu_name : '菜单名称',
	menu_id : '菜单ID',
	menu_css : 'CSS图标',
	css : 'CSS',
	css_type : 'CSS类型',
	desc : '描述',
	type : '类型',
	keyword : '关键字',
	item_type : '道具类型',
	item : '道具',
	amount : '数量',
	activity : '活动',
	step : '阶段',
	ratio : '概率',
	activity_id : '活动ID',
	name : '名称',
	content : '具体内容',
	start_time : '开始时间',
	end_time : '结束时间',
	start_day : '开始日期',
	end_day : '结束日期',
	start_month : '开始月份',
	end_month : '结束月份',
	reward_start_time : '奖励开始时间',
	reward_end_time : '奖励结束时间',
	reward_type : '奖励类型',
	button_type : '显示按钮',
	idx : '界面序号',
	is_valid : '是否有效',
	param_value : '参数值',
	param_key : '参数',
	explain : '说明',
	day : '日期',
	check_func : '检查函数',
	reward_desc : '奖励描述',
	reward_num : '奖励领取次数',
	server_name : '当前服务器',
	ip_address : 'IP地址',
	port : '端口',
	api_key : '密匙',
	version : '版本',
	channel : '频道'
};

var HEADER = {
	edit : '编辑',
	del : '删除',
	step : '步骤管理',
	reward : '奖励管理'
};

var TIPS = {
	empty_username : '请输入用户名',
	empty_password : '请输入密码',
	empty_telephone : '请输入手机号',
	empty_name : '请输入真实姓名',
	empty_combo : '请选择',
	empty_combo_menu : '请选择父菜单',
	empty_combo_type : '请选择类型',
	empty_combo_css : '请选择图标样式',
	empty_combo_item : '可填写道具ID',
	empty_combo_activity : '请选择运营活动',
	empty_combo_server : '请选择服务器',
	empty_combo_version : '请选择版本',
	empty_combo_channel : '请选择频道',

	user_account : '当前用户：',
	logout : '你确定要注销登陆吗？',
	menu_del : '你确定要删除该条菜单吗？',
	css_del : '你确定要删除该条样式吗？',
	reward_del : '你确定要删除该条奖励配置吗？',
	activity_del : '你确定要删除该活动吗？它会自动删除对应的奖励和步骤！',
	server_del : '你确定要删除该服务器吗？'
};

var MESSAGE = {
	failure_connect : '系统连接错误！请刷新页面重新载入，如果还不能解决，请联系技术人员',

	empty_record_chose : '<font color="red">请先选择您要删除的行！<font>'
};

// 申明一些全局变量
var GLOBAL = {
	ACCOUNT : "",
	PARENT_ID : "stock"
};

/**
 * 功能：为全局提供创建Form窗口
 * 
 * @author Tang
 * @version 2013/10/30
 */
FormWnd = Ext.extend(Ext.Window, {
    constructor : function(title, iconCls, frmItem) {
		FormWnd.superclass.constructor.call(this, {
			title : title,
			iconCls: iconCls,
			frame : true,
			reader : this.reader,
			items : frmItem,
			constrainHeader : true
		});
	} 
});

/**
 * 功能：为全局提供Render的方法。
 * 
 * @author Tang
 * @version 2013/10/30
 */
RenderUtil = function() {

	return {
		/**
		 * 功能：render Date 类型的数据。 使用方式：在
		 * ColumnModel中需要显示Date数据的地方：renderer:renderDate('Y-m-d').
		 * 
		 * @param format：如"Y-m-d"
		 */
		date : function(format) {
			return function(v) {
				var JsonDateValue;
				if (Ext.isEmpty(v))
					return '';
				else if (Ext.isEmpty(v.time))
					JsonDateValue = new Date(v);
				else
					JsonDateValue = new Date(v.time);
				return JsonDateValue.format(format || 'Y-m-d H:i:s');
			};
		},
		btnEdit : function() {
			return "<a href='' onclick='return false'><font color='blue'>[编辑]</></a>";
		},
		btnDel : function() {
			return "<a href='' onclick='return false' ><font color='red'>[删除]</></a>";
		},
		btnStep : function() {
			return "<a href='' onclick='return false'><font color='green'>[详细步骤]</></a>";
		},
		btnReward : function() {
			return "<a href='' onclick='return false'><font color='green'>[详细奖励]</></a>";
		},
		cssType : function(value, cellmeta, record) {
			var type = record.get('type');
    		if (type == 1) {
    			return "菜单图标";
    		} else if (type == 2) {
    			return "普通样式";
    		}
    		return "错误类型";
		},
		serverVersion : function(value, cellmeta, record) {
			var value = record.get('version');
    		if (value == 1) {
    			return "页游";
    		} else if (value == 2) {
    			return "手游";
    		}
    		return "无指定";
		},
		serverChannel : function(value, cellmeta, record) {
			var value = record.get('channel');
    		if (value == 1) {
    			return "测试服";
    		} else if (value == 2) {
    			return "国服";
    		} else if (value == 3) {
    			return "韩国";
    		} else if (value == 4) {
    			return "越南";
    		}
    		return "无指定";
		},
		activityType : function(value, cellmeta, record) {
			var value = record.get('type');
    		if (value == 9) {
    			return "页游军资";
    		} else if (value == 10) {
    			return "页游四海";
    		} else if (value == 11) {
    			return "页游次数";
    		} else if (value == 12) {
    			return "页游签到";
    		}
    		return "无指定";
		}
	};
}();

FunctionUtils = function() {
	return {
		activityOpen : function(act) {
			Ext.Ajax.request({
				url: 'activity_open.action',
				params: {
					act: act
				},
				success : function(response) {
					var responseJson = Ext.JSON.decode(response.responseText);
					Ext.Msg.alert(TITLE.success, responseJson.msg);
				},
				failure : function(response) {
					var responseJson = Ext.JSON.decode(response.responseText);
					Ext.Msg.alert(TITLE.failure, responseJson.msg);
				}
			});
		},
		
		downloadChart : function(chart) {
            chart.save({
                type: 'image/png'
            });
		}
	};
}();
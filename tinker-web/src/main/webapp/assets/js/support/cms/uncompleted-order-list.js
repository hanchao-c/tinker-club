var $table, table;
var $payStateSelect, $orderStateSelect;
$(function(){
	$table = $("#data-table");
	$payStateSelect = $("#payState");
	$orderStateSelect = $("#orderState");
	
	//初始化下拉选择框
	initSelect2();
	//初始化table
	initDataTable();
	//初始化表格被选中/撤销选中事件
	initTableSelectedEvent();
	
});

function initSelect2(){
	$payStateSelect.buildSelect2({
		"placeholder": '全部',
		"unselect" : function(){
			table.reload(true);
		},
		"select" : function(){
			table.reload(true);
		}
	});
	$orderStateSelect.buildSelect2({
		"placeholder": '全部',
		"unselect" : function(){
			table.reload(true);
		},
		"select" : function(){
			table.reload(true);
		}
	});
}
/**
 * 初始化table
 */
function initDataTable(){
	table = $table.buildDataTable({
		//显示加载标记
		"processing" : true,
		//数据请求地址
		"url" : "../uncompletedOrders",
		"ajaxData" : function(data){
			data.payStateCode = $payStateSelect.val();
			data.orderStateCode = $orderStateSelect.val();
		},
		//不使用自带的搜索框
		"searching" : false,
		//列展示明细
		"columns" : [ 
			{"data" : null, "defaultContent" : "", "className": "select-checkbox", "orderable" : false},
			{"title" : "订单id", "data" : "orderId", "orderable" : false },
			{"title" : "商品名称", "data" : "productName", "orderable" : false},
			{"title" : "价格", "data" : "amount", "orderable" : false},
			{"title" : "支付状态", "data" : "payState", "orderable" : false, "render" : function(data, type, row, meta){
				return getPayStateExplain(data);
			}},
			{"title" : "订单状态", "data" : "orderState", "orderable" : false, "render" : function(data, type, row, meta){
				return getOrderStateExplain(data);
			}},
			{"title" : "支付次数", "data" : "paymentTimes", "orderable" : false},
			{"title" : "下单时间", "data" : "orderTime", "orderable" : false}
		],
		//checkbox
        "select": {
            "style" :    'multi',		
            "selector": 'td:not(:last-child)'
        },
        //列显示/隐藏按钮
		"buttons": [
        	{
				"extend" : "colvis",
				//不使用文字说明
				"text" : " ",
				//只显示大于第1列的选项 （排除第一列）
				"columns" : ":gt(0)",	
				"className" : "fa fa-lg-more fa-cogs btn-info",
				"postfixButtons" : [ { extend: "colvisRestore", text: "---重置---" } ]
            }
        ]
	});
}

/**
 * 初始化表格被选中/撤销选中事件
 */
function initTableSelectedEvent() {
	//选中事件
	table.on("select", function (e, dt, type, indexes) {
	    if (type === "row" ) {
	    	table.rows(indexes).data().each(function(item, index){
	    		Notification.info("选中第 [ " + (index + 1) + " ] 列, 订单id[  " + item.orderId + " ]");
	    	});
	    }
	});
	//撤销选中事件
	table.on("deselect", function (e, dt, type, indexes) {
	    if (type === "row" ) {
	    	table.rows(indexes).data().each(function(item, index){
	    		Notification.warn("撤销选中第 [ " + (index + 1) + " ] 列, 订单id[  " + item.orderId + " ]");
	    	});
	    }
	});
}

/**
 * 全选
 */
function selectAll() {
	table.rows().select();
}

/**
 * 全不选
 */
function deselectAll() {
	table.rows({"selected" : true}).deselect();
}

/**
 * 按条件选择
 */
function selectByCondition() {
	table.rows().data().each(function(item, index){
		if(item.amount > 15) {
			table.row(index).select();
		}
	});
}

//支付金额统计
function amountSummary() {
	var selectedArray = table.rows({"selected" : true}).data();
	if(selectedArray.length == 0) {
		Notification.warn("请选中至少一行");
		return;
	}
	var summary = 0;
	selectedArray.pluck("amount").each(function(item, index){
		summary += item;
	});
	Notification.info("金额总计为" + summary);
}

function getPayStateExplain(payState) {
	switch(payState) {
		case "SUCCESS":
			return '<span class="badge badge-success">支付成功</span>';
		case "FAIL":
			return '<span class="badge badge-danger">支付失败</span>';
		case "WAITING_FOR":
			return '<span class="badge badge-info">待支付</span>';
		case "CLOSED":
			return '<span class="badge badge-default">支付关闭</span>';
		default : {
		}
	}
}

function getOrderStateExplain(orderState) {
	switch(orderState) {
		case "OPEN":
			return '<span class="badge badge-square badge-success">开启</span>';
		case "STOP":
			return '<span class="badge badge-square badge-info">暂停</span>';
		case "DELAY":
			return '<span class="badge badge-square badge-warn">延时</span>';
		case "CLOSE":
			return '<span class="badge badge-square badge-danger">关闭</span>';
		case "UN_KNOW":
			return '<span class="badge badge-square badge-default">未知</span>';
		default : {
		}
	}
}
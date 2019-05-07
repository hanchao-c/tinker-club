var $table, table;
$(function(){
	$table = $("#data-table");
	//初始化table
	initDataTable();
});

/**
 * 初始化table
 */
function initDataTable(){
	table = $table.buildDataTable({
		//显示加载标记
		"processing" : true,
		//数据请求地址
		"url" : "../payRecords",
		"ajaxData" : function(data){
		},
		//不使用自带的搜索框
		"searching" : false,
		//列展示明细
		"columns" : [
			{"data" : null, "defaultContent" : "<span class='fa fa-plus'></span>", "className" : "details-control", "orderable" : false},
			{"title" : "订单id", "data" : "orderId", "orderable" : false },
			{"title" : "支付金额", "data" : "amount", "orderable" : false},
			{"title" : "支付状态", "data" : "paymentState", "orderable" : false},
			{"title" : "下单时间", "data" : "createTime", "orderable" : false},
			{"title" : "订单类型", "data" : "orderTypeNames", "orderable" : false}
		],
        //列显示/隐藏按钮
		"buttons": [
        	{
				"extend" : "colvis",
				//不使用文字说明
				"text" : " ",
				"className" : "fa fa-lg-more fa-cogs btn-info",
				"postfixButtons" : [ { extend: "colvisRestore", text: "---重置---" } ]
            }
        ]
	});
	
	//表头可点击按钮事件初始化
	$table.on('click', 'td.details-control', function(){
        var $tr = $(this).closest('tr');
        var row = table.row($tr);
        if (row.child.isShown()){
            row.child.hide();
            $tr.removeClass('shown');
            $tr.children("td:first").children("span").removeClass("fa-minus").addClass("fa-plus");
        } else {
            row.child(format(row.data())).show();
            $tr.addClass('shown');
            $tr.children("td:first").children("span").removeClass("fa-plus").addClass("fa-minus");
        }
    });
	
	//自定义format
	function format(data) {
	    return '' +
			'<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
	     	'   <tr>'+
	     	'   	<td>订单id : </td>'+
	     	'   	<td>' + data.orderId + '</td>'+
	     	'   </tr>'+
	     	'   <tr>'+
	     	'   	<td>支付金额 : </td>'+
	     	'   	<td>' + data.amount + '</td>'+
	     	'   </tr>'+
	     	'   <tr>'+
	     	'   	<td>支付状态 : </td>'+
	     	'   	<td>' + data.paymentState + '</td>'+
	     	'   </tr>'+
	     	'   <tr>'+
	     	'   	<td>下单时间 : </td>'+
	     	'   	<td>' + data.createTime + '</td>'+
	     	'   </tr>'+
	     	'   <tr>'+
	     	'   	<td>订单类型 : </td>'+
	     	'   	<td>' + data.orderTypeNames + '</td>'+
	     	'   </tr>'+
	    	'</table>';
	}
}
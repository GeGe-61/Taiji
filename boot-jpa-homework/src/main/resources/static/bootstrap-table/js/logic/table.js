$(document).ready(function() {
	
    // 只写逻辑步骤	
	init();

	$('#btnEdit').bind('click', getSelectedItem);
	
	$('#btnAdd').bind('click',btnAddShow);

	
})


function init()
{
	
	initTable();
	
	initModal();
	
	setSelectorForTable();
	
}


function initTable()
{
	/*
	 * url = /项目名称+文件路径
	 */
	url = '../data/employee.json';
	/*
	 * 1. 数据加载——数据+列的样式
	 * 2.toolbar
	 * 3.分页
	 */
	$('#table').bootstrapTable({
		url: url,
		columns: columns,
		toolbar: '#toolbar',
		striped: true,
		pagination: true, //出现分页
		pageList: [3, 5, 20],
		/*是否分页*/
		pageSize: 2, //页面大小
		pageNumber: 1, //第一页的页码
	});
}


function initModal()
{
	//	<option value="0">男</option>
	//  <option value="1">女</option>
	/*
	 * 针对数组做循环
	 */
	$.each(genders, function(i, item) {
		/*文本-value*/
		var option = new Option(item.desc, item.genderId);
		$('#gender').append(option);
	})
}

function setSelectorForTable()
{
	$("#table").on("click-row.bs.table", function(e, row, ele) {
		/*
		 * 移除之前被点击过的内容
		 * 类选择器
		 */
		$(".danger").removeClass("danger");
		/*
		 * 为当前点击的内容添加样式
		 * 元素选择器
		 */
		$(ele).addClass("danger");
	});
}


var genders = [{
	genderId: 0,
	desc: '女'
}, {
	genderId: 1,
	desc: '男'
}];

function bindData(url) {

}
/*
 * 建立json数组
 * 规定每列的数据的显示形式
 */
var columns = [{
		field: 'empNO',
		title: '序号'
},
	{
		field: 'empName',
		title: '<i class="fa fa-usd"></i>' + '名称',
		// formatter--格式化函数
		//value对应列上的值，row对应的数据行，对应行的脚标
		formatter: function(value, row, index) {

			/*<button class="btn btn-link" onclick="">value</button>
			 * js中尽量使用单引号表示字符串
			 */
			return '<button class="btn btn-link" >' + value + '</button>';
			//html
		}
	},
	{
		field: 'salary',
		title: '薪酬',
		formatter: function(value, row, index) {
			/*+连接符*/
			return '<i class="fa fa-usd"></i>' +
				'<span class="text-success" >' + value + '</span>'
		}
	},
	{
		field: 'gender',
		title: '性别',
		formatter: function(value, row, index) {
			if(value == 0) {
				return '女';
			} else {
				return '男';
			}
		}
	},
	{
		title: '操作',
		width: 200,
		formatter: function(value, row, index) {
			//字符串连接，使用+

			/*
			 * 在按钮上，没有data-toggle 和 data-target
			 */

			return '<div class="btn-group">' +
				'<button class="btn btn-success" onclick="getSelectedItem()">' +
				'修改</button>' +
				'<button class="btn btn-danger" onclick="getSelectedItem()">' +
				'删除</button>' +
				'</div>';
		}
	}
]

function getSelectedItem() {
	/*取出bootstrap选中行的脚标*/
	var index = $("#table").find("tr.danger").data("index");
	var emp = $("#table").bootstrapTable('getData')[index];
	if(emp == null) {
		alert("请选中一行");
		return false;
	} else {
		$('#username').val(emp.empName);
		/*
         * $('input[name="gender"]')返回一个数组
         * 女<input type="radio" value="0" name="gender" checked="checked" /> 男
		  <input type="radio" value="1" name="gender" />
         */
		$('input[name="gender"]').each(function(index, element) {
			if(parseInt(emp.gender) == parseInt($(element).attr('value'))) {
				$(element).prop('checked', true);
			}
		});
		$('#gender').val(emp.gender);
	}
	$('#editForm').modal('show');
}


function btnAddShow()
{    
	clear();//初始化页面内容
	$('#editForm').modal('show');
}

function clear()
{
	//1.清空所有的输入框
	//2.初始化下拉列表
}



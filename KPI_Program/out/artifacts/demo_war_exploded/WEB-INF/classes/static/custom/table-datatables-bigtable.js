var TableDatatablesButtons = function() {

	var bigTable = function() {
		var table = $('#bigtable');

		var oTable = table
				.dataTable({

					// Internationalisation. For more info refer to
					// http://datatables.net/manual/i18n
					"language" : {
						"aria" : {
							"sortAscending" : ": 以升序排列此列",
							"sortDescending" : ": 以降序排列此列"
						},
						"emptyTable" : "表中数据为空",
						"info" : "总共 _PAGES_ 页，显示第 _START_ 到第 _END_ ，总共有 _TOTAL_ 条记录",
						"infoEmpty" : "没有数据",
						"infoFiltered" : "(从 _MAX_ 条数据中检索)",
						"lengthMenu" : "每页显示 _MENU_ 条记录",
						"search" : "检索 : ",
						"zeroRecords" : "没有检索到数据"
					},

					buttons : [ {
						extend : 'excel',
						className : 'btn dark btn-outline ',
						text : '导出Execl'
					}, {
						extend : 'colvis',
						className : 'btn dark btn-outline',
						text : '显示列名'
					} ],

					//保存状态
					//stateSave : true,
					
					//
					colReorder : {
						reorderCallback : function() {
							//console.log('callback');
						}
					},

					"order" : [ [ 0, 'asc' ] ],

					"lengthMenu" : [ [ 5, 10, 15, 20, -1 ],
							[ 5, 10, 15, 20, "All" ] // change per page
					// values here
					],

					// set the initial value
					"pageLength" : 20,

					"dom" : "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // horizobtal

				});
	}

	return {
		// main function to initiate the module
		init : function() {
			if (!jQuery().dataTable) {
				return;
			}
			bigTable();
		}
	};
}();

jQuery(document).ready(function() {
	TableDatatablesButtons.init();
});
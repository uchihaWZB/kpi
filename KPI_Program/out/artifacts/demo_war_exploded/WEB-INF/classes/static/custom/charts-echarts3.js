// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'),'walden');
option = {
	title : {
		text : '船舶效率分析',
		//subtext : '船舶效率分析'
	},
	tooltip : {
		trigger : 'axis'
	},
	toolbox : {
		feature : {
			dataView : {
				show : true,
				readOnly : false
			},
			magicType : {
				show : true,
				type : [ 'line', 'bar' ]
			},
			restore : {
				show : true
			},
			saveAsImage : {
				show : true
			}
		}
	},
	legend : {
		data : [ 'TEU', 'UNIT', '箱量' ]
	},
	xAxis : [ {
		type : 'category',
		data : [ '安吉川达010', '达飞明娜', '地中海雷古拉斯', '东方芝加哥', '飞洋5', '福海9', '海丰仁川',
				'集海达', '集海通', '集海之鹏', '嘉集001', '江苏集7' ]
	} ],
	yAxis : [ {
		type : 'value',
		name : '效率[小时]',
		min : 0,
		max : 50,
		interval : 10,
		axisLabel : {
			formatter : '{value}'
		}
	}, {
		type : 'value',
		name : '箱量',
		min : 0,
		max : 200,
		interval : 10,
		axisLabel : {
			formatter : '{value}'
		}
	} ],
	series : [ {
		name : 'TEU',
		type : 'bar',
		data : [ 22, 24, 30, 20, 28, 15, 43, 22, 28, 18, 14, 25 ]
	}, {
		name : 'UNIT',
		type : 'bar',
		data : [ 20, 22, 32, 18, 25, 10, 40, 30, 25, 16, 12, 21 ]
	}, {
		name : '箱量',
		type : 'line',
		yAxisIndex : 1,
		data : [ 140, 155, 140, 151, 197, 161, 187, 144, 176, 164, 165, 178 ]
	} ]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

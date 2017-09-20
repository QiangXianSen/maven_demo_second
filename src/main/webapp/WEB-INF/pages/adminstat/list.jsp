<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>潭州学院keke老师模板页面</title>
	<meta http-equiv="pragma" adminstat="no-cache">
	<meta http-equiv="cache-control" adminstat="no-cache">
	<meta http-equiv="expires" adminstat="0">    
	<meta http-equiv="keywords" adminstat="keyword1,keyword2,keyword3">
	<meta http-equiv="description" adminstat="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	<script src="${basePath}/resources/js/echat/echarts.js"></script>
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<div class="header">
				<ul class="fl">
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎keke来到cms后台</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息5个!</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
					 <li class="titems"><a href="${basePath}/logout"><i class="fa fa-share-alt"></i>退出</a></li>	
				</ul>
				<div class="fr sbtn none">
					<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
				</div>
			</div>
			<div class="content"> 首页  &gt; 日记管理</div>
			<div class="cnt">
				<div>
					<select onchange="loadData(this.value)">
						<option>请选择年份</option>
						<c:forEach begin="2010" end="2020" var="year">
							<option value="${year}">${year}</option>
						</c:forEach>
					</select>
				</div>
				<div class="tabwrap" id="main" style="height: 400px">
					<%--<!--表格-->--%>
					<%--<table class="tztab">--%>
						<%--<caption>--%>
							<%--<div class="fr sbtn">--%>
								<%--<input type="text" id="keywords" class="fl" placeholder="搜索的关键字..."/><a href="javascript:void(0);" onclick="tzAdmin.search(this);" class="fl"><i class="fa fa-search "></i></a>--%>
							<%--</div>--%>
						<%--</caption>--%>
						<%--<thead>--%>
							<%--<tr>--%>
								<%--<th>主键</th>--%>
								<%--<th>名称 <span class="up"></span> <span class="down"></span></th>	--%>
								<%--<th>用户</th>	--%>
								<%--<th>创建时间</th>	--%>
								<%--<th>删除状态</th>	--%>
								<%--<th>发布状态</th>	--%>
								<%--<th>操作</th>--%>
							<%--</tr>--%>
						<%--</thead>--%>
						<%--<!--身体部-->--%>
						<%--<tbody id="tbody" data-model="adminstat">--%>
							<%--<tr>--%>
								<%--<td id="loading" colspan="50"></td>--%>
							<%--</tr>--%>
						<%--</tbody>--%>
					<%--</table>--%>
					<%--<div class="cpage"></div>--%>
				<%--</div>--%>

			</div>
		</div>
	</div>
		<script>
			$(function () {
				loadData(new Date().getFullYear());
            });
			function loadData(year) {
                $.ajax({
                    type:'post',
                    data:{'year':year},
                    url:'http://localhost:8080/mavenDemo/admin/stat/list',
                    success:function (data) {
//			        var jsonArr = JSON.stringify(data);
                        var json = {
                            title: "潭州网站内容添加数",
                            datas:parseData(data)
                        }
                        initChart('main',json);
                    }
                });
            }
            function parseData(jsonArr) {
				var jsonObj = {};
				for (var key in jsonArr){
				    var num = jsonArr[key].num;
				    var m = jsonArr[key].m;
				    jsonObj["s"+parseInt(m)] = num;
				}
				var arr = [];
				for (var i = 1 ;i<=12;i++){
				    arr.push(jsonObj["s"+i]||0);
				}
				return arr;
            }
			function initChart(targetId,json) {
                var myChart = echarts.init(document.getElementById(targetId));
                var option = {
                    title : {
                        x:"center",
                        text: json.title,
                        subtext: '月份/数量'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'内容数',
                            type:'bar',
                            data:json.datas,
                            markPoint : {
                                data : [
                                    {type : 'max', name: '最大值'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        }
                    ]
                };

                myChart.setOption(option);
            }

		</script>
 </body>
</html>

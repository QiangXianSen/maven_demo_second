<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="content" varStatus="contentindex" items="${datas}">
	<tr>
		<td>
			${content.id}
			<c:if test="${contentindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td class="keys">${content.title}</td>	
		<td>${content.channelId}</td>	
		<td>${content.userId}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(content.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(content.createTime)}
		</td>	
		<td>
			<tz:if test="${content.isTop==0}">
				<tz:then><a href="javascript:void(0)" opid="${content.id}" mark="isTop" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${content.id}" mark="isTop" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${content.push==0}">
				<tz:then><a href="javascript:void(0)" opid="${content.id}" mark="push" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${content.id}" mark="push" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${content.isDelete==0}">
				<tz:then><a href="javascript:void(0)" opid="${content.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${content.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${content.isComment==0}">
				<tz:then><a href="javascript:void(0)" opid="${content.id}" mark="isComment" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${content.id}" mark="isComment" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${content.status==0}">
				<tz:then><a href="javascript:void(0)" opid="${content.id}" mark="status" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${content.id}" mark="status" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);" data-opid="${content.id}" onclick="tzAdmin.remove(this)">删除</a></td>
	</tr>
</c:forEach>

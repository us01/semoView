<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int payCode = (Integer) request.getAttribute("payCode");
	int serviceNo = (Integer) request.getAttribute("serviceNo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0px;
	background: #fafafa;
	font-family: '맑은고딕';
}

.myHomeArea {
	margin: 0 auto;
	width: 1000px;
	text-align: left;
	margin-top: 10px;
}

@media all and (max-width:768px) {
	.myHomeArea {
		width: 100%;
	}
}
</style>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script>
		IMP.init('imp95607366');
		IMP.request_pay({
			pg : 'inicis',
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '주문명:공고 결제',
			amount : 100,
			buyer_email : '<%=loginUser.getUserId()%>',
			buyer_name : '<%=loginUser.getUserId()%>',
			buyer_tel : '<%=loginUser.getPhone()%>',
			buyer_addr : '<%=loginUser.getAddress()%>',
			buyer_postcode : '123-456'
			
		}, function(rsp) {
			if (rsp.success) {
				//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
				jQuery.ajax({
					url : "/triangleView/pays.po", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
					type : 'POST',
					dataType : 'json',
					data : {
						imp_uid: rsp.imp_uid,//결제번호
						apply_num: rsp.apply_num, //카드승인번호
						paid_amount: rsp.paid_amount,//결제금액
						payCode : <%=payCode%>,
						serviceNo : <%=serviceNo%>
					//기타 필요한 데이터가 있으면 추가 전달
					}
				})
				location.href="<%=request.getContextPath()%>/noticeList";
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;

				alert(msg);
			}
		});
	</script>
</body>
</html>
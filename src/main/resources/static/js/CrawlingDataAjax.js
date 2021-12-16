function findAllByCrawlingData() {
	$.ajax({
		url: '/crawling/find',
		type: 'GET',
		dataType: 'json',
	}).done(function (data) {
		$("#resultKeyword").text(JSON.stringify(data));
		alert("완료");
		// window.location.replace("/");
	}).fail(function () {
			alert("실패");
			// history.back();
		}
	);
}
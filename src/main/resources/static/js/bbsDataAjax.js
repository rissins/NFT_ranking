function dataSend() {
    $.ajax({
        url: "/bbs",
        type: "GET",
        dataType: "json",
    }).done(function (data) {
        $("#resultDiv").text(JSON.stringify(data));
        console.log("성공");

    }).fail(function () {
        console.log("실패");
    })
}

function searchData() {
    $.ajax({
        url: "/bbs/" + $("#searchId").val(),
        type: "GET",
        dataType: "json",
    }).done(function (data) {
        $("#resultDiv").text(JSON.stringify(data));
        console.log("성공");
    }).fail(function () {
        console.log("실패");
    })
}


function deleteBbs() {
    $.ajax({
        url: '/bbs/' + $("#id").val(),
        type: 'DELETE',
    }).done(function () {
        alert("삭제완료");
        window.location.replace("/");
    }).fail(function () {
        alert("삭제실패");
    });
}

function insertBbs() {
    var param = {
        'title': $("#title").val(),
        'content': $("#content").val()
    };

    $.ajax({
        url: '/bbs',
        type: 'POST',
        data: param,
    }).done(function () {
        alert("완료");
        window.location.replace("/");
    }).fail(function () {
            alert("실패");
            history.back();
        }
    );

}



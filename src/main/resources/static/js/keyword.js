function getKeyword() {
    let target = document.getElementById("target")

    loadingImage(target);
    axios.get('/crawling')
        .then((response) => {
            let words = response.data.slice(0, 40).sort(() => Math.random() - 0.5);

            for (let i = 0; i < 40; i++) {
                let word = words[i].word
                let count = words[i].count
                let random = Math.round((Math.random() * 4))
                target.innerHTML += "<a class='word scale' style='font-size: " + (10 + (count * 2)) + "px; margin: " + random + "px;'> " + word + " </a>"
            }
            loadingEnd(target)
        })
        .catch(() => {
            target.innerText = "로딩 실패..."
            loadingEnd(target)
        })
}

// 로딩 중 이미지 표시
function loadingImage(target) {
    target.style.opacity = "0.5"
    document.getElementById("target").innerHTML += "<img id='loadingImg' src='../image/spinner.gif'/>";
}

// 로딩 중 이미지 삭제
function loadingEnd(target) {
    target.style.opacity = "1.0"
    document.getElementById("loadingImg").remove()
}

window.onload = function () {
    getKeyword();
};

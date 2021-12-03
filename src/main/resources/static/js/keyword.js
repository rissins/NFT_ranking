function getKeyword() {
    $.ajax({
        method: 'GET',
        url: '/crawling',
        dataType: 'json',
        success: function (data) {
            if (data.length > 0) {
                let target = document.getElementById("target")
                data = data.slice(0, 40).sort(() => Math.random() - 0.5);

                for (let i = 0; i < 40; i++) {
                    let word = data[i].word
                    let count = data[i].count

                    target.innerHTML += "<span class='word' style='font-size: " + (count * 3) + "px'> " + word + " </span>"
                }
            }
        }
    })
    // fetch('/crawling',
    //     {
    //         method: 'GET',
    //         headers: {
    //             'Content-Type': 'application/json; charset=UTF-8'
    //         },
    //     }).then((response => response.json())
    //     .then((data) => {
    //         console.log(data)
    //         // for (const jsonElement of json) {
    //         //     console.log(jsonElement.word + "\n")
    //         //     console.log(jsonElement.count + "\n")
    //         // }
    //     })
    // ).catch(error => {
    //     console.error(error)
    // })
}

window.onload = function () {
    getKeyword();
};

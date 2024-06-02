function submitTitle() {
    var title = document.getElementById("titleInput").value;

    //Lấy URL hiện tại
    var url = new URL(window.location.href);

    // Xóa tham số "id" từ URL
    url.searchParams.delete('id');

    // Cập nhật URL mới trong trình duyệt mà không làm tải lại trang
    history.replaceState({}, '', url.toString());

    var raw = {
        "prompt": title
    };

    var requestOptions = {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(raw)
    };

    fetch("http://localhost:8762/es/english/execute", requestOptions)
        .then((response) => response.json())
        .then(data => {

            // Xử lý dữ liệu trả về nếu cần
            document.getElementById('datetime').innerText = null;
            document.getElementById('englishText').innerText = data.generatedText;
            document.getElementById('vietnameseText').innerText = data.translatedText;

            document.getElementById('audioSource-en').src = data.englishVoice.slice(-69);
            document.getElementById('audioSource-vn').src = data.vietnameseVoice.slice(-69);

            var englishAudioElement = document.getElementById('myAudio-en');
            var vietnameseAudioElement = document.getElementById('myAudio-vn');
            englishAudioElement.load();
            vietnameseAudioElement.load();

            toggleHistory();
        })
        .catch((error) => console.error(error));
}

function toggleHistory() {
    var historyMenu = document.getElementById('historyMenu');
    historyMenu.classList.toggle('hidden');
    fetch("http://localhost:8762/es/english/getAll")
        .then((response) => response.json())
        .then(data => {
            data.reverse();
            document.getElementById('historyList').innerHTML = '';

            data.forEach(item => {
                // Tạo phần tử <a> mới
                var a = document.createElement('a');
                // Đặt href của thẻ <a> (nếu cần)
                a.href = "english.html?id=" + item.id;
                // Đặt nội dung của thẻ <a>
                a.textContent = item.prompt;

                // Tạo phần tử <li> mới
                var li = document.createElement('li');
                // Thêm thẻ <a> vào <li>
                li.appendChild(a);

                // Thêm <li> vào danh sách
                document.getElementById('historyList').appendChild(li);
            });
        })
        .catch((error) => console.error(error));
}

function fetchDataFromURL() {
    var url = window.location.href;

    // Phân tích URL để lấy tham số "id"
    var urlParams = new URLSearchParams(new URL(url).search);
    var id = urlParams.get('id');
    if (id) {
        fetch("http://localhost:8762/es/english/getform?id=" + id)
            .then(response => response.json())
            .then(data => {
                document.getElementById('datetime').innerText = data.createdDate;
                document.getElementById('titleInput').value = data.prompt;
                document.getElementById('englishText').innerText = data.generatedText;
                document.getElementById('vietnameseText').innerText = data.translatedText;

                document.getElementById('audioSource-en').src = data.englishVoice.slice(-69);
                document.getElementById('audioSource-vn').src = data.vietnameseVoice.slice(-69);

                var englishAudioElement = document.getElementById('myAudio-en');
                var vietnameseAudioElement = document.getElementById('myAudio-vn');
                englishAudioElement.load();
                vietnameseAudioElement.load();
                toggleHistory();
            })
            .catch(error => console.error(error));
    }
}

// Gọi hàm tự động khi trình duyệt tải trang
fetchDataFromURL();
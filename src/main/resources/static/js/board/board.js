//삭제 기능
const deleteButton = document.getElementById("delete_btn"); // ID 속성을 기준으로 찾음

if(deleteButton) {
    deleteButton.addEventListener("click", event => { // 클릭 이벤트

    // 경고창 표시
    const isConfirmed = confirm("삭제하시겠습니까?");
        if(isConfirmed) {
            let id = document.getElementById("board_id").value;
            //id 값을 받아 DELETE API 호출
            fetch(`/api/board/${id}`, {
                method: "DELETE"
            })
            .then(response => {
                // 서버에서 삭제가 성공적으로 이루어진 경우.
                if(response.ok) {
                    alert("삭제 되었습니다.");
                    location.replace("/board");
                }
                else {
                    alert("실패 했습니다");
                }
            })
        }
    })
}


// 수정기능
// id가 modify_btn 조회
const modifyButton = document.getElementById("modify_btn");

if (modifyButton) {
    modifyButton.addEventListener("click", event => {

    const isConfirmed = confirm("수정 하시겠습니까?");
        if(isConfirmed) {
            let params = new URLSearchParams(location.search);
            let id = params.get('id');

            // 요청을 보낼 때 headers의 요청 형식을 지정
            fetch(`/api/board/${id}`, {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json",
                },

                // body에 HTML에 입력한 데이터를 JSON 형식으로 바꿔 보낸다.
                body: JSON.stringify({
                    title: document.getElementById("title").value,
                    content : document.getElementById("content").value
                })
            })
            .then(response => {
                if(response.ok) {
                    alert("수정 되었습니다.");
                    location.replace(`/board/${id}`);
                }
                else {
                    alert("실패 했습니다");
                }
            })
        }
    })
}

// 등록 기능
// id가 create-btn인 엘리먼트를 조회.
const createButton = document.getElementById('create_btn');

if (createButton) {
    createButton.addEventListener('click', event => {

    const isConfirmed = confirm("등록 하시겠습니까?");
        if(isConfirmed) {
            // 등록 API로 POST 요청을 보낸다.
            fetch(`/api/board`, {
                method: 'POST',
                headers: { // 요청을 보낼 때 headers의 요청 형식을 지정한다.
                    "Content-Type": "application/json",
                },

                // body에 HTML에서 입력한 데이터를 JSON 형식으로 바꿔 보낸다.
                body: JSON.stringify({
                    title: document.getElementById('title').value,
                    content: document.getElementById('content').value,
                    author: document.getElementById('author').value
                })
            })
            .then(() => {
                alert('등록 되었습니다.');
                location.replace('/board');
            })
        }
    })
}
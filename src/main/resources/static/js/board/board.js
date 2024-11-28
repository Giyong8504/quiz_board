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
            })
        }
    })
}
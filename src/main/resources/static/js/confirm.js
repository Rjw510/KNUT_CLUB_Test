/* confirm */
function updateCheck() {
    if(confirm("정말 수정하시겠습니까?") == false) {
        return false;
    }
}

function deleteCheck() {
    if(confirm("정말 삭제하시겠습니까?") == false) {
        return false;
    }
}
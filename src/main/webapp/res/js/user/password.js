var frmElem = document.querySelector('#frm');
var submitBtnElem = document.querySelector('#submitBtn');

submitBtnElem.addEventListener('click', function () {

    if (frmElem.upw.value.length > 5) {
        alert('현제 비밀번호를 작성해주세요.')
    } else if (frmElem.changedUpw.value.length > 5) {
        alert('변경 비밀번호를 작성해주세요.')
    } else if (frmElem.changedUpw.value !== frmElem.changedUpwConfirm.value) {
        alert('비밀번호가 같지 않습니다.')
    }

   frmElem.submit();
});
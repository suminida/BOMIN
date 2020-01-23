function boardCheck() {

	if (document.frm.title.value.length == 0) {
		alert("제목을 입력하세요.");
		return false;
	} else if (document.frm.contents.value.length == 0) {
		alert("내용을 입력하세요.");
		return false;
	}
	return true;

}
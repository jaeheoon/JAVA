const replyBtns = document.querySelectorAll("#replyBtn");
replyBtns.forEach(btn => {
	btn.addEventListener('click', getReply);
});

async function getReply(event) {
	const memoId = event.target.value;
    let replys = await requestReplys(memoId);
    showReply(memoId, replys);
}

function requestReplys(memoId) {
    const url = `/mall/article/reply?id=${memoId}`;
    return fetch(url).then(response => response.json());
}

function  showReply(memoId, replys) {
	const views = document.querySelectorAll("#replyView");
	views.forEach(p => {
		if(memoId === p.dataset.id){
			// HTML 태그에 맞게 출력
			let ul = `<ul>`;
			replys.forEach(reply => {
				ul += `<li>${reply.content}(${reply.regdate}) -  ${reply.id}</li>`;	
			});
			ul += `</ul>`;
			p.innerHTML = ul;
		}
	});
}






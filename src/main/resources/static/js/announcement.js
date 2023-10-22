// announcementObject 객체 생성
let announcementObject = {
	// init() 함수 선언
	init: function() {
		let _this = this;
		
		// #btn-save 버튼에 클릭 이벤트가 발생하면 insertUser() 함수 호출
		$("#btn-insertAnnouncement").on("click", () => {
			_this.insertAnnouncement();
		});
	},
	insertAnnouncement: function() {
		// 사용자가 입력한 값 추출
		let announcement = {
			companyName : $("#companyName").val(),
			announcementName : $("#announcementName").val(),
			job : $("#job").val(),
			startDate : $("#startDate").val(),
			endDate : $("#endDate").val()
		}
		
		alert(announcement.startDate);

		// Ajax를 이용한 비동기 호출
		// done() 함수 : 요청 처리에 성공했을 때 실행될 코드
		// fail() 함수 : 요청 처리에 실패했을 때 실행될 코드
		$.ajax({
			type: "POST", // 요청 방식
			url: "/announcement/insert", // 요청 경로
			dataType: 'json',
			// HTTP의 Body에 설정되는 데이터 마임 타입
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(announcement), // user 객체를 JSON 형식으로 변환
			success: function(response){
				let status = response['status'];
				if (status == 200) {
					window.location = ('/');
				} else {
					let warn = "";
					let errors = response["data"];
					if (errors.companyName != null) warn = warn + errors.companyName + "\n";
					if (errors.announcementName != null) warn = warn + errors.announcementName + "\n";
					if (errors.job != null) warn = warn + errors.job;
					if (errors.startDate != null) warn = warn + errors.startDate;
					if (errors.endDate != null) warn = warn + errors.endDate;
					// alert(warn);
				}
			},
			fail: function(error){
				// alert(error);
			},
		})
	}
}

// announcementObject 객체의 init() 함수 호출
announcementObject.init();
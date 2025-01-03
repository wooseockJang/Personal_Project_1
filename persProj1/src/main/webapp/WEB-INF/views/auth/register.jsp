<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>회원가입</title>
<style>
</style>
</head>
<body>
	<%-- 머리말 --%>
	<jsp:include page="/common/header.jsp" />

	<div class="row justify-content-center">
		<div class="col-xl-5 col-lg-5 col-md-9">
			<div class="card mt-5">
				<div class="card-body p-0">
					<div class="row">
						<div class="col-lg-12">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">회원가입</h1>
								</div>
								<form class="user" action="/register/addition" method="post">
									<div class="form-group"
										style="display: flex; align-items: stretch; position: relative;">
										<input type="text" class="form-control form-control-user mb-3"
											placeholder="아이디 입력" id="userId" name="userId" maxlength="20"
											style="flex: 1; height: 38px;" />
										<div id="error-message"
											style="display: none; color: red; font-size: 0.7em; position: absolute; top: 35%; right: 100px; transform: translateY(-50%);">
											5~20자의 영문 소문자, 숫자를 사용해 주세요.</div>
										<button type="button" id="check-id-button"
											class="btn btn-success"
											style="height: 38px; font-size: 0.8em;"
											onclick="fn_checkId()" disabled>중복확인</button>
									</div>
									<div class="form-group row">
										<div class="form-group" style="position: relative;">
											<input type="password"
												class="form-control form-control-user mb-3"
												placeholder="패스워드 입력" id="password" name="password"
												maxlength="16" />
											<div id="pw-error-message"
												style="display: none; color: red; font-size: 0.7em; position: absolute; top: 35%; right: 20px; transform: translateY(-50%);">
												8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.</div>
										</div>
										<div class="form-group" style="position: relative;">
											<input type="text"
												class="form-control form-control-user mb-3"
												placeholder="이름 입력" id="name" name="name" />
											<div id="name-error-message"
												style="display: none; color: red; font-size: 0.7em; position: absolute; top: 35%; right: 20px; transform: translateY(-50%);">
												한글, 영문 대/소문자를 사용해 주세요. (특수기호, 공백 사용 불가)</div>
										</div>
										<div class="form-group" style="position: relative;">
											<input type="text"
												class="form-control form-control-user mb-3"
												placeholder="생년월일 입력(8자)" id="birth" name="birth"
												maxlength="8" />
											<div id="birth-error-message"
												style="display: none; color: red; font-size: 0.7em; position: absolute; top: 35%; right: 20px; transform: translateY(-50%);">
												올바른 생년월일을 입력하세요. (예: 19991231).</div>
										</div>

										<div class="form-group" style="position: relative;">
											<input type="text"
												class="form-control form-control-user mb-3"
												placeholder="휴대전화번호 입력" id="phoneNumber" name="phoneNumber"
												maxlength="13" />
											<div id="phoneNum-error-message"
												style="display: none; color: red; font-size: 0.7em; position: absolute; top: 35%; right: 20px; transform: translateY(-50%);">
												010으로 시작하는 11자리 숫자를 입력해 주세요.</div>
										</div>
									</div>
									<button type="submit"
										class="btn btn-primary btn-user w-100 mb-3">Register</button>
								</form>
								<hr />
								<div class="text-center">
									<a href="/login"> 이미 계정이 있으신가요? 로그인하세요! </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- 꼬리말 --%>
	<jsp:include page="/common/footer.jsp" />

	<script>
		/* 아이디 입력시 조건 */
		document.getElementById('userId').addEventListener('input', function () {
		    const errorMessage = document.getElementById('error-message');
		    const userId = this.value;
		    const checkIdButton = document.getElementById('check-id-button');
		
		    // 아이디 형식 검증: 5~20자, 최소 1개의 소문자와 1개의 숫자 포함
		    const idPattern = /^(?=[a-z0-9]*[a-z])(?=[a-z0-9]*\d)[a-z0-9]{5,20}$/;
		
		    // 아이디가 비어 있거나 패턴에 맞지 않으면 에러 메시지를 표시하고 버튼 비활성화
		    if (!userId || !idPattern.test(userId)) {
		        errorMessage.style.display = 'block'; // 에러 메시지 표시
		        checkIdButton.disabled = true; // 버튼 비활성화
		    } else {
		        errorMessage.style.display = 'none'; // 에러 메시지 숨기기
		        checkIdButton.disabled = false; // 버튼 활성화
		    }
		    
		    // 아이디 값이 변경되면 중복 확인 상태 초기화
		    isIdChecked = false; // 중복 확인 상태 초기화
		});


		/* 비밀번호 입력시 조건 */
		document
				.getElementById('password')
				.addEventListener(
						'input',
						function() {
							const errorMessage = document
									.getElementById('pw-error-message');
							const password = this.value;

							// 8~16자의 영문 대/소문자, 숫자, 특수문자 조건
							const passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,16}$/;

							if (!passwordPattern.test(password)) {
								errorMessage.style.display = 'block'; // 조건에 맞지 않으면 에러 메시지 표시
							} else {
								errorMessage.style.display = 'none'; // 조건에 맞으면 에러 메시지 숨기기
							}
						});

		/* 이름 입력시 조건 */
		document.getElementById('name').addEventListener(
				'input',
				function(event) {
					const input = event.target;
					const errorMessage = document
							.getElementById('name-error-message');

					// 이름에 허용되지 않는 문자 (특수기호, 공백) 검사
					const regex = /^[a-zA-Z가-힣]+$/; // 영문 대/소문자, 한글만 허용

					// 입력값이 규칙에 맞지 않으면 에러 메시지 표시
					if (!regex.test(input.value)) {
						errorMessage.style.display = 'block'; // 에러 메시지 표시
					} else {
						errorMessage.style.display = 'none'; // 규칙에 맞으면 에러 메시지 숨김
					}
				});

		/* 생년월일 입력시 조건 */
		document.getElementById('birth').addEventListener('input', function (event) {
		    const input = event.target;
		    const errorMessage = document.getElementById('birth-error-message');
		
		    // 숫자 외에는 입력되지 않도록
		    input.value = input.value.replace(/[^0-9]/g, '');
		
		    // 유효성 검사: 8자리 숫자인지 확인
		    const birth = input.value;
		    const year = parseInt(birth.substring(0, 4), 10);
		    const month = parseInt(birth.substring(4, 6), 10);
		    const day = parseInt(birth.substring(6, 8), 10);
		
		    // 윤년 확인 함수
		    function isLeapYear(year) {
		        return (year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0));
		    }
		
		    // 각 달의 최대 일수
		    const daysInMonth = [31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
		
		    // 현재 날짜를 자동으로 가져옵니다
		    const currentDate = new Date(); // 현재 날짜
		    const currentYear = currentDate.getFullYear(); // 현재 연도
		    const currentMonth = currentDate.getMonth() + 1; // 현재 월 (0부터 시작하므로 +1)
		    const currentDay = currentDate.getDate(); // 현재 일
	
		    // 유효성 검사: 8자리 숫자, 올바른 연도, 월, 일 범위 체크, 현재 날짜와 비교
		    if (
		        birth.length !== 8 || // 길이 체크
		        year < 1900 || year > currentYear || // 연도 범위
		        month < 1 || month > 12 || // 월 범위
		        day < 1 || day > daysInMonth[month - 1] || // 일 범위 (윤년 고려)
		        (year === currentYear && (month > currentMonth || (month === currentMonth && day > currentDay))) // 생년월일이 현재 날짜 이후인 경우
		    ) {
		        errorMessage.style.display = 'block'; // 에러 메시지 표시
		    } else {
		        errorMessage.style.display = 'none'; // 에러 메시지 숨김
		    }
		});

		/* 휴대전화번호 입력시 조건 */
		document.getElementById('phoneNumber').addEventListener(
				'input',
				function(event) {
					const input = event.target;
					const errorMessage = document
							.getElementById('phoneNum-error-message');

					// 숫자 외에는 입력되지 않도록
					if (/[^0-9]/.test(input.value)) {
						input.value = input.value.replace(/[^0-9]/g, ''); // 숫자만 남기고 모두 제거
					}

					let value = input.value;

					// 010-1234 형태로 포맷팅
					if (value.length > 3 && value.length <= 7) {
						value = value.replace(/(\d{3})(\d+)/, '$1-$2');
					} else if (value.length > 7) {
						// 010-1234-5678 형태로 포맷팅
						value = value
								.replace(/(\d{3})(\d{4})(\d+)/, '$1-$2-$3');
					}

					input.value = value; // 포맷팅된 값을 다시 입력란에 반영

					// 유효성 검사: 010으로 시작하고 11자리 숫자인지 확인
					if (!/^010\d{8}$/.test(input.value.replace(/-/g, ''))) {
						errorMessage.style.display = 'block'; // 에러 메시지 표시
					} else {
						errorMessage.style.display = 'none'; // 조건을 만족하면 에러 메시지 숨김
					}
				});
		
		// 회원가입 버튼을 누르기 위한 조건검사
		document
				.querySelector('form')
				.addEventListener(
						'submit',
						function(event) {
							const userId = document.getElementById('userId').value;
							const password = document
									.getElementById('password').value;
							const name = document.getElementById('name').value;
							const birth = document.getElementById('birth').value;
							const phoneNumber = document
									.getElementById('phoneNumber').value;

							// 공백이 있는 입력란을 확인
							if (!userId || !password || !name || !birth
									|| !phoneNumber) {
								event.preventDefault(); // 폼 전송을 막음
								alert('모든 입력란을 입력하세요.');
								return; // 폼 전송을 막고 종료
							}

							// 에러 메시지 요소를 가져옵니다
							const idError = document
									.getElementById('error-message');
							const pwError = document
									.getElementById('pw-error-message');
							const nameError = document
									.getElementById('name-error-message');
							const birthError = document
									.getElementById('birth-error-message');
							const phoneNumError = document
									.getElementById('phoneNum-error-message');

							// 기본적으로 폼 전송을 막습니다.
							let hasError = false;

							// 아이디 유효성 검사
							if (!/^(?=[a-z0-9]*[a-z])(?=[a-z0-9]*\d)[a-z0-9]{5,20}$/.test(userId)) {
							    idError.style.display = 'block'; // 에러 메시지 표시
							    hasError = true; // 에러 상태 설정
							} else {
							    idError.style.display = 'none'; // 에러 메시지 숨기기
							}


							// 비밀번호 유효성 검사 (조건: 8~16자, 영문 대소문자, 숫자, 특수문자 포함)
							if (!/^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,16}$/
									.test(password)) {
								pwError.style.display = 'block'; // 에러 메시지 표시
								hasError = true;
							} else {
								pwError.style.display = 'none'; // 에러 메시지 숨김
							}

							// 이름 유효성 검사
							if (!/^[a-zA-Z가-힣]+$/.test(name)) { // 한글, 영문 대/소문자만 허용
								nameError.style.display = 'block';
								hasError = true;
							} else {
								nameError.style.display = 'none';
							}

							// 생년월일 유효성 검사
							if (birth.length !== 8 || !/^\d{8}$/.test(birth)) {  // 만약 생년월일이 8자리가 아니거나 숫자 8자리로 이루어지지 않았다면
						        birthError.style.display = 'block';
						        hasError = true;
						    } else {
						        const year = parseInt(birth.substring(0, 4), 10);
						        const month = parseInt(birth.substring(4, 6), 10);
						        const day = parseInt(birth.substring(6, 8), 10);
						
						        // 윤년 확인 함수
						        function isLeapYear(year) {
						            return (year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0));
						        }
						
						        // 각 달의 최대 일수
						        const daysInMonth = [31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
						
						        // 현재 날짜를 자동으로 가져옵니다
						        const currentDate = new Date(); // 현재 날짜
						        const currentYear = currentDate.getFullYear(); // 현재 연도
						        const currentMonth = currentDate.getMonth() + 1; // 현재 월 (0부터 시작하므로 +1)
						        const currentDay = currentDate.getDate(); // 현재 일
						
						        // 유효성 검사: 8자리 숫자, 올바른 연도, 월, 일 범위 체크, 현재 날짜와 비교
						        if (
						            year < 1900 || year > currentYear || // 연도 범위
						            month < 1 || month > 12 || // 월 범위
						            day < 1 || day > daysInMonth[month - 1] || // 일 범위 (윤년 고려)
						            (year === currentYear && (month > currentMonth || (month === currentMonth && day > currentDay))) // 생년월일이 현재 날짜 이후인 경우
						        ) {
						            birthError.style.display = 'block';
						            hasError = true;
						        } else {
						            birthError.style.display = 'none';
						        }
						    }

							// 전화번호 유효성 검사
							if (!/^010-\d{4}-\d{4}$/.test(phoneNumber)) {
								phoneNumError.style.display = 'block';
								hasError = true;
							} else {
								phoneNumError.style.display = 'none';
							}

							// 에러가 있을 경우 폼 제출을 막고 알림을 표시합니다
							 if (hasError) {
							        event.preventDefault();
							        alert('회원 가입이 불가능합니다. 에러 메시지를 확인해주세요.');
							        return;
							    }

						    // 아이디 중복 확인 여부 체크
						    if (!isIdChecked) {
						        event.preventDefault();
						        alert('아이디 중복을 확인하세요.');
						        return;
						    }

						    // 모든 검사를 통과한 경우 폼 제출
						    alert('회원 가입이 완료되었습니다!');
						});
		
		// 아이디 중복 체크
		let isIdChecked = false; // 아이디 중복 확인 상태를 저장

		function fn_checkId() {
		    const userId = document.getElementById('userId').value;
		
		    // 아이디 중복 확인
		    fetch('/auth/check-userId?userId=' + encodeURIComponent(userId))
		        .then(response => response.text())
		        .then(responseText => {
		            if (responseText === "true") {
		                alert("이미 존재하는 아이디입니다."); // 중복된 아이디
		                isIdChecked = false; // 중복 확인 실패
		            } else if (responseText === "false") {
		                alert("사용 가능한 아이디입니다."); // 사용 가능한 아이디
		                isIdChecked = true; // 중복 확인 성공
		            } else {
		                alert("예기치 않은 응답: " + responseText);
		                isIdChecked = false;
		            }
		        })
		        .catch(error => {
		            alert('아이디 중복 확인에 실패했습니다.');
		            console.error('중복 확인 오류:', error);
		            isIdChecked = false;
		        });
		
		    return false;
		}
	</script>
</body>
</html>
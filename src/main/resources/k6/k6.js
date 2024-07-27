import { check, sleep } from "k6"; // check와 sleep을 가져옵니다.
import http from "k6/http";

export const options = {
    vus: 10, // 가상 사용자 수
    duration: '30s', // 테스트 지속 시간
};

export default function () {
    const response = http.get('http://host.docker.internal:8080/api/v1/health'); // 요청할 URL

    // 응답 시간 출력
    console.log(`Response time for GET: ${response.timings.duration} ms`);

    // 응답 검증
    check(response, {
        'is status 200': (r) => r.status === 200, // 상태 코드가 200인지 확인
        'response body is correct': (r) => r.body === 'Hello', // 응답 본문이 'Hello'인지 확인
    });

    sleep(1); // 1초 대기
}

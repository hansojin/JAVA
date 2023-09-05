package optional;

import java.util.Optional;

class CntrInfo {
	Optional<String> phone;   // null 일 수 있음
	Optional<String> adrs;    // null 일 수 있음

	public CntrInfo(Optional<String> ph, Optional<String> ad) {
		phone = ph;
		adrs = ad;
	}
	public Optional<String> getPhone() { return phone; }
	public Optional<String> getAdrs() { return adrs; }
}

class OptionalFlatMapElse {
	public static void main(String[] args) {
		Optional<CntrInfo> ci = Optional.of(
				new CntrInfo(Optional.ofNullable(null), Optional.of("Republic of Korea")));

		String phone = ci.flatMap(c -> c.getPhone()).orElse("There is no phone number.");
		String addr = ci.flatMap(c -> c.getAdrs()).orElse("There is no address.");

		System.out.println(phone);	//There is no phone number.
		System.out.println(addr);	//Republic of Korea
	}
}

/*

위 예제는 MapElseOptional.java를 flatMap 메소드를 사용하는 형태로 수정한 결과이다. 먼저 다음 클래스 정의를 보자.

class CntrInfo {
	Optional<String> phone;		// null 일 수 있음
	Optional<String> adrs;		// null 일 수 있음
	...
}

위의 클래스와 같이 멤버를 Optional로 두면 이 멤버와 관련된 코드 전반에 걸쳐서 코드의 개선을 기대할 수 있다.
그런데 이렇게 멤버를 Optional로 두는 경우에는 map보다 flatMap이 더 어울린다. 만약에 예제의 다음 문장을 map 메소드를 호출하는 형태로 작성한다면,

>> String phone = ci.flatMap(c->c.getPhone()).orElse("There is no phone number.");

Optional로 감싸서 반환하는 map 메소드이 특성상 다음과 같이 get 메소드 호출을 통해서 꺼내는 과정을 거쳐야 하기 때문이다.

>> String phone = ci.map(c->c.getPhone()).get().orElse("There is no phone number.");

 */
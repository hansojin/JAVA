|정규표현식|설명|
|---|---|
|^	|문자열 시작
|$	|문자열 종료
|.	|임의의 한 문자(단 \은 넣을 수 없음)
|*	|앞 문자가 없을 수도 무한정 많을 수도 있음
|+	|앞 문자가 하나 이상
|?	|앞 문자가 없거나 하나 있음
|[ ] 	|문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타냅니다. [] 내에서 ^ 가 선행하여 존재하면 not을 나타낸다.
|{ } 	|횟수 또는 범위를 나타냅니다.
|{n, } 	|n개 이상을 의미
|{n,m} 	|n개 - m개를 의미
|( )	|소괄호 안의 문자를 하나의 문자로 인식
| or	|패턴 안에서 or 연산을 수행할 때 사용
| \. 	|점 문자를 의미
|\	|정규 표현식 역슬래시(\)는 확장문자 (역슬래시 다음에 일반 문자가 오면 특수문자로 취급하고 역슬래시 다음에 특수문자가 오면 그 문자 자체를 의미)
|\b	|단어의 경계
|\B	|단어가 아닌것에 대한 경계
|\A	|입력의 시작 부분
|\G	|이전 매치의 끝
|\Z	|입력의 끝이지만 종결자가 있는 경우
|\z	|입력의 끝
|\s	|공백 문자 = [\t\n\r\f\v]
|\S	|공백 문자가 아닌 나머지 문자 = [^\t\n\r\f\v]
|\w	|알파벳이나 숫자 = [a-zA-Z0-9_]
|\W	|알파벳이나 숫자를 제외한 문자 = [^a-zA-Z0-9_]
|\d	|숫자 [0-9]와 동일
|\D	|숫자를 제외한 모든 문자 = [^0-9]
|(?i)	|앞 부분에 (?!)라는 옵션을 넣어주게 되면 대소문자는 구분하지 않습니다.
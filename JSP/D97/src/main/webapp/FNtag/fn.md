**JSTL이 제공하는 EL 함수**

| property | Description |
| -------- | ----------- |
|length(obj)|		obj가 List와 같은 Collection인 경우 저장된 항목의 개수를 리턴하고, obj가 문자열일 경우 문자열의 길이를 리턴한다.
|toUpperCase(str)|		str을 대문자로 변환한다.
|toLowerCase(str)|		str을 소문자로 변환한다.
|substring(str, idx1, idx2)|	str.substring(idx1, idx2)의 결과를 리턴한다. idx2가 -1일 경우 str.substring(idx1)과 동일한다.
|substringAfter(str1, str2)|	str1에서 str1에 포함되어 있는 str2 이후의 문자열을 구한다.
|substringBefore(str1, str2)|	str1에서 str2에 포함되어 있는 str2 이전의 문자열을 구한다.
|trim(str)|			str 좌우의 공백문자를 제거한다.
|replace(str, src, dest)|	str에 있는 src를 dest로 변환한다.
|indexOf(str1, str2)|		str1에서 str2가 위치한 인덱스를 구한다.
|startsWith(str1, str2)|		str1이 str2로 시작할 경우 true를, 그렇지 않을 경우 false를 리턴한다.
|endsWith(str1, str2)	|	str1이 str2로 끝나는 경우 true를, 그렇지 않을 경우 false를 리턴한다.
|contains(str1, str2)|		str1이 str2를 포함하고 있을 경우 true룰 리턴한다.
|containsIgnoreCase(str1, str2)|	대소문자 구분 없이 str1이 str2를 포함하고 있을 경우 true를 리턴한다.
|split(str1, str2)|		str2로 명시한 글자를 기준으로 str1을 분리해서 배열로 리턴한다.
|join(array, str2)|		array에 저장된 문자열을 합친다. 이때 각 문자열 사이에는 str2이 붙는다.
|eacapeXml(str)	|	XML의 객체 참조에 해당하는 특수 문자를 처리한다. 예를 들어 '&'는 '&amp;'로 변환한다.

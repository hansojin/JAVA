```
	01 :	<web-app>
	02 :		<display-name>프로젝트명</display-name>
	03 :	
	04 :		<filter>
	05 :			<filter-name>필터 닉네임</filter-name>
	06 :			<filter-class>필터 클래스 풀네임(패키지 명까지)</filter-class>
	07 :			<init-param>
	08 :				<param-name>매개변수명</param-name>
	09 :				<param-value>값</param-value>
	10 :			</init-param>
	11 :		</filter>
	12 :		<filter-mapping>
	13 :			<filter-name>필터 닉네임</filter-name>
	14 :			<url-pattern>필터 클래스가 실행될 위치</url-pattern>
	15 :		</filter-mapping>
	16 :	
	17 :		<servlet>
	18 :			<servlet-name>서블릿 닉네임</servlet-name>
	19 :			<servlet-class>서블릿 클래스 풀네임(패키지명까지)</servlet-class>
	20 :			<init-param>
	21 :				<param-name>매개변수명</param-name>
	22 :				<param-value>값</param-value>
	23 :			</init-param>
	24 :			<load-on-startup>실행순서값(0값은 서버임의실행)</load-on-startup>
	25 :		</servlet>
	26 :		<servlet-mapping>
	27 :			<servlet-name>서블릿 닉네임</servlet-name>
	28 :			<url-pattern>/url패턴</url-pattern>
	29 :		</servlet-mapping>
	30 :	
	31 :		<welcome-file-list>
	32 :			<welcome-file>기본 연결파일</welcome-file>
	33 :		</welcome-file-list>
	34 :	<web-app>
```

web.xml 파일은 웹 컨테이너와 웹 프로그램의 파일을 서로 연결하고 관리하는 설정 파일이다.

```
line2 <display-name>프로젝트명</display-name>
	web.xml 파일이 속한 프로젝트의 이름을 적는다.

line4-11	프로젝트에서 사용할 필터 클래스를 등록한다.

line5	<filter-name>필터 닉네임</filter-name>
	필터 클래스의 닉네임을 적는다. 임의로 정해도 된다.

line6 <filter-class>필터 클래스 풀네임(패키지명까지)</filter-class>
	해당 필터 클래스에 대해 패키지의 이름까지 전체를 등록한다. 패키지가 아니면 클래스 이름만 등록한다.
	
line7-10 해당 필터 클래스가 실행되면서 기본적으로 갖는 초기화 매개 변수를 적는다. 여러 개를 등록해도 된다. 
	void main(String[] args) 메서드의 args[0]과 args[1] 등과 같은 개념이라고 보면 된다. void main() 메서드에서는 args 이라는 이름으로 사용하지만 여기서는 변수의 이름과 값을 모두 등록해야 한다.

line12-15	해당 필터 클래스가 실행되는 시점을 등록한다.

line13	<filter-name>필터 닉네임</filter-name>
	실행될 필터 클래스의 닉네임을 적는다. 5행에서 적은 이름과 대소문자까지 같아야 한다.

line14	<url-pattern>필터 클래스가 실행될 위치</url-pattern>
	실행될 시점을 지정한다.

line17-25 서블릿을 등록하고 있다. 여러 개를 등록해도 된다.

line18	<servlet-name>서블릿 닉네임</servlet-name>
	서블릿의 닉네임을 등록하고 있다. 닉네임은 클래스의 이름이 너무 길 때 편의상 사용한다. 클래스 이름이 짧으면 클래스 이름과 동일하게 등록해도 무방하다.

line19	<servlet-class>서블릿 클래스 풀네임</servlet-class>
	서블릿 클래스의 전체 이름을 등록하고 있다. 패키지이면 패키지의 이름까지 모두 적어야 한다.
	
line20-23	필터 클래스처럼 서블릿이 실행될 때 초깃값으로 전달될 매개 변수를 적고 있다. 여러 개를 등록해도 무방하다.

line24	<load-on-startup>실행 순서 값(0값은 서버임의 실행)</load-on-startup>
	웹 서버가 구동될 때 서블릿의 init() 메서드를 미리 실행할지 지정하고 있다.
	
line31-33 클라이언트의 사용자가 웹 브라우저로 웹 서버에 접속할 때 기본적으로 보여주는 메인 페이지를 등록하고 있다.
```

서블릿은 최초 요청이 들어올때 초기화 된다.

클래스 로딩 인스턴스화 초기화설정을 해야하는데 이렇게 되면 서버가 올라가고 맨처음 호출한 유저는 보통 시간보다 시간이 오래걸린다.

그것을 방지하기 위해 load-on-startup이라는 것이 있다.

24행에서 값을 0으로 지정하면 웹 서버가 임의로 init() 메서드를 실행하고, 0 이외의 정수를 값으로 지정하면 웹 서버가 구동될 때 이 순서대로 해당 서블릿의 init() 메소드가 차례대로 실행된다. 예를 들어 A, B, C라는 서블릿이 있을 때 B의 init() 메서드를 먼저 실행하고 다음으로 A, 마지막으로 C 서블릿의 init() 메서드를 실행해야 한다면 B서블릿을 등록할 때 load-on-startup 값을 1로 하고, A 서블릿의 load-on-startup을 2로, C 서블릿의 load-on-startup 값을 3으로 하면 웹 서버가 구동될 때 해당 순서대로 init() 메서드를 실행하게 된다는 의미이다.

메인 페이지 등록과 관련해서 추가적으로 설명하면 다음(Daum) 사이트에 접속할 때 `http://www.daum.net/index.html` 이라고 적어야 정상적으로 메인 페이지를 볼 수 있다. 그러나 우리는 대게 `http://www.daum.net` 이라고만 적는다. 당연하게도 이렇게 적어도 정상적으로 보여진다.

이유는 바로 앞서 welcome 파일을 등록했기 때문이다. 해당 프로젝트의 이름까지만 적을 때 실행될 파일을 welcome 파일로 지정할 수 있다.

```
<welcome-file-list>
	<welcome-file>Servelt01</welcome-file>
</welcome-file-list>
```

이와 같은 경우 `http://localhost:8080/Round12` 이 라고만 적어도 `http://localhost:8080/Round12/Servlet01` 이라고 적은 것과 동일한 효과를 보인다.

그런데 Servlet01파일이 없으면 어떻게 될까? 이럴 때를 대비해서 welcome 파일을 여러 개 등록할 수 있다. 적은 순서대로 찾은 파일을 실행한다.

```
<welcome-file-list>
	<welcome-file>index.html</welcome-file>
	<welcome-file>Servlet01</welcome-file>
	<welcome-file>home.jsp</welecome-file>
</welcome-file-list>
```

이와 같이 되어 있으면 첫 번째 index.html 파일이 없기 때문에 건너뛰고 두 번째 Servlet01파일은 있기 때문에 실행된다. 마지막 home.jsp 파일은 찾아보지도 않는다.

*<참고> 필터 클래스는 여러 개를 등록할 수 있다. 이때 필터 태그를 사용하면서 필터 맵핑 태그와 중첩되면 안된다.*

```
<filter>...</filter>
<filter-mapping>...<filter-mapping>
<filter>...</filter>
<filter-mapping>...</filter-mapping>
```

이와 같이 중첩해서 사용하면 정상적으로 인식되지 않는다. 필터 클래스 여러 개를 등록할 때는 다음과 같이 동일한 태그를 연속해서 작성하기 바란다.

```
<filter>...</filter>
<filter>...</filter>
<filter-mapping>...</filter-mapping>
<filter-mapping>...</filter-mapping>
```

이 원칙은 서블릿 태그와 서블릿 매핑 태그에서도 동일하게 적용된다.


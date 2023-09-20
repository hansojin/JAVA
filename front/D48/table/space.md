# Margin과 Padding 차이

* Margin: Object와 화면과의 여백(외부여백)
* Padding: Object 내의 내부여백

<img width="223" alt="padding_margin" src="https://github.com/hansojin/JAVA/assets/112622663/8c7c76d1-e151-4fba-874e-f5a1b2428c9f">

개발자 도구에서 많이 보이던 이 그림으로 다시 설명하자면, 

* **Margin** 은 Border 바깥쪽을 차지한다. **주변 요소와 거리를 두기 위한 영역** 이다.
* **Padding** 은 Content와 Border 사이의 여백을 나타낸는 영역이다. Content 영역이 배경색이나 배경 이미지를 가질 때, 이 Padding 영역까지도 영향을 미친다. 즉, Padding 영역도 **Content의 연장** 으로 볼 수 있다.
* Content는 요소의 실제 내용을 포함하는 영역으로, 내용의 너비 및 높이를 나타낸다.
    * Border는 Content 영역을 감싸는 테두리 선이다.
    

### 그 외의 차이점?
* 음수값: Margin만 적용 가능
* auto: Margin만 적용 가능

---

## Margin과 Padding의 사용법

1. 속성 4개 사용
    * 시계방향(위, 오른쪽, 아래, 왼쪽) 순서로 값을 주면 된다.
        * 예: margin: 10px 5px 10px 5px

2. 속성 2개 사용
    * 2개의 속성만 사용할 경우, 첫번째 값은 위와 아래 / 두번째 값은 오른쪽과 왼쪽 여백을 의미한다.
        * 예: margin: 10px 5px

3. 속성 1개 사용
    * 1개의 속성만 사용할 경우, 위, 오른쪽, 아래, 왼쪽 모두 같은 값을 사용하게 된다.

4. padding 속성 1개 사용
    * 패딩의 1개 속성만 사용할 경우, 안쪽여백이 변경된다.
        * 예: padding: 20px

5. 단일 속성 부여
    * 위, 오른쪽, 아래, 왼쪽 중 하나에만 값을 부여하고 싶은 경우, 하단과 같이 방향을 지정해주면 된다.
        * 예: margin-right: 20px, padding-top: 10px

6. 가운데 정렬
    * auto를 이용한다. padding은 auto값 선언 불가.
        * 예: margin: auto
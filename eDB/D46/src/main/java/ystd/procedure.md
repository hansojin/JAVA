## create procedure 

stored procedure란, sql server에서 제공되는 프로그래밍 기능

즉, 쿼리문의 집합으로써 어떠한 동작을 일괄 처리하는 용도로 사용 (like method)

---

* 프로시저 생성 구문

```
CREATE PROCEDURE [프로시저명] ( [파라미터] )
AS 
BEGIN
	[쿼리문]
END
```

* 프로시저 생성 예제

```
CREATE PROCEDURE CREATE_BOOK(
	@NAME NVARCHAR(100),	--제목
	@PUBLISHER NVARCHAR(50),	--출판사	
	@AUTHOR NVARCHAR(50),	-- 저자
	@RETURN_CODE VARCHAR(1)	OUTPUT	--성공:S 오류:E
)
AS
BEGIN
	SET NOCOUNT ON 	-- 결과 적용된 행의 개수를 표시 하지 않도록 하는 옵션
	BEGIN TRY
		BEGIN TRAN -- 트랜젝션 시작
		INSERT INTO TBL_BOOK(NAME,PUBLISHER,AUTHOR)
		VALUES (@NAME,@PUBLISHER,@AUTHOR)
		COMMIT TRAN -- 커밋
		SET @RETURN_CODE = 'S'
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		SET @RETURN_CODE = 'E'
	END CATCH
	SET NOCOUNT OFF
END;
```

* 프로시저 호출 구문

```
`exec`+[프로시저명]+[파라미터]
```
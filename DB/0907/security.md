### 보안 설정

* user(root) pw 변경
    * alter user root@localhost identified with mysql_native_password by '변경할 pw';
* 사용자 생성
    * MySQL에서 사용자를 생성하는 방법은 command 방법과 GUI 방법(MySQL Administrator)이 있음
        * create user 사용자명 identified by '비밀번호';
* 사용자 권한 부여
    * grant all privileges on 데이터베이스명.* to 사용자명;
    * grant 부여할 권한 SQL 명령문 on 데이터베이스명. * to 사용자명;
        * sql 명령문 : select, insert, update, delete 
* 사용자 권한 회수
    * revoke SQL 명령문 on DB명. * from '해당유저이름';
* *(cf)MySQL flush privileges* 
    * INSERT나 UPDATE, DELETE문을 이용해서 MySQL의 사용자를 추가,삭제하거나, 사용자 권한 등을 변경하였을 때, MySQL에 변경사항을 적용하기 위해서 사용하는 명령어가 flush privileges
    * 정확히 말하면 grant 테이블을 reload 함으로 변경사항을 바로 적용해주는 명령어인데, INSERT, DELETE, UPDATE와 같은 SQL문이 아닌 grant 명령어를 사용해서 사용자를 추가하거나 권한등을 변경하였다면 굳이 실행할 필요가 없다
* 사용자 삭제
    * "user" 테이블과 "db" 테이블에서 완전히 해당유저를 삭제하는 경우
        * drop user '해당유저이름';
    * "user" 테이블에서 사용자를 삭제하는 경우
        * delete from user where user='해당유저이름';
    * "db" 테이블에서 해당유저에게 부여된 데이터베이스의 권한을 삭제한 경우
        * delete from db where user='해당유저이름';
* 권한 확인
    * mysql.db 에서 확인 가능
        * desc mysql.db;
        * select host, db, user, select_priv from mysql.db;


---

### 테이블과 데이터 사전

* MySQL은 데이터베이스와 작업에 대한 정보를 데이터 사전이라는 테이블 집합에 모아두었고, 이러한 테이블의 소유자는 "root" 사용자이다.
* 테이블 및 데이터 사전 정보 보기
    * use information_schema;
    * show tables;
    * use mysql;
    * show tables;
    * desc user;
* mysql.user 테이블의 컬럼 설명
    * Select_priv   : select문을 수행할 수 있는 권한
    * Insert_priv   : insert문을 수행할 수 있는 권한
    * Update_priv   : update문을 수행할 수 있는 권한
    * Delete_priv   : delete문을 수행할 수 있는 권한
    * Create_priv   : create문을 수행하거나 테이블을 생성할 수 있는 권한
    * Drop_priv     : drop문을 수행하거나 데이타베이스를 삭제할 수 있는 권한
    * Reload_priv   : mysqladmin reload명령을 이용하여 접근정보를 다시 읽을 수 있는 권한
    * Shutdown_priv : mysqladmin shutdown명령을 이용하여 서버를 종료시킬 수 있는 권한
    * Process_priv  : 서버 프로세스를 관리할 수 있는 권한
    * File_priv     : select into outfile과 load data infile과 같은 명령을 이용하여 파일에 읽고 쓸 수 있는 권한
    * Grant_priv    : 자신의 권한을 남에게 부여할 수 있는 권한
    * References_priv : 사용하지 않음
    * Index_priv    : 인덱스를 만들거나 삭제할 수 있는 권한 
    * Alter_priv    : alter table문을 수행할 수 있는 권한

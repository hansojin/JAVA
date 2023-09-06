**사용자 계정 추가하기**

[실습 따라하기]

1. MySQL 접속 

    windows키 + r

    mysql -u root -p

    1234

2. 새로운 데이터 베이스 생성

    create database my_database;

3. 생성된 Database 확인

    show databases;

4. 사용자 생성 및 권한 부여(한번만)

    mysql> CREATE USER 'root'@'%' IDENTIFIED BY '1234';

    mysql> GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;


    권한 부여시 WITH GRANT OPTION  구문은 다른 사람에게 부여한 권한을 또 다른 사람에게 줄 수 있는 옵션

    즉 A 사용자의 권한을 B에게 주면 B는 C에게 줄 수 있게 하고 싶을 때 사용.

    mysql>create user test_user@localhost identified by '1234';

    mysql>grant all privileges on my_database. * to test_user@localhost;

    mysql -h[host IP] -u[username] -p[databaseName]

[실습하기]

1. 특정 사용자 계정으로 MySQL 접속하기

    윈도우 키 + R

    mysql -u test_user -p my_database

    1234

---

**데이터베이스 생성, 선택, 삭제**

[실습 따라하기]

1. MySQL 접속하기

    mysql -u root -p

2. 데이터베이스 생성하기

    create database my_database2;

3. 데이터베이스 확인하기

    show databases;

4. 데이터베이스 선택하기

    use my_database;

5. 데이터베이스 변경하기

    use my_database2;

6. 데이터베이스 삭제하기

    drop database my_database2;

7. 데이터베이스 확인하기

    show databases;

---

**테이블 생성, 수정, 삭제**

[실습 따라하기]

1.MySQL 접속하기

    mysql -u test_user -p my_database

2. 테이브 생성하기
```
    create table example(
        name varchar(10),
        phone varchar(15),
        id varchar(10),
        city varchar(10)
    );
```
3. 테이블 확인하기
    show tables;

[실습 따라하기]

1. 테이블 생성하기
```
    create table example2(
        name varchar(10),
        phone varchar(15),
        id varchar(10),
        city varchar(10)
    );
```
2. e_mail열 추가하기 varchar(20)

    alter table example2 add e_mail varchar(20);

3. 테이블 내용 확인하기

    desc example2;

4. city 열 삭제하기

    alter table example2 drop city;

5. 테이블 내용 확인하기

    desc example2;

6. 열 변경하기(id 열을 id_number로 바꿈)

    alter table example2 change id id_number varchar(10);

7. 테이블 내용 확인하기

    desc example2;

[실습 따라하기]

1. 테이블 삭제하기

    drop table example2;

2. 테이블 확인하기

    show tables;

---

**데이터 삽입**

[실습 따라하기]

1. 데이터 삽입

    insert into example(name, phone, id, city) values('홍길동', '031-252-1123', '102', '수원');

2. 데이터 확인

    select * from example;

3. 데이터 추가 삽입

    insert into example(name, phone, id, city) values('이말자', '02-231-1568', '103', '서울');

    insert into example(name, phone, id, city) values('이고순', '042-856-9763', '104', '대전');

4. 데이터 확인

    select * from example;

---

**데이터 검색**

[실습 따라하기]

1. 이름이 홍길동인 사람 검색하기
    select * from example where name='홍길동';

2. ID가 103 이상인 사람 검색하기

    select * from example where id>=103;

3. 대전에 사는 사람 검색하기

    select * from example where city='대전';

4. 대전 또는 수원에 사는 사람 검색하기

    select * from example where city='대전' or city='수원';

---

**입력 데이터 변경 및 삭제**

[실습 따라하기]

1. 홍길동의 거주 도시를 뉴욕으로 변경하기

    update example set city='뉴욕' where name='홍길동';

2. 데이터 변경 확인하기

    select * from example;

3. 이름이 이고순인 사람의 데이터 삭제하기

    delete from example where name='이고순';

4. 데이터 변경 확인하기

    select * from example;

---

**유저 목록 보기**

select host, user from mysql.user;

```
# 유저 생성 관련
select host, user from mysql.user;

create user test_user@localhost identified by '1234';	# localhost에서만 접속가능
create user 'test_user'@'%' identified by '1234';	# 모든 곳에서 접속 가능

drop user test_user;
select host, user from mysql.user;
drop user test_user@localhost;
select host, user from mysql.user;
```


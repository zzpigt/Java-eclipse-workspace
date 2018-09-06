# DBA（数据库管理员）必修

这个题目主要是为了醒目，总结都是数据库高手必须知道的一些知识，或者说一些招式，这些招式可能已经老套到不怎么用到，但是一定要知道，为了以后的‘知己知彼’。
## 事务（Transaction）
事务就是作为一个独立单元由一条或者多条SQL语句组成，这个单元的每一条SQL语句都是相互依赖的。要求必须每一条SQL语句都成功执行，才可以说这个事务成功的执行了，如果有一条语句执行出错，那么整个事务就会回滚，回到事务开始之前的状态。

事务的特点：ACID(记这些特点，我个人感觉你还不如知道ACID这个缩写的含义来的更有用，装逼就需要-_-)
-  原子性（Atomicity）:
事务的多条SQL语句是一个不可分割的完整逻辑单元
-  一致性（Consistency）: 
事务中的每条SQL语句要么都是成功执行的, 要么都失败了
  如果一个事务成功执行了, 那么里面的每一条SQL语句都成功执行了
  如果一个事务失败了, 那么里面的每一条SQL语句都失败了
- 隔离性（Isolation）:
  不同的事务是相互隔离的
  不同的事务相互访问的时候
  得到的数据要么是事务发生以前的数据
  要么是事务发生以后的数据
-  持久性（Durability）:
 一旦事务完成提交, 对数据的修改就是永久的
>说了那么多，举个例子：
>张三给李四转账100元，前提是有一个数据(bank)表存储着A和B的账户

uname|money
---|---:
张三|500
李四|0

```sql
#打开事务，这是一个事务的开始
START TRANSACTION;
UPDATE bank SET money = money - 100 WHERE uname = '张三';
UPDATE bank SET money = money + 100 WHERE uname = '李四';
#保存到s1
SAVEPOINT s1;
INSERT INTO bank VALUES ('王五', 500);
#回滚到s1
ROLLBACK TO s1;
INSERT INTO bank VALUES ('赵六', 600);
INSERT INTO bank VALUES ('田七', 700);
#提交事务，这个事务也就结束了
COMMIT;
```
最后上面的执行结果：

uname|money
---|---:
张三|400
李四|100
赵六|600
田七|700

## 索引 (Index)
这就是提高查询效率的数据库对象，通过关联关键字的方式提高查询效率，像是一本书的目录。注意一点的是：数据库会自动为主键和唯一列（设置该字段为唯一值约束的列）添加索引。
提高查询的效率，首先要知道一个被查询的数据从数据库到客户端的内存中是一个很耗时的过程，找到这个查询的过程中的效率瓶颈，那么就要需要在这里解决它，怎么解决从磁盘读取的次数呢？这里就要提到题目上写的[B树](https://baike.baidu.com/item/B%E6%A0%91/5411672)，极大的减少了读取的次数。InnoDB引擎默认使用B树的索引结构。
这种索引结构缺点也很明显，就是无法将超大型的数据不能一次读进内存，重复值多的字段不能使用。
索引适用在：
- 经常出现在where子句中的字段
- 经常出现在group by子句中的字段
- 重复值很少的字段
```sql
#给student表中的age字段加索引
CREATE INDEX i_age ON student(age);
#这种效率的提升小数据感觉不到
SELECT * FROM student WHERE age = 18;
#删除age索引
DROP INDEX i_age ON student;
```

## 视图（VIEW）
 一张或多张表的数据子集的逻辑表现，视图不是表，不是一个物理的实体，只是一个逻辑表现。视图的数据是来源于表的，而视图的本质就是子查询。
 这里视图分为 **简单视图** 和 **复杂视图** ，前者是不包含分组，函数，表达式，只进行单表查询，允许DML操作。后者可以包含分组，函数，表达式，可以进行多表查询，不一点允许DML操作。
 视图的作用：
- 对数据安全保护（只给用户他能看到的表中那部分数据）
- 简化查询语句（牵强的作用）
- 更清晰的表达查询（新手的福利作用，也够牵强的）

```sql
#创建一个视图（简单视图）
CREATE OR REPLACE VIEW v_dep_deptno (id , name, loc)
AS
SELECT deptno,dname,loc FROM dept 
#删除一个视图
DROP VIEW v_dep_deptno;
#在这个视图中插入一条数据
INSERT INTO v_dep_deptno VALUES (50 , '许帮' , '上海');
#创建一个视图（复杂视图）
CREATE VIEW v_emp_avgsal
AS
SELECT dname,avg(sal) 
FROM emp RIGHT JOIN dept
ON emp.deptno = dept.DEPTNO
GROUP BY dname;
#这里往这个视图插入一条数据是不可行的（视图不是表，只是逻辑表现）
INSERT INTO v_emp_avgsal VALUES ('教研部',20000);
```

## 存储过程（Procedure）
一个存储过程就是一个可编程的函数，存储在数据库中，可以由一条或多条SQL语句组成。第一次编译后再次调用就不需要再次编译了， **存储过程** 作为对象在数据库中非常重要。现在很少用到，因为开发过程更多的业务逻辑都应该在后台语言中实现，而不是数据库。
存储过程和函数都非常的复杂，多重begin和end嵌套，所以这一招知道就好。
存储过程的参数类型：
- IN //参数只能进来，不能出去
- OUT//参数不能进来，只能出去
- INOUT//参数能进也能出
```sql
//创建带参数的存储过程
CREATE PROCEDURE proce2(IN p INT)
BEGIN
SELECT p;
SET p = 2;
SELECT p;
END
#存储过程的调用是用Call，要特别记住，很容易忘记
SET @p = 1;
CALL proce2(@p);
SELECT @p;
```

## 函数（Function）
这个看API就发现和 **存储过程** 很像，API中都是放一起介绍的，使用的方法也基本类似。这里说说它们的区别：其一，函数必须有返回值，存储过程没有。其二存储过程的参数可以是IN，OUT，INOUT，函数的参数是默认IN类型的，不用写。

使用函数和存储过程的好处：
- 可以实现较快的执行速度
- 实现模块化编程（这个可以理解，应该也是最重要的优点了吧）
- 可以使用控制流语句（这个我也不太理解）
- 可以作为一种安全机制来使用
- 减少网络流量


```sql
#创建一个带参数的函数，返回值是int型
CREATE FUNCTION func1(y INT) RETURNS INT
BEGIN
SET y = y +1;
RETURN y;
END
#删除函数
DROP FUNCTION func1;
#和存储过程不同，这里函数的调用需要select打印出来
SET @p = 2;
SELECT func1(@p);
SELECT @p;
```

毕竟不是专业的DBA，我的目标也就是个全栈程序猿，这里说的数据库知识也就差不多到我大学学习到的那个水平，所以这里作为我以后的知识回顾吧，有些知识在以后的工作很少碰到，也确实过时了。后面要继续修炼NoSQL知识非常强，打好了数据库基础，可以方便我修炼非关系型数据库-_-，Bye!!
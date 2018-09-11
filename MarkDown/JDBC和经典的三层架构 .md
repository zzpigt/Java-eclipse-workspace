# JDBC

JDBC技术，就是java数据库连接，按照ODBC（开放数据库连接）的模式制定的，使得java面对不同的数据库可以使用相同的API，也就是方便我们操作关系型数据库的技术。

## JDBC的组成
JDBC提供了两套接口：
- JDBC API 【面向开发人员的接口】
- JDBC Driver API 【面向底层驱动程序开发的接口】

就像解释说的一样，我们现在所需要掌握的是 **JDBC API** 开发，而这部分的编程接口，主要是用来连接数据库，访问数据库，操作数据库增删改查等，常用的比如：**DriverManager** 驱动程序管理类, 用来装载驱动程序, 为数据库连接提供支持； **Connection** 接口, 用于某一个数据库连接；**Statement** 接口, 提供了执行SQL语句并返回结果集的方法；**ResultSet** 接口, 提供了对结果集进行处理的方法
。
```java
            //运行驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接mysql数据库
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "123456");
			//拿到连接对象，拿到stat
			stat = conn.createStatement();
			//准备sql语句,拿到执行的结果集
			String sql = "select * from emp";
			eq = stat.executeQuery(sql);
			while(eq.next()) {
				System.out.println(eq.getString(6));
			}
```
当然，这样的硬编码在实际开发中肯定不会出现，耦合性太高了，通常会把连接的常量封装到一个 ***properties*** 文件中，Java提供一个 **Properties()** 类来读取这个文件的数据，文件的数据肯定是key=value形式的。然后再一个工厂模式封装好。
```java
public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String uname;
	private static String upwd;
	
	static {
		Properties properties = new Properties();
		InputStream is = ConnectionFactory.class.getClassLoader().getSystemResourceAsStream("dbconfig.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		uname = properties.getProperty("uname");
		upwd = properties.getProperty("upwd");
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
```
>这里扩展以下 **JDBC Driver API** 的一些知识，留有后用
 1. JDBC-ODBC桥

 2. 部分java技术的本地API驱动程序

 3. 全部基于java技术的本地API驱动程序

 4. 全部基于java技术的本地协议驱动程序

## 使用方法
在项目开发中，需要你导入一个 **jar** 包，在项目文件夹中，把这个包build path到这个项目中，就可以了，使用的具体方法，可以看API。

# 三层架构
这里说的三层架构，首先要明白与MVC没有一点关系。MVC是一种设计模式，目的是让HTML代码和业务逻辑代码分开，让代码看起来更加清晰，便于开发。
而三层架构是为了整个代码遵循单一职责原则和大大降低耦合的目的设计的，在我看来这是最大的优点，想比较好的理解这个架构，最好还是实例中运用。所以，我做过一个小JDBC的项目，用到了三层架构，还有一些反射的内容，jdbc的事务，非常有必要看看。这就像是你知道这是一本武功秘籍，我还给你录了视频，你有多幸运，hhhh
>实例内容：创建一个数据库jdbc，然后创建两个表，users用户表，record日志表
新建一个java项目，实现用户的注册，登入功能，登入后还有存钱，取钱，转账，常看操作记录，查看余额的一些功能。

这是项目的github地址：[jdbc小项目](https://github.com/zzpigt/Java-eclipse-workspace/tree/master/0907%20JDBC%E5%B0%8F%E9%A1%B9%E7%9B%AE)

>这个项目还有一部分没有做完，还可以完善，当然，真正尽美的代码真的很难做到，只能是将我们学习到的技能尽量运用进来。xml自动生成javaBean包中的类。

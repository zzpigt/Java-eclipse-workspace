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

## 控制反转（IOC）和依赖注入（DI）
在上述项目中我又加入了 **控制反转**，也就是 **反射** + **配置文件**。将service层中的UserServiceImpl实现类中关于‘具体’类的完整类名都放置在配置文件applicationContext.xml中，再写一个ApplicationContext类用反射拿到类对象，存储在Map中，当ApplicationContext中的init()初始化后，类的对象就已经创建了，存在Map中，反射调用set方法，对象就赋给UserServiceImpl类中的成员属性。这样设计就不再依赖于‘具体’的类。
### 控制反转（网络扒下来的一段解释，非常形象）
我们首先先来了解一下控制二字，也就是在控制“正”转的情况下，在任何一个有请求作用的系统当中，至少需要有两个类互相配合工作，在一个入口类下使用new关键字创建另一个类的对象实例，这就好比在面向对象编程的思想下，“我“充当一个入口类，在这个入口类中，我每次吃饭的时候都要买一双一次性筷子（每一次使用都要new一次），在这样的关系下，是”我“（即调用者）每次都要”主动“去买一次性筷子（另一个类），我对筷子说你老老实实的过来我的手上，是我控制了筷子，那好，在这种控制正转的关系下，放在现实生活当中，肯定是不现实的，而且人是懒惰的，他总会去创造出更加方便自己生活的想法，更确切的做法是，买一双普通的筷子（非一次性），把他放在一个容器当中（在Spring中叫做IOC容器），你需要使用的时候就对容器说：IOC我想要用筷子（向容器发出请求），接着筷子就会”注入“到的手上，而在这个过程当中，你不再是控制方，反而演变成一名请求者（虽然本身还是调用者），依赖于容器给予你资源，控制权坐落到了容器身上，于是这就是人们俗称的控制反转。

### 依赖注入
同样接着上面的例子，在控制反转的统一下，筷子是怎么来到我的手上（即我们是如何获得请求的类），这就是一个依赖注入的过程。
![di]()

### 再谈IOC与DI
设计原则中好莱坞原则描述到，**“别找我们，我们找你”** ，百度百科上对这点描述是 **“不要给我们打电话，我们会给你打电话(don‘t call us, we‘ll call you)”这是著名的好莱坞原则。在好莱坞，把简历递交给演艺公司后就只有回家等待。由演艺公司对整个娱乐项的完全控制，演员只能被动式的接受公司的差使,在需要的环节中，完成自己的演出**。这一点完美的提现了在IOC身上，IOC所注重的是设计思想上，从一个常规的创建对象的做法，即new一个对象，转变成向IOC容器递交”简历“，被动的等待IOC容器返回资源给你。控制反转即指的是”演艺公司控制演员“，而说到依赖，则是“演员需要公司混饭”，我们所需求的对象，需要依赖容器来获得，这个过程即是依赖注入。本质上IOC和DI是同一思想下不同维度的表现。
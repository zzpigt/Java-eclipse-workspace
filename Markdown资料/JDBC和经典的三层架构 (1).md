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

### dom4j解析xml
也是上面的小项目运用到的一个技巧，**dom4j** 是一个Java的XML API，是非常好用的解析XML文件的一个API。真的有时候想，以后的学习者怎么办，前人将这些需要使用的非常复杂的手段封装到一个你如果不知道原理完全看不懂的API里面，你只需要傻瓜似的看文档，知道怎么用了，也就更懒得去了解他。我们还是很幸运的，如果是叫我们自己运用java原生API去做XML的解析，不管是DOM或者SAX，至少能简单的构造出来，懂得这个基础原理。后面我会写一篇这样解析文档的博客。
使用方法很简单，首先导入这个包，附赠的doc文档也可以打开看看，里面有所有使用方法。

```java
        //url:这里放你需要解析的xml文件，拿到document
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        //然后去拿element根
        Element root = document.getRootElement();
```
这里也附上上面小项目中运用这个技术的部分代码：
```java
public static void init() {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(ApplicationContext.class.getClassLoader().getSystemResourceAsStream("applicationContext.xml"));
			Element root = document.getRootElement();
			//解析xml，存储所有的对象
			parseXml(root);
			//再解析一遍，把bean中的元素set到对象中
			di(root);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 解析xml，把所有的类的对象写入map
	 */
	private static void parseXml(Element root) {
		List<Element> list = root.elements();
		for (Element e : list) {
			String name = e.attributeValue("name");
			String className = e.attributeValue("class");
			try {
				Class<?> clazz = Class.forName(className);
				Object object = clazz.newInstance();
				beanMap.put(name, object);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}  catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			}

		}
	}
	/**
	 * 注入依赖
	 * @param root
	 */
	private static void di(Element root) {
		List<Element> list = root.elements();
		for (Element e : list) {
			List<Element> properties = e.elements();
			String bean = e.attributeValue("name");
			Object object = beanMap.get(bean);
			for (Element p : properties) {
				String pName = p.attributeValue("name");
				String pValue = p.attributeValue("value");
				// 将property的值放到对象中
				Field field;
				try {
					field = object.getClass().getDeclaredField(pName);
					setProperty(object, field, pValue);
				} catch (NoSuchFieldException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
```

### c3p0
这里说这个API之前，需要知道什么是数据库连接池，为什么需要这个连接池，不然你也就不理解它的强大之处。
#### 数据库连接池
要知道频繁的打开和关闭连接对数据库服务器有很大的压力，而且也没有必要。我们可以使用容器来管理数据库连接对象，说到底，在程序代码中，连接关闭都是调用那个对象来操作的。所以，在服务器启动的时候我们可以事先创建好一些连接对象放在连接池中，当用户每次需要使用连接对象的时候，可以先从池子里面拿，池中的对象不够的时候再做相应的处理。当用户使用连接完毕，可以归还到连接池中，这样别的用户可以继续使用，效率会极大提高。
```java
//自己写一个连接池，这个类要实现DataSource接口，可以去看看这个API，
//接口中的所有方法都需要重写，但是，这里我只截到我需要实现的方法这
public class MyDataSourcer implements DataSource {
    //创建一个LinkedList容器做存放连接的池子
	private static LinkedList<Connection> connList = new LinkedList<>();
	//这里数据库的连接使用了property配置文件来实现
	private String driver;
	private String url;
	private String uname;
	private String upwd;

	public MyDataSourcer() {
		init();
	}

	private void init() {
	    //配置文件的使用，首先拿到Properties对象
		Properties properties = new Properties();
		//再用类加载器取拿到配置文件的输入流
		InputStream is = ConnectionFactory.class.getClassLoader().getSystemResourceAsStream("dbconfig.properties");
		try {
		    //最后就用这个输入流，拿到配置文件中所有键值队的值
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		uname = properties.getProperty("uname");
		upwd = properties.getProperty("upwd");
        //这里首先放入5个数据库连接对象
		for (int i = 0; i < 5; i++) {
			connList.add(createConnection());
		}
	}
	@Override
	public Connection getConnection() throws SQLException {
		if (!connList.isEmpty()) {
			System.out.println("这是池中的对象");
			return connList.removeLast();
		} else {
			System.out.println("这是新创建的对象");
			//这里MyConnection是装饰模式对Connection其中的一些方法加强,下面会说到
			return new MyConnection(createConnection(),this);
		}
	}
    //这里是JDBC创建数据库连接
	public Connection createConnection() {
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

	public void backToConn(Connection conn) {
		System.out.println("归还了conn");
		connList.add(conn);
	}
｝
```
往往像这样复杂的代码实现，都会有高手团队做好了，可以直接拿jar包来使用。所以就有 **c3p0** 的诞生。而它的使用非常简单，导入这个jar包，然后就可以使用了？不对的，还有配置文件 **c3p0-config.xml** 需要放在src文件夹下，这个非常重要。里面存放的是你的服务器配置信息，除了基础的**driverClass**、 **jdbcUrl**、 **user**、 **password** 这些连接服务器必须配置的（而这些配置在实际开发中玩玩是property文件中），还有比如：**initialPoolSize** （初始放入连接池中的连接数量）， **maxPoolSize** （连接池的存储最大数量）等等，具体的可以去看文档。

使用的话，拿上面的小项目举例：（部分ConnectionFactory类中的代码）
```java
public class ConnectionFactory {
    //实例一个ComboPooledDataSource对象
	private static ComboPooledDataSource cds = new ComboPooledDataSource();
	/**
	这里省略property配置文件连接数据库的代码
	*/
		try {
			//loads the jdbc driver            
			cds.setDriverClass(driver);
			cds.setJdbcUrl(url);
			cds.setUser(uname);                                  
			cds.setPassword(upwd);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} 
	}
	public static Connection getConnection() {
		try {
			return cds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
```
#### 改进连接池中
自定义的连接池中往往会出现下面的问题，当然c3p0已经完美的解决这些问题，这里提出来只是加深我们对连接池原理的理解。

- 归还连接对象必须调用我们自己写的backToSource方法
- 一旦调用了连接对象的close方法，这个连接不能用了，别人拿的话就会报错

改进方案也非常简单，只要是通过连接池拿到的连接对象，调用了close方法，并不能关闭这个连接，而是归还到连接池。所以，很明显我们需要对close方法进行加强。有很多选择：1）**继承** [前提：必须要有父类]；2）**装饰模式**  [前提：必须要实现所有方法]；3）**动态代理** [前提：必要要有接口]。我们这里选择装饰模式，就是上面数据库连接池那一节的代码举例：***（重点：一定要非常了解装饰模式，这是作为java程序员必须了解的非常基础的设计模式之一）***

1. 自己写一个类实现Connection接口
2. 自己写的类关联一个Connection对象
3. 关联对象用构造器传进来
4. 增强close方法

```java
//这里要实现Connection接口中的所有的方法，这里截断到加强的close方法
public class MyConnection implements Connection{
	private Connection conn;
	private MyDataSourcer ds;

	public MyConnection(Connection conn,MyDataSourcer ds) {
		super();
		this.conn = conn;
		this.ds = ds;
	}
	@Override
	public void close() throws SQLException {
		ds.backToConn(conn);
	}
}
```

>**c3p0** 也解决了这个问题，当然里面使用是什么解决方案需要去看文档才知道。
注意：常用的数据库连接池除了 **c3p0** ，还有一个 **DBCP** 也较为常用。碰到不会用的也别害怕，无非就是导入jar包，看文档中的QuickStart罢了-。-
异常【Excption】， 表示程序运行时发生的可能会导致程序异常中断的错误，比如常见的异常：
空指针异常[NullPointerException]，数组下标越界异常[ArrayIndexOutOfBoundsException]，算数异常[ArithmeticException]，强制类型转换异常[ClassCastException]......

不过在说这个之前必须要提到它的直接父类-- **Throwable**，这个类表示java程序运行过程中发生的一切不正常事件，API中最主要也是唯一的两个直接子类就是：
* Error 错误：JVM内部发生的严重错误，一旦发生，程序不可能回到正常指令流程，如：
	* java.lang.StackOverflowError 栈溢出
	* java.lang.OutOfMemoryError 堆溢出(OOM)
* Exception 异常：运行时发生的一般错误，经过合适的处理后，还是可以回归正常的指令流程
	* RuntimeException：运行时异常，由于程序员逻辑不严谨导致，非受察异常，不强制要求处理，如：空指针异常，数组下标越界异常，算数异常，强制类型转换异常
	* 非RuntimeException： 非运行时异常,(checked)受察异常，往往是由于外部偶然因素导致，这类异常编译器强制要求你处理


## 异常的处理方式
异常的处理方式就以下两种，但是运用却可以非常灵活，往往可以利用它的特点抛出一个自己需要的异常信息，比如：`new Excption("需要的提示信息")`。
### 捕获

```java
	try {
		// 可能会发生异常的代码
	} catch (异常的类型 变量名){
		// 对异常的处理
	}
```

** 注意：如果有父子关系，要把父类写在后面**

```java
	try{
        // 可能会发生异常的代码
	} catch(异常类型1 e){
        // 对异常的处理
	} catch(异常类型2 e){
        // 对异常的处理
	} ... catch (Exception e){
        // 对异常的处理
	}
```
还有一种最重要的写法：

```java
	try{
		// 有可能会发生异常的代码块
	}catch(){
		// 捕获到了异常之后，用来处理异常的代码块
		// 不允许出现有异常隐患的代码
	}finally{
		// 无论有没有发生异常，都会执行的代码块
		// 不允许出现有异常隐患的代码
	}
	
	//try-finally
	try{

	} finally{

	}
```

### 抛出
举个例子帮助我们区分一下 **捕获** 和 **抛出** 的概念：A让B做一件事，但是这件事情有风险，可能会损失100块钱。如果发生了这个问题，B选择自己掏钱，叫做捕获；如果B自己不掏钱，那么A就要掏出100块钱处理异常，这叫做抛出（B把异常抛给了A）。

**throw**	抛出一个异常对象（语句）
**throws** 声明该方法可能会抛出一个异常（声明）

好好体会这句话：***如果声明的是抛出非运行时异常，那么调用此方法的地方就必须要处理这个异常；如果声明的是抛出运行时异常，就相当于没写***。

```java
public class Demo {
	public static void main(String[] args) {
		try {
			test1();
		} catch (Exception e) {
			System.out.println("catch捕获并处理了异常！！");
		}
		test2();
		System.out.println("程序正常运行！！");
	}
	
	public static void test1() throws Exception {
		//这里其实是抛出的非运行时异常
		throw new Exception();
	}
	
	public static void test2() {
		//运行时异常可以不用声明，这类异常是程序员逻辑不严谨产生
		throw new RuntimeException();
	}
}
```

>  注意：声明会抛出异常的方法，有可能会抛出异常,也有可能不抛出异常

## 自定义异常
往往会把发生不同原因的异常划分为不同的类型，在java API中已经有很多异常类型了（真的非常多--）。但是有时候还是不足以解决实际开发中遇到的异常。

比如给一个学生设置年龄的时候，设置 `-5岁` 就显然是一种异常，那么就很适合自定义异常：
自己写一个异常类型，然后继承于Exception或RuntimeException。

好处也非常明显了，给不同原因导致的异常分成不同的类型，便于管理和解决。

## 总结
也好好体会这几句话：
 1. 运行时异常，不允许使用try-catch，在前面加上if判断解决
 2. 非运行时异常，要么捕获，那么抛出
 3. 底层/业务逻辑层的所有异常，全部抛出


# 自定义Annotation
###### 一、概念
* Annontation是Java5开始引入的新特征。中文名称一般叫注解。它提供了一种安全的类似注释的机制，用来将任何的信息或元数据（metadata）与程序元素（类、方法、成员变量等）进行关联。更通俗的意思是为程序的元素（类、方法、成员变量）加上更直观更明了的说明，这些说明信息是与程序的业务逻辑无关，并且是供指定的工具或框架使用的。Annontation像一种修饰符一样，应用于包、类型、构造方法、方法、成员变量、参数及本地变量的声明语句中。
* Annotation其实是一种接口。通过Java的反射机制相关的API来访问annotation信息。相关类（框架或工具中的类）根据这些信息来决定如何使用该程序元素或改变它们的行为。
* annotation是不会影响程序代码的执行，无论annotation怎么变化，代码都始终如一地执行。
* Java语言解释器在工作时会忽略这些annotation，因此在JVM中这些annotation是“不起作用”的，只能通过配套的工具才能对这些annontaion类型的信息进行访问和处理。
###### 二、原理
* Annotation其实是一种接口。通过Java的反射机制相关的API来访问annotation信息。相关类（框架或工具中的类）根据这些信息来决定如何使用该程序元素或改变它们的行为。
* annotation是不会影响程序代码的执行，无论annotation怎么变化，代码都始终如一地执行。
* Java语言解释器在工作时会忽略这些annotation，因此在JVM	中这些annotation是“不起作用”的，只能通过配套的工具才能对这些annontaion类型的信息进行访问和处理。
###### Annotation与interface的异同：
* 1）、Annotation类型使用关键字@interface而不是interface。这个关键字声明隐含了一个信息：它是继承了java.lang.annotation.Annotation接口，并非声明了一个interface
* 2）、Annotation类型、方法定义是独特的、受限制的。Annotation类型的方法必须声明为无参数、无异常抛出的。这些方法定义了annotation的成员：方法名成为了成员名，而方法返回值成为了成员的类型。
方法返回值类型必须为primitive类型、Class类型、枚举类型、annotation类型或者由前面类型之一作为元素的一维数组。
方法的后面可以使用default和一个默认数值来声明成员的默认值，null不能作为成员默认值，这与我们在非annotation类型中定义方法有很大不同。Annotation类型和它的方法不能使用annotation类型的参数、成员不能是generic。只有返回值类型是Class的方法可以在annotation类型中使用generic，因为此方法能够用类转换将各种类型转换为Class。
* 3）、Annotation类型又与接口有着近似之处 它们可以定义常量、静态成员类型（比如枚举类型定义）。Annotation类型也可以如接口一般被实现或者继承。
###### 三、作用
* a. 标记，用于告诉编译器一些信息
* b. 编译时动态处理，如动态生成代码
* c. 运行时动态处理，如得到注解信息

###### 四、应用场合
　　annotation一般作为一种辅助途径，应用在软件框架或工具中，在这些工具类中根据不同的 annontation注解信息采取不同的处理过程或改变相应程序元素（类、方法及成员变量等）的行为。
　　例如：Junit、Struts、Spring等流行工具框架中均广泛使用了annontion。使代码的灵活性大提高。
***
* 1 Annotation需要声明为@interface这样的东西
* 2 @Target(ElementType.TYPE)
代码这个annotation必须且一定要注释在什么语句上面
ElementType.TYPE代表此Annotation必须声明在public class Student{…}的上面，而不能写在任何的method{}（方法）或者是field（属性）的上方。
    * @Target:  表示该注解可以用于什么地方。可用ElementType枚举类型主要有：
        * TYPE : 类、接口或enum声明
        * FIELD: 域(属性)声明
        * METHOD: 方法声明
        * PARAMETER: 参数声明
        * CONSTRUCTOR: 构造方法声明
        * LOCAL_VARIABLE:局部变量声明
        * ANNOTATION_TYPE:注释类型声明
        * PACKAGE: 包声明
* 3 Retention如果设为了RUNTIME，代表此annotation的具体实现可以在运行时用类反射来实现我们看到了，annotation一般为一个@interface，也没啥具体的implementation(实现)怎么实现这个annotation呢？类反射
    * @Retention: 表示需要在什么级别保存该注解信息。可用RetentionPolicy枚举类型主要有：
        * SOURCE: 注解将被编译器丢弃。
        * CLASS  :  注解在class文件中可能。但会被VM丢弃。
        * RUNTIME: VM将在运行时也保存注解(如果需要通过反射读取注解，则使用该值)。
* 4 @Documented:  将此注解包含在Javadoc中。

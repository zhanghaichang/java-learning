# Java 多线程 学习笔记
* Thread
```java
// 创建一个正则表达式模式，用以匹配一个单词（\b=单词边界）
		// 用于测试的输入字符串
		///\d{2}\./
		//\\d+(?=\\.\\d+)
		String input = "100,34,2343.230";
		System.out.println(input);
		input=input.replaceAll("\\d{2}\\.\\d{3}","00.000");
		//if banlance <100;
		System.out.println(input);
```

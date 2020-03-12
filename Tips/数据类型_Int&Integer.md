1 byte = 8 bits (-128,127)
```
short: 2 byte   char:   2 byte
int:   4 byte   float:  4 byte
long:  8 byte   double: 8 byte
```

int a;     (a=0)     基本数据类型\
Integer x; (x=null)  对象

```int a = 3;
int b = 3;
a == b -> true

Integer x = 130;
Integer y = 130;
x.equals(y) -> true;
x == y -> false
当x, y属于-128-127之间时，x==y -> true
```
//string -> int/long/……\
```String s = "123";
Integer.parseInt(s);
Long.parseLong(s);
```
//Integer/long/…… -> String\
x.toString();


Integer.valueOf(s) \
多次解析相同的一个字符串时，得到的是Integer类型的对象，得到的对象有时是同一个对象，有时是不同的对象，
要根据把s字符串解析的整数值的大小进行决定：
如果s字符串对应的整数值在 -128~127之间，则解析出的Integer类型的对象是同一个对象；
如果s字符串对应的整数值不在-128~127之间，则解析出的Integer类型的对象不是同一个对象。不管对象是否相等，对象中的value值是相等的。

Integer.parseInt(s)是把字符串解析成int基本类型，
Integer.valueOf(s)是把字符串解析成Integer对象类型，其实int就是Integer解包装，Integer就是int的包装，

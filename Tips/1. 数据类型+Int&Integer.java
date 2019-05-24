1 byte = 8 bits (-128,127)
short: 2 byte   char:   2 byte
int:   4 byte   float:  4 byte
long:  8 byte   double: 8 byte


int a;     (a=0)     基本数据类型
Integer x; (x=null)  对象

int a = 3;
int b = 3;
a == b -> true

Integer x = 130;
Integer y = 130;
x.equals(y) -> true;
x == y -> false
当x, y属于-128-127之间时，x==y -> true

//string -> Integer/long/……
String s = "123";
Integer.parseInt(s);
Long.parseLong(s);

//Integer/long/…… -> String
x.toString();

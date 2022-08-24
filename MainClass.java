import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
String t4;
double a;
double b;
String t1;
String t2;
boolean isx;
String t3;
t1 = "oi";
t2 = "tudo";
t3 = "bem";
t4 = "com";
isx = false;
if (true) {
System.out.println("sou verdadeiro");}
a = 1;
b = 2;
if (a>b) {
System.out.println(a);}else {
System.out.println(b);}

t1 = "teste";
System.out.println(a);
System.out.println(b);
switch (t4) {
case "oi":
t1 = t2+t3;System.out.println(t1);
break;
case "tudo":
a = a+1;System.out.println(a);
break;
case "bem":
b = b+1;System.out.println(b);
break;
case "com":
a = a+b;
break;
}
while(isx) {
	System.out.println(a);	a = a+1;}

  }}
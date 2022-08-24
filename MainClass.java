import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
double a;
double b;
String t1;
String t2;
String t3;
t1 = _key.nextLine();
t2 = _key.nextLine();
t3 = _key.nextLine();
a = _key.nextDouble();
b = _key.nextDouble();
System.out.println(a);
System.out.println(b);
switch (a) {
case 1:
t1 = t2+t3;System.out.println(t1);
break;
case 2:
a = a+1;System.out.println(a);
break;
case 3:
b = b+1;System.out.println(b);
break;
case 4:
a = a+b;
break;
}
while(b>a) {
	System.out.println(a);	a = 3;}

if (t1>t2) {
System.out.println(t1);}else {
System.out.println(t2);}

  }}
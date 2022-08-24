import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
double a;
double b;
String t;
double resultado;
boolean loop;
loop = true;
t = "0";
System.out.println("Digite dois numeros");
System.out.println("Primeiro numero ");
a = _key.nextDouble();
System.out.println("Segundo numero ");
b = _key.nextDouble();
while(loop) {
	System.out.println("Escolha uma operacao de acordo com o numero");
	System.out.println("1 soma");
	System.out.println("2 subtracao");
	System.out.println("3 multiplicacao");
	System.out.println("4 divisao");
	System.out.println("5 sair");
	t = _key.nextLine();
	switch (t) {
	case "1":
		resultado = a+b;
		System.out.println(resultado);
		break;
	case "2":
		resultado = a-b;
		System.out.println(resultado);
		break;
	case "3":
		resultado = a*b;
		System.out.println(resultado);
		break;
	case "4":
		resultado = a/b;
		System.out.println(resultado);
		break;
	case "5":
		loop = false;
		break;
}
}

System.out.println("Obrigado pelo projeto");
  }}
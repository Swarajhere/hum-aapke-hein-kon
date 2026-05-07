// // =========================
// // FILE: Calc.java
// // =========================

// import java.rmi.*;

// public interface Calc extends Remote {

// int add(int a, int b) throws RemoteException;

// int sub(int a, int b) throws RemoteException;

// int mul(int a, int b) throws RemoteException;

// int div(int a, int b) throws RemoteException;

// int power(int a) throws RemoteException;

// double ctof(double c) throws RemoteException;

// double mtokm(double m) throws RemoteException;

// String echo(String name) throws RemoteException;

// String compare(String a, String b) throws RemoteException;

// int vowels(String str) throws RemoteException;

// int factorial(int n) throws RemoteException;
// }

// // =========================
// // FILE: CalcImpl.java
// // =========================

// import java.rmi.*;
// import java.rmi.server.*;

// public class CalcImpl extends UnicastRemoteObject implements Calc {

// CalcImpl() throws RemoteException {
// super();
// }

// // 1.1 Addition
// public int add(int a, int b) {
// return a + b;
// }

// // 1.4 Subtraction
// public int sub(int a, int b) {
// return a - b;
// }

// // 1.2 Multiplication
// public int mul(int a, int b) {
// return a * b;
// }

// // 1.3 Division
// public int div(int a, int b) {
// return a / b;
// }

// // 1.5 Power
// public int power(int a) {
// return a * a;
// }

// // 1.6 Celsius to Fahrenheit
// public double ctof(double c) {
// return (c * 9 / 5) + 32;
// }

// // 1.7 Miles to Kilometer
// public double mtokm(double m) {
// return m * 1.609;
// }

// // 1.8 Echo Server
// public String echo(String name) {
// return "Hello " + name;
// }

// // 1.9 Compare Strings
// public String compare(String a, String b) {
// if (a.compareTo(b) > 0)
// return a;
// else
// return b;
// }

// // 1.10 Count Vowels
// public int vowels(String str) {

// int count = 0;

// str = str.toLowerCase();

// for (int i = 0; i < str.length(); i++) {

// char ch = str.charAt(i);

// if (ch == 'a' || ch == 'e' || ch == 'i'
// || ch == 'o' || ch == 'u') {
// count++;
// }
// }

// return count;
// }

// // 1.11 Factorial
// public int factorial(int n) {

// int fact = 1;

// for (int i = 1; i <= n; i++)
// fact *= i;

// return fact;
// }
// }

// // =========================
// // FILE: Server.java
// // =========================

// import java.rmi.*;

// public class Server {

// public static void main(String args[]) {

// try {

// CalcImpl obj = new CalcImpl();

// Naming.rebind("Calc", obj);

// System.out.println("Server Ready...");

// } catch (Exception e) {

// System.out.println(e);
// }
// }
// }

// // =========================
// // FILE: Client.java
// // =========================

// import java.rmi.*;
// import java.util.*;

// public class Client {

// public static void main(String args[]) {

// try {

// Calc obj = (Calc) Naming.lookup("rmi://localhost/Calc");

// Scanner sc = new Scanner(System.in);

// System.out.println("========= MENU =========");
// System.out.println("1. Addition");
// System.out.println("2. Multiplication");
// System.out.println("3. Division");
// System.out.println("4. Subtraction");
// System.out.println("5. Power");
// System.out.println("6. Celsius to Fahrenheit");
// System.out.println("7. Miles to Kilometer");
// System.out.println("8. Echo Server");
// System.out.println("9. Compare Strings");
// System.out.println("10. Count Vowels");
// System.out.println("11. Factorial");

// System.out.print("\nEnter Choice: ");
// int ch = sc.nextInt();

// switch (ch) {

// case 1:
// System.out.print("Enter two numbers: ");
// int a = sc.nextInt();
// int b = sc.nextInt();

// System.out.println("Addition: "
// + obj.add(a, b));
// break;

// case 2:
// System.out.print("Enter two numbers: ");
// a = sc.nextInt();
// b = sc.nextInt();

// System.out.println("Multiplication: "
// + obj.mul(a, b));
// break;

// case 3:
// System.out.print("Enter two numbers: ");
// a = sc.nextInt();
// b = sc.nextInt();

// System.out.println("Division: "
// + obj.div(a, b));
// break;

// case 4:
// System.out.print("Enter two numbers: ");
// a = sc.nextInt();
// b = sc.nextInt();

// System.out.println("Subtraction: "
// + obj.sub(a, b));
// break;

// case 5:
// System.out.print("Enter number: ");
// a = sc.nextInt();

// System.out.println("Power: "
// + obj.power(a));
// break;

// case 6:
// System.out.print("Enter Celsius: ");
// double c = sc.nextDouble();

// System.out.println("Fahrenheit: "
// + obj.ctof(c));
// break;

// case 7:
// System.out.print("Enter Miles: ");
// double m = sc.nextDouble();

// System.out.println("Kilometers: "
// + obj.mtokm(m));
// break;

// case 8:
// sc.nextLine();

// System.out.print("Enter Name: ");
// String name = sc.nextLine();

// System.out.println(obj.echo(name));
// break;

// case 9:
// sc.nextLine();

// System.out.print("Enter first string: ");
// String s1 = sc.nextLine();

// System.out.print("Enter second string: ");
// String s2 = sc.nextLine();

// System.out.println("Largest String: "
// + obj.compare(s1, s2));
// break;

// case 10:
// sc.nextLine();

// System.out.print("Enter String: ");
// String str = sc.nextLine();

// System.out.println("Vowel Count: "
// + obj.vowels(str));
// break;

// case 11:
// System.out.print("Enter number: ");
// int n = sc.nextInt();

// System.out.println("Factorial: "
// + obj.factorial(n));
// break;

// default:
// System.out.println("Invalid Choice");
// }

// sc.close();

// } catch (Exception e) {

// System.out.println(e);
// }
// }
// }
package junit;
import java.util.Scanner;
public class test {
    public static class Main {
		public static void main(String[] args){
	   	 while(true){
	   		 System.out.print("输入三角形的三条边，以空格分开");
	   		 Scanner scanner = new Scanner(System.in);
	   		 int a = scanner.nextInt();
	   		 int b = scanner.nextInt();
	   		 int c = scanner.nextInt();
	   		 System.out.println(triangle(a,b,c));
	   	 }
	    }
		
	public static String triangle(int a,int b,int c){
		if(c < a+b && a < b+c && b < a+c){
			if(a != b&&b != c&&a != c)
				return "输入的三角形为“不规则三角形”";
			else if(a == b&& b == c)
				return "输入的三角形为“等边三角形”";
			else {
				return "输入的三角形为“等腰三角形”";
			}
		}
		return null;
	}
	}

}

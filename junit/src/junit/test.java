package junit;
import java.util.Scanner;
public class test {
    public static class Main {
		public static void main(String[] args){
	   	 while(true){
	   		 System.out.print("���������ε������ߣ��Կո�ֿ�");
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
				return "�����������Ϊ�������������Ρ�";
			else if(a == b&& b == c)
				return "�����������Ϊ���ȱ������Ρ�";
			else {
				return "�����������Ϊ�����������Ρ�";
			}
		}
		return null;
	}
	}

}

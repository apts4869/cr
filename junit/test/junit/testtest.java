package junit;

import org.junit.Test;
import junit.test.Main;
import junit.framework.TestCase;

public class testtest extends TestCase{
     Main main = new Main();
     String equilateral = "�����������Ϊ�ȱ�������";
     String isosceles = "�����������Ϊ����������";
     String scalene = "�����������Ϊ������������";
     String error = "����������";
     String res;
     
     @Test
     public void test1(){
    	 res = Main.triangle(3, 4, 5);
    	 assertEquals(scalene,res);
     }
     @Test
     public void test2(){
    	 res = Main.triangle(1, 1, 1);
    	 assertEquals(equilateral,res);
     }
     @Test
     public void test3(){
    	 res = Main.triangle(2, 3, 3);
    	 assertEquals(isosceles,res);
     }
     public void test4(){
    	 res = Main.triangle(2, 3,1);
    	 assertEquals(error,res);
     }
     
}

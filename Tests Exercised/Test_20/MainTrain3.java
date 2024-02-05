


import java.util.Random;
import java.util.function.Predicate;

public class MainTrain3 {

	
	public static void main(String[] args) {
		
		Random r=new Random();
		int b = 50+r.nextInt(100);
		int t = b+r.nextInt(100);
		
		for(int i=0;i<2;i++){
			int v = r.nextInt(300);
			Predicate<Integer> pi=Interpreter.or(x->x<b , x->x<t, x->x%2==0);
			boolean ans = v<b || v<t || v%2==0;
			boolean res = pi.test(v);
			if(res!=ans)
				System.out.println("problem with OR method (-1)");
		}
		
		for(int i=0;i<3;i++){
			int v = r.nextInt(300);
			Predicate<Integer> pi=Interpreter.or(x->x%2==0);
			boolean ans = v%2==0;
			boolean res = pi.test(v);
			if(res!=ans)
				System.out.println("problem with OR method (-1)");
		}
		
		for(int i=0;i<5;i++){
			int v = r.nextInt(300);
			Predicate<Integer> pi=Interpreter.and(x->x%2==0 , x->x<t);
			boolean ans = v%2==0 && v<t;
			boolean res = pi.test(v);
			if(res!=ans)
				System.out.println("problem with AND method (-1)");
		}
		
		for(int i=0;i<5;i++){
			int v = r.nextInt(300);
			Predicate<Integer> pi=Interpreter.xor(x->x%2==0 , x->x%3==0, x->x%5==0);
			boolean ans = v%2==0;
			ans^= v%3==0;
			ans^= v%5==0;
			boolean res = pi.test(v);
			if(res!=ans)
				System.out.println("problem with XOR method (-1)");
		}
		
		for(int i=0;i<5;i++){
			String v=""+r.nextInt(10000);
			Predicate<String> pi=Interpreter.nand(s->s.startsWith("1"),s->s.length()!=3);
			boolean ans = !(v.startsWith("1") && v.length()!=3);
			boolean res = pi.test(v);
			if(res!=ans)
				System.out.println("problem with NAND method (-1)");
		}

		for(int i=0;i<5;i++){
			String v=""+r.nextInt(5000);
			Predicate<String> pi=Interpreter.nor(s->Integer.parseInt(s)%2==0,s->s.startsWith("4"));
			boolean ans = !(Integer.parseInt(v)%2==0 || v.startsWith("4"));
			boolean res = pi.test(v);
			if(res!=ans)
				System.out.println("problem with NOR method (-1)");
		}

		for(int i=0;i<5;i++){
			String v=""+r.nextInt(5000);
			Predicate<String> pi=Interpreter.xnor(s->Integer.parseInt(s)%2==0,s->s.startsWith("4"));
			boolean ans = Integer.parseInt(v)%2==0;
			ans^=v.startsWith("4");
			ans=!ans;
			boolean res = pi.test(v);
			if(res!=ans)
				System.out.println("problem with XNOR method (-1)");
		}
		
		System.out.println("done");
	}

}

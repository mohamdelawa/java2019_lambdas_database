
package Q1_lambdas;


public class lambdas_Q1 {
    // Q1_a
    public static void a(){
       operations_a a=(value)->System.out.printf("%d \n", value);
       a.operation_a(10);
    }
    //Q1_b
    public static void b(){
       operations_b b=String::toUpperCase;
       String s=b.operation_b("welcome to java.");
        System.out.println(s);
    }
    //Q1_c
    public static void c(){
        operations_c c =()-> {
            return "The program funy.";
        };
        String s=c.operation_c();
        System.out.println(s);
    }
    
     //Q1_d
    public static void d(){
        operations_d d=Math::sqrt;
        System.out.println(d.operation_d(7));
    }
     //Q1_e
    public static void e(){
        operations_e e=(number)-> number*number*number;
        System.out.println(e.operation_e(15));
    }
    
    public static void main(String[] args) {
        System.out.print("Q1_a ->(result) :");
        a();
        System.out.print("Q1_b ->(result) :");
        b();
        System.out.print("Q1_c ->(result) :");
        c();
        System.out.print("Q1_d ->(result) :");
        d();
        System.out.print("Q1_e ->(result) :");
        e();
    }
    interface operations_a{
        public void operation_a(int value);
    }
    interface operations_b{
        public String operation_b(String text);
    }
    interface operations_c{
       public  String operation_c();
    }
    interface operations_d{
       public  double operation_d(double number);
    }
    interface operations_e{
       public  double operation_e(double number);
    }
}

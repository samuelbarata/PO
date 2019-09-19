public class aula02{
    public static void main(String[] args){
        //ex01();
        ex02();
        //ex03();
    }

    public static void ex01(){
        pneu p = new pneu(2.2, 2.2);
        p.aumentarPressao(0.8);
        System.out.println(p.temFuro());
        System.out.println(p.pressaoAtual());
        p.aumentarPressao(0.4);
        System.out.println(p.temFuro());
        System.out.println(p.pressaoAtual());
        p.aumentarPressao(0.4);
        System.out.println(p.pressaoAtual());
    }

    public static void ex02(){
        car c1 = new car("BMW", 240);
        System.out.println(c1);
    }

    public static void ex03(){
        
    }

}
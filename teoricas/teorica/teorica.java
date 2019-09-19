public class teorica{
    public static void main(String[] args){
        //aula01();
        aula02();
    }

    //aula 17/09/2019
    public static void aula01(){
        System.out.println("Hello World!");
    }

    public static void aula02(){
        point p = new point(2,3);
        System.out.println(p);
        p.move(1, 0, 2);
        System.out.println(p);
        //animal dog = new animal();
        //System.out.println(dog);
    }

}

/**
 *  Compilar:
 *      javac HelloWorld.java
 *  Correr:
 *      java HelloWorld
 * 
 *      javac HelloWorld.java && java HelloWorld && rm HelloWorld.class
 */
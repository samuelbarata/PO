public class dog extends animal{
    private String _breed;
    
    public void bark(){
        System.out.println("woof woof");
    }

    public void waggleTail(){
        System.out.println("*waggle* *waggle*");
    }

    public dog(String nome) {
        super(nome);
        // TODO Auto-generated constructor stub
    }
    
}
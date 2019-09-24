//package teoricas.teorica;

public class animal {
    String _cor;
    String _nome;
    boolean _isAlive;
    int _birthDate;

    // gerador
    public animal(String nome){
        _nome = nome;
    }
    



    public void setColor(String cor){
        _cor = cor;
    }
    public void setColor(Boolean vida){
        _isAlive = vida;
    }
    public void setColor(int dataNascimento){
        _birthDate = dataNascimento;
    }



    public String toString(){
        return _nome;
    }


    
}
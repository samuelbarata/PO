public class caneta{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String preto = "\u001B[30m";
    public static final String vermelho = "\u001B[31m";
    public static final String verde = "\u001B[32m";
    public static final String amarelo = "\u001B[33m";
    public static final String azul = "\u001B[34m";
    public static final String roxo = "\u001B[35m";
    public static final String branco = "\u001B[37m";
    
    private int _capacidade;
    private String _cor;
    private String _marca;
    protected int _quantidadeAtual;
    private String ansiCode;

    

    public caneta(int capacidade, String cor, String marca){
        _capacidade = capacidade;
        _quantidadeAtual = _capacidade;
        _cor = cor;
        _marca = marca;
        ansiCode = "";
        if(_cor.compareToIgnoreCase("red")==0 || _cor.compareToIgnoreCase("vermelho")==0){
            ansiCode = vermelho;
        }
        if(_cor.compareToIgnoreCase("black")==0 || _cor.compareToIgnoreCase("preto")==0){
            ansiCode = preto;
        }
        if(_cor.compareToIgnoreCase("green")==0 || _cor.compareToIgnoreCase("verde")==0){
            ansiCode = verde;
        }
        if(_cor.compareToIgnoreCase("yellow")==0 || _cor.compareToIgnoreCase("amarelo")==0){
            ansiCode = amarelo;
        }
        if(_cor.compareToIgnoreCase("azul")==0 || _cor.compareToIgnoreCase("blue")==0){
            ansiCode = azul;
        }
        if(_cor.compareToIgnoreCase("roxo")==0 || _cor.compareToIgnoreCase("purple")==0){
            ansiCode = roxo;
        }
        if(_cor.compareToIgnoreCase("branco")==0 || _cor.compareToIgnoreCase("white")==0){
            ansiCode = branco;
        }
    }

    public int tintaDisponivel(){
        return _quantidadeAtual;
    }

    public void escrever(String arg){
        if(temTinta()){
            System.out.println(ansiCode + arg + ANSI_RESET);
        }
        int len = arg.length();
        if(len > _quantidadeAtual){
            _quantidadeAtual = 0;
        } else {
            _quantidadeAtual -=len;
        }

    }

    private boolean temTinta() {
        if(_quantidadeAtual==0){
            return false;
        }
        return true;
    }

    public int recarregar(int quantidade){
        int diff = 0;
        if(quantidade + _quantidadeAtual > _capacidade){
            diff = _capacidade - _quantidadeAtual;
            _quantidadeAtual = _capacidade;
        }
        else{
            _quantidadeAtual += quantidade;
        }
        return diff;
    }

    public String toString(){
        return "marca: " + _marca + "\ncor: " + _cor + "\ncapacidade: " + _capacidade + "\ntinta disponivel: " + _quantidadeAtual;
    }
}
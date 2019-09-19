public class pneu{
    private double _pressaoAtual;
    private double _pressaoRecomendada;
    private boolean _furo = false;

    public pneu(double pa, double pr){
        _pressaoAtual = pa;
        _pressaoRecomendada = pr;
        _furo = false;
    }

    public double pressaoAtual(){
        return _pressaoAtual;
    }
    public double pressaoRecomendada(){
        return _pressaoRecomendada;
    }

    public boolean estaVazio(){
        if(_pressaoRecomendada*0.8 > _pressaoAtual){
            return true;
        }
        return false;
    }

    public boolean temFuro(){
        return _furo;
    }

    private void rebenta(){
        _furo = true;
        _pressaoAtual = 0;
    }

    public void aumentarPressao(double pressao){
        if(!_furo){
            _pressaoAtual += pressao;
            if(_pressaoAtual > _pressaoRecomendada*1.5){
                rebenta();
            }
        }
    }

    public String toString(){
        return "pr: " + _pressaoRecomendada + "; pa: " + _pressaoAtual;
    }
}
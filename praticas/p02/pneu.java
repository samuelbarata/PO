public class pneu{
    /*
    ┌───────────────────────────────────┐4
    │               pneu                │<--------------------carro
    ├───────────────────────────────────┤
    │- _pressaoAtual : double           │   private
    │- _pressaoRecomendada : double     │   
    │- _furo : boolean                  │
    ├───────────────────────────────────┤
    │+ pneu(pAr:double, pRec:double)    │   public
    │+ pressaoAtual():double            │
    │+ pressaoRecomendada():double      │
    │+ estaVazio():boolean              │
    │+ aumentarPressao(dPer:double):void│
    │+ temFuro():boolbean               │
    │- rebenta():void                   │
    └───────────────────────────────────┘
    */
    private double _pressaoAtual;
    private final double _pressaoRecomendada;   //final = n pode ser alterada apos atribuicao
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
        return (_pressaoRecomendada*0.8 > _pressaoAtual);
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
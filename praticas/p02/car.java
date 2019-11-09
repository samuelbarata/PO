public class car{
    /* │─└┘├┤
    ┌──────────────────────────────────────────────────────────────────┐
    │                               car                                │
    ├──────────────────────────────────────────────────────────────────┤
    │- _quilometragem:int                                              │
    │- _vMax:int                                                       │
    │- _marca:String                                                   │
    │- _pneus:pneu[]                                                   │
    │- _nPneus:int                                                     │
    ├──────────────────────────────────────────────────────────────────┤
    │+ car(marca:String, vMax:int, p1:pneu, p2:pneu, p3:pneu, p4:pneu) │
    │+ novosPneus(p1:pneu, p2:pneu, p3:pneu, p4:pneu):void             │
    │+ getQuilometros():int                                            │
    │+ getMarca():String                                               │
    │+ pneuVazio():boolean                                             │
    │+ setQilometros(km:int):void                                      │
    │+ adicionaPneu(nPneu:pneu):boolean                                │
    └──────────────────────────────────────────────────────────────────┘
    */
    private int _quilometragem = 0;
    private int _vMax;
    private int _nPneus;
    private String _marca;
    private pneu[] _pneus;

    public car(String marca, int vMax, pneu[] pneus){
        this(marca, vMax);
        _pneus = pneus;
        _nPneus = _pneus.length;
    }

    public car(String marca, int vMax, pneu p1, pneu p2, pneu p3, pneu p4){
        _marca = marca;
        _vMax = vMax;
        _pneus[0] = p1;
        _pneus[1] = p2;
        _pneus[2] = p3;
        _pneus[3] = p4;
    }
    public car(String marca, int vMax){
        this(marca, vMax, new pneu(2.2, 2.2),new pneu(2.2, 2.2),new pneu(2.2, 2.2),new pneu(2.2, 2.2));
    }

    public boolean novosPneus(pneu p1, pneu p2, pneu p3, pneu p4){
        if((p1.pressaoRecomendada() == p2.pressaoRecomendada()) && (p3.pressaoRecomendada() == p4.pressaoRecomendada()) && (p1.pressaoRecomendada() == p3.pressaoRecomendada())){
            _pneus[0] = p1;
            _pneus[1] = p2;
            _pneus[2] = p3;
            _pneus[3] = p4;
            return true;
        }
        return false;
    }
    public int getQuilometros(){
        return _quilometragem;
    }
    public String getMarca(){
        return _marca;
    }
    public boolean pneuVazio(){
        boolean vazio = false;
        for(int i = 0; i<4 ;i++){
            vazio = _pneus[i].estaVazio() || vazio;
        }
        return vazio;
    }
    public void setQilometros(int km){
        _quilometragem = km;
    }

    public boolean adicionaPneu(pneu nPneu){
        if(_pneus[0].pressaoRecomendada() == nPneu.pressaoRecomendada()){
            _nPneus++;
            //...
            return true;
        }
        return false;
    }




    public String toString(){
        return "marca: " + _marca + "km: " + _quilometragem + "\nvmax: " + _vMax + "km/h\npenus:\n" + "p1: " + _pneus[0] + "\np2: " + _pneus[1] + "\np3: " + _pneus[2] + "\np4: " + _pneus[3];
    }
}
public class car{
    private int _quilometragem = 0;
    private int _vMax;
    private String _marca;
    private pneu[] _pneus;

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

    public String toString(){
        return "marca: " + _marca + "km: " + _quilometragem + "\nvmax: " + _vMax + "km/h\npenus:\n" + "p1: " + _pneus[0] + "\np2: " + _pneus[1] + "\np3: " + _pneus[2] + "\np4: " + _pneus[3];
    }
}
package m19.core;

public class Dvd extends Work{
    private String _director;
    private int _igac;

    protected Dvd(String titulo, String realizador, int preco, Category categoria, int igac, int exemplares){
        super(titulo, preco, categoria, exemplares);
        _director = realizador;
        _igac = igac;
    }

    protected void requestWorkId(){
        super.requestWorkId("DVD");
        System.out.println(" - " + _director + " - " + _igac);
    }
}
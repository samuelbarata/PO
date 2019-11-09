package m19.core;

public enum Category {
    FICTION("Ficção"), SCITECH("Técnica e Científica"), REFERENCE("Referência");
    
    private String _category;
    
    private Category(String category){
        _category = category;
    }
    
    public String valueOf(){
        return _category;
    }
    public String toString(){ 
        return valueOf();
    }

}
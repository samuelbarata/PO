public class point{
    private int _x;
    private int _y;
    private int _z;
    //static partilhado por todos os da classe
    private static int numberOfPoints;

    //construtores
    public point(int x, int y, int z){
        _x = x;
        _y = y;
        _z = z;
        numberOfPoints++;
    }
    public point(){
        this(0,0,0);
    }
    public point(int x, int y){
        this(x,y,0);
    }
    

    public int getX(){
        return _x;
    }
    public int getY(){
        return _y;
    }
    public int getZ(){
        return _z;
    }
    public int getPoints(){
        return numberOfPoints;
    }

    public void setX(int x){
        _x = x;
    }
    public void setY(int y){
        _y = y;
    }
    public void setZ(int z){
        _z = z;
    }

    public void move(int dx, int dy){
        _x+=dx;
        _y+=dy;
    }
    public void move(int dx, int dy, int dz){
        _x+=dx;
        _y+=dy;
        _z+=dz;
    }


    public String toString(){
        return "(" + _x + ", " + _y + ", " + _z + ")";
    }
}
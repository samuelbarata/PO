public class point{
    private int _x;
    private int _y;
    private int _z;
    //static partilhado por todos os da classe
    private static int numberOfPoints;

    //construtores
    public point(int x, int y, int z){
        _x = abs(x);
        _y = abs(y);
        _z = abs(z);
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
        _x = abs(x);
    }
    public void setY(int y){
        _y = abs(y);
    }
    public void setZ(int z){
        _z = abs(z);
    }

    public void move(int dx, int dy){
        if(_x+dx<0){
            _x = 0;
        } else {
            _x+=dx;
        }
        if(_y+dy<0){
            _y=0;
        } else {
            _y+=dy;
        }
    }
    public void move(int dx, int dy, int dz){
        _x+=dx;
        _y+=dy;
        _z+=dz;
    }

    private int abs(int x){
        if(x<0){
            return -x;
        }
        return x;
    }

    public String toString(){
        return "(" + _x + ", " + _y + ", " + _z + ")";
    }
}
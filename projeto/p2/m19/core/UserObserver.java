package m19.core;

public interface UserObserver {
   protected int _previousNumberAvailable;
   public abstract void update(int currentNumberAvailable);
}
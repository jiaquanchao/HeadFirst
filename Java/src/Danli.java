/**
 * Created by Jax on 2016/10/31.
 */
public class Danli {
    private Danli(){
        System.out.println("单例");
    }
    static Danli dl = new Danli();

    private int i = 6;

    public void setI(int i) {
        this.i = i;
    }

    protected void say() {
        System.out.println("i现在是："+i);
    }
}

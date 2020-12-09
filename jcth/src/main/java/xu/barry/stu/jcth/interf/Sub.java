package xu.barry.stu.jcth.interf;

public interface Sub extends Super{

    /**
     * Static method 'getName()' in 'xu.barry.stu.jcth.interf.Sub' cannot override instance method 'getName()'
     * in 'xu.barry.stu.jcth.interf.Super'
     * @return
     */
    default String getName(){
        return "";
    }
}

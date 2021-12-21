package me.paganidev.psolving.p4;

public class Generic<T> {

    private T genChild;
    private T genKid;

    public Generic(T genc,T genk){
        this.genChild= genc;
        this.genKid = genk;
    }

    public void print(){
        System.out.println(genChild);
        System.out.println(genKid);
    }

    public static Generic createInstance(Object genChild,Object genKid){
        return new Generic(genChild,genKid);
    }

}
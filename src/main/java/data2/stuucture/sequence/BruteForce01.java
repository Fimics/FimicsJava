package data2.stuucture.sequence;

public class BruteForce01 {

    public static int indexOf(String text,String pattern){
        if (text==null || pattern==null) return -1;
        int tlen = text.length();
        int plen = pattern.length();

        if(tlen==0 || plen==0|| tlen<plen){
            return -1;
        }

        int pi = 0,ti = 0;
        while (pi<plen&& ti<tlen) {
            if (text.charAt(ti)==pattern.charAt(pi)){
                pi++;
                ti++;
            }else {
//                ti-=pi-1;
//                ti= ti-(pi-1);
                ti= ti-pi+1;
                pi=0;
            }
        }
        return pi==plen?ti-pi:-1;
    }
}

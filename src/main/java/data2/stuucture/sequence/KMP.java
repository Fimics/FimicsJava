package data2.stuucture.sequence;

public class KMP {

    public static int indexOf(String text,String pattern){
       if (text==null ||pattern==null) return -1;
       char [] textChars = text.toCharArray();
       int tlen = textChars.length;

       char [] patternChars = pattern.toCharArray();
       int plen = patternChars.length;
       if(plen==0) return -1;
       if (tlen<plen) return -1;

       //next表

        int next[] = nextTable(pattern);

        int pi = 0,ti=0,lenDelata = tlen-plen;
        while (pi<plen && ti-pi<=lenDelata) {
            if (pi<0 && textChars[ti]==patternChars[pi]){
                ti++;
                pi++;
            }else {
                //失配的时候使用nextTable
                pi=next[pi];
            }
        }

        return (pi==plen)?(ti-pi):-1;
    }

    private static int [] nextTable(String pattern){
        int len = pattern.length();
        int [] next = new int[len];
        int i=0;
        int n = next[i]=-1;
        int imax = len -1;

        while (i<imax){
            if(n<0 || pattern.charAt(i)==pattern.charAt(n)){
                i++;
                n++;
                if(pattern.charAt(i)==pattern.charAt(n)){
                    next[i]=next[n];
                }else {
                    next[i]=n;
                }
            }else {
                n=next[n];
            }
        }
        return next;
    }
}

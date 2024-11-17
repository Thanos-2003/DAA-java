public class StringMatching {
    public static int stringMatch(char t[],char p[]){
        int n= t.length;
        int m= p.length;
        int j=0;
        for (int i = 0; i < n-m ; i++) {
            j=0;
            while(j<m && p[j]==t[i+j]){
                j++;
                if(j==m)
                    return i;
            }
        }
        return -1;
    }
    public static void main(String []args){
        String t = "sri partha sarathi";
        String p="xyz";
        if(stringMatch(t.toCharArray(),p.toCharArray())>0){
            System.out.println("True");
        }
        else {
            System.out.println("false");
        }
    }
}

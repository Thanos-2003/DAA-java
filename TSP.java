//travelling salesman problem using dynamic approach
public class TSP {
    static int[][]distance = {{0, 20, 42, 25},{20, 0 , 30, 34}, {42, 30, 0, 10}, {25, 34, 10, 0}};
    static int n = 4;
    static int allCityVisited = (1<<n)-1;
    public static int travellingSalesman(int bitMask, int currCity, int ans){
        if(bitMask == allCityVisited){
            return distance[currCity][0];
        }
        for(int city =0;city<n;city++){
            if((bitMask&(1<<city))==0){
                bitMask = bitMask | (1<<city);
                int distAns = distance[currCity][city]+travellingSalesman(bitMask,city,ans);
                ans = Math.min(ans,distAns);
            }
        }
        return ans;
    }
    public static void main(String []args) {
        int ans = Integer.MAX_VALUE;
        int shortestDistance = travellingSalesman(1 , 0, ans);
        System.out.println("The Shortest distance to visit all the cities is  "+shortestDistance);
    }
}

import java.util.ArrayList;

public class ProblemSet7B
{
    public static void main(String[] args){
        System.out.println(eratosthenes(100));
        goldbach(6);
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(5);
        a.add(0);
        
        
        b.add(6);
        b.add(0);
      
        System.out.println(add(a, b));
        
    }

    public static ArrayList<Integer> eratosthenes(int n){
        ArrayList<Integer> lst = new ArrayList<Integer>(); 
        for (int i = 0; i<=n; i++){
            lst.add(i);
        }
        for (int p = 2; p<=n;){
            for (int j = 0; j < lst.size(); j++){
                if(lst.get(j)>p){
                    if (lst.get(j)%p==0){
                        lst.remove(j);
                        j--; //To compensate for arraylist shifting
                    }
                }
            }
            boolean change = false;
            for (int k = 0; k<lst.size(); k++){
                if (lst.get(k)>p){
                    p = lst.get(k);
                    change = true;
                    break;
                }
            }
            if (!change){
                break;
            }
        }
        return lst;
    }

    public static void goldbach(int n){
        ArrayList<Integer> lst = eratosthenes(n);
        for (int i = 0; i<lst.size(); i++){
            for (int j = i+1; j<lst.size(); j++)
                if (lst.get(i) + lst.get(j) == n){
                    System.out.println("A possible combination for the number " + n + " is: " + lst.get(i) +" + " + lst.get(j) + " = " + n);
                }
        }
    }

    public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        int aIndex = a.size() -1;
        int bIndex = b.size() -1;
        int carryover = 0;
        
        while (aIndex>=0||bIndex>=0){
            int result = carryover;
            if (aIndex >= 0){
                result += a.get(aIndex);
            }
            if (bIndex >= 0){
                result += b.get(bIndex);
            }
            if (result >= 10){
                carryover = 1;
                result = result%10;
            }
            else carryover = 0; 
            lst.add(0,result);
            bIndex--;
            aIndex--;
        }
        if (carryover !=0){
            lst.add(0,carryover);
        }
        return lst;
    }
}

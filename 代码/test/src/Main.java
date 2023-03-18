import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {




        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] color = new int[n];
            for (int i = 0; i < n; i++) {
                color[i] = scanner.nextInt();
            }
            Map<Integer,Integer> m = new HashMap<>();
            int maxLen = 0;
            for (int i = 0, j = 0; i < n; ++i) {
                m.put(color[i],m.getOrDefault(color[i],0)+1);
                while(m.size() > k) {
                    if(m.put(color[j], m.get(color[j])-1) == 1) m.remove(color[j]);
                    j++;
                }
                maxLen = Math.max(maxLen,i-j+1);
            }
            System.out.println(maxLen);
        }
    }

class Solution {
    public void deleteMid(Stack<Integer> s) {
        // code here
        int n = s.size();
        int run = n/2;
        deletePerform(s,run);
    }
    void deletePerform(Stack<Integer> s, int run){
        if(run==0){
            s.pop();
            return;
        }
        int x = s.pop();
        deletePerform(s,run-1);
        s.push(x);
    }
    }

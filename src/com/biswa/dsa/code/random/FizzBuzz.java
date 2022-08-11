package com.biswa.dsa.code.random;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            StringBuilder s = new StringBuilder();

            if (i % 3 == 0) s.append("Fizz");
            if (i % 5 == 0) s.append("Buzz");
            if (s.length() == 0) s.append(i);

            ans.add(s.toString());
        }

        return ans;
    }

}

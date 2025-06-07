package com.biswa.dsa.temp;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        int[] a = {1,2,3,4};
//        System.out.println(Arrays.stream(a).sum());
//        System.out.println(Arrays.stream(a).max().getAsInt());
//        var temp = a.clone();
//        System.out.println(Arrays.toString(temp));
//        System.out.println(Arrays.toString(a));
//        a[0] = 10;
//        System.out.println(Arrays.toString(temp));
//        System.out.println(Arrays.toString(a));


//        String s = "hi hello";
//        String[] st = s.split(" ");
//        System.out.println(Arrays.toString(st));
//        System.out.println("blah"+st[1]);
//        var st = new HashSet<Integer>();
//        var ds = new DisjointSet(3);
//        st.add(1);
//        st.add(3);
//        var s = st.stream().reduce(0, (sum, e) -> sum + ds.findSet(e));
        var apple = new Apple();
        var field = apple.getClass().getDeclaredField("instanceTemp");
        field.setInt(apple, 20);

        var pairField = apple.getClass().getDeclaredField("pair");

        System.out.println(apple.getInstanceTemp());
        System.out.println(apple.getPair());

    }

    public int get(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            default -> 0;
        };
    }


}

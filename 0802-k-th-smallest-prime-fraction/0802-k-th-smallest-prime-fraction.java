class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        ArrayList<float[]> list = new ArrayList<>();
        for(int i= 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                // System.out.println(arr[i] + " / " + arr[j] + " = " + ((float) arr[i] / arr[j] ));

                float[] ele ={ ((float) arr[i] / arr[j]) , arr[i] , arr[j] };
                list.add(ele);
            }
        }

        Collections.sort(list , (a,b) -> Float.compare(a[0],b[0]));
        // for(float[] ele : list){
        //     System.out.println(Arrays.toString(ele));
        // }
        return new int[] {(int) list.get(k-1)[1] , (int) list.get(k-1)[2]};
    }
}
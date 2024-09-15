public class NextGreaterElemennt {

    public static void main(String[] args) {
        int arr[] = new int[]{6, 3, 9, 7, 8, 1};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    arr[i] = arr[j];
                    break;
                } else {
                    if (j == arr.length - 1)
                        arr[i] = -1;
                }
            }
            arr[arr.length-1]=-1;

        }
        for (int i : arr) {
            System.out.print(i + " ");
        }


    }
}

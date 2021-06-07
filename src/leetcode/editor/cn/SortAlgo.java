package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author fanzhen
 * @version 1.0
 * @date 2021/6/7
 */
public class SortAlgo {
    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 1, 7, 9, 5, 4, 3};
        SortAlgo s = new SortAlgo();
        s.quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

    public void selectSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minPos]) {
                    minPos = j;
                }
            }

            swap(a, minPos, i);
        }
    }

    public void insertsort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int tmp = a[i];
            while (j >= 0) {
                if (a[j] > tmp) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    break;
                }
            }

            a[j + 1] = tmp;
        }
    }

    public void insertsort2(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public void mergeSort(int[] a, int n) {
        mergeSort(a, 0, n - 1);
    }

    private void mergeSort(int[] a, int p, int q) {
        if (p >= q) {
            return;
        }

        int r = p + (q - p) / 2;
        mergeSort(a, p, r);
        mergeSort(a, r + 1, q);

        merge(a, p, r, q);
    }

    private void merge(int[] a, int p, int r, int q) {
        int[] tmp = new int[q - p + 1];
        int i = p;
        int j = r + 1;
        int k = 0;
        while (i <= r && j <= q) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        while (i <= r) {
            tmp[k++] = a[i++];
        }

        while (j <= q) {
            tmp[k++] = a[j++];
        }

        for (i = 0; i < q - p + 1; i++) {
            a[p + i] = tmp[i];
        }
    }

    public void quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    private void quickSort(int[] a, int p, int q) {
        if (p >= q) {
            return;
        }

        int r = partition(a, p, q);

        quickSort(a, p, r - 1);
        quickSort(a, r + 1, q);
    }

    private int partition(int[] a, int p, int q) {
        int pivot = a[q];
        int i = p;
        int j = q - 1;

        while (i <= j) {
            while (i <= j && a[i] <= pivot) {
                i++;
            }

            while (i <= j && a[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        swap(a, j, q);

        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class q14500_tetromino {

    static int[][][] block = {
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{0, 1}, {1, 0}, {2, 0}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{0, 1}, {0, 2}, {1, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 0}, {1, 1}},
            {{0, 1}, {-1, 1}, {-1, 2}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 1}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{1, 0}, {2, 0}, {1, -1}},
    };

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 19; k++) {
                    boolean ok = true;
                    int sum = a[i][j];
                    for (int l = 0; l < 3; l++) {
                        int x = i + block[k][l][0];
                        int y = j + block[k][l][1];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            sum += a[x][y];
                        } else {
                            ok = false;
                            break;
                        }
                    }
                    if (ok && ans < sum) {
                        ans = sum;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 3 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i][j + 3];
                    if (ans < temp) ans = temp;
                }
                if (i + 3 < n) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 3][j];
                    if (ans < temp) ans = temp;
                }
                if (i + 1 < n && j + 2 < m) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 1][j + 2];
                    if (ans < temp) ans = temp;
                }
                if (i + 2 < n && j + 1 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i + 1][j] + a[i + 2][j];
                    if (ans < temp) ans = temp;
                }
                if (i + 1 < n && j + 2 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 2];
                    if (ans < temp) ans = temp;
                }
                if (i + 2 < n && j - 1 >= 0) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 2][j - 1];
                    if (ans < temp) ans = temp;
                }
                if (i - 1 >= 0 && j + 2 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i - 1][j + 2];
                    if (ans < temp) ans = temp;
                }
                if (i + 2 < n && j + 1 < m) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 2][j + 1];
                    if (ans < temp) ans = temp;
                }
                if (i + 1 < n && j + 2 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j];
                    if (ans < temp) ans = temp;
                }
                if (i + 2 < n && j + 1 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 2][j + 1];
                    if (ans < temp) ans = temp;
                }
                if (i + 1 < n && j + 1 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i + 1][j] + a[i + 1][j + 1];
                    if (ans < temp) ans = temp;
                }
                if (i - 1 >= 0 && j + 2 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i - 1][j + 1] + a[i - 1][j + 2];
                    if (ans < temp) ans = temp;
                }
                if (i + 2 < n && j + 1 < m) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 2][j + 1];
                    if (ans < temp) ans = temp;
                }
                if (i + 1 < n && j + 2 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j + 2];
                    if (ans < temp) ans = temp;
                }
                if (i + 2 < n && j - 1 >= 0) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 1][j - 1] + a[i + 2][j - 1];
                    if (ans < temp) ans = temp;
                }
                if (j + 2 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i][j + 2];
                    if (i - 1 >= 0) {
                        int temp2 = temp + a[i - 1][j + 1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (i + 1 < n) {
                        int temp2 = temp + a[i + 1][j + 1];
                        if (ans < temp2) ans = temp2;
                    }
                }
                if (i + 2 < n) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 2][j];
                    if (j + 1 < m) {
                        int temp2 = temp + a[i + 1][j + 1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (j - 1 >= 0) {
                        int temp2 = temp + a[i + 1][j - 1];
                        if (ans < temp2) ans = temp2;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static String[][] blocks = {
            {"1111"},
            {"11", "11"},
            {"10", "10", "11"},
            {"10", "11", "01"},
            {"111", "010"}
    };

    public void solve2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            line = bf.readLine().split(" ");
            for (int j=0; j<m; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (String[] block : blocks) {
                    String[] b = new String[block.length];
                    System.arraycopy(block, 0, b, 0, block.length);
                    for (int mir=0; mir<2; mir++) {
                        for (int rot=0; rot<4; rot++) {
                            int cur = calc(a, b, i, j);
                            if (cur != -1 && ans < cur) {
                                ans = cur;
                            }
                            b = rotate(b);
                        }
                        b = mirror(b);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static String[] mirror(String[] b) {
        String[] ans = new String[b.length];
        for (int i=0; i<b.length; i++) {
            ans[i] = new StringBuilder(b[i]).reverse().toString();
        }
        return ans;
    }

    static String[] rotate(String[] b) {
        String[] ans = new String[b[0].length()];
        for (int j=0; j<b[0].length(); j++) {
            StringBuilder sb = new StringBuilder();
            for (int i=(int)b.length-1; i>=0; i--) {
                sb.append(b[i].charAt(j));
            }
            ans[j] = sb.toString();
        }
        return ans;
    }

    static int calc(int[][] a, String[] b, int x, int y) {
        int n = a.length;
        int m = a[0].length;
        int sum = 0;
        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b[0].length(); j++) {
                if (b[i].charAt(j) == '0') continue;
                int nx = x+i;
                int ny = y+j;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    sum += a[nx][ny];
                } else {
                    return -1;

                }
            }
        }
        return sum;
    }
}

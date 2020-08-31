package com.queenproblem;

public class SekizVezir {

    static final int n = 8;

    public static int[] tahtaKaristir(int[] vezirler) {
        for (int i = vezirler.length - 1;  i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));

            int tutucu = vezirler[i];
            vezirler[i] = vezirler[j];
            vezirler[j] = tutucu;
        }
        return vezirler;
    }
    public static boolean tahtaKontrol(int[] vezirler) {
        for (int satir = 0; satir < vezirler.length; satir++)
            if (satirKontrol(vezirler, satir))
                return true;
        return false;
    }
    public static boolean satirKontrol(int[] vezirler, int satir) {
        for (int i = 0; i < satir; i++)
            if (caprazKontrol(i, vezirler[i], satir, vezirler[satir]))
                return true;
        return false;
    }
    public static boolean caprazKontrol(int x0, int y0, int x1, int y1) {
        int dy = Math.abs(y1 - y0);
        int dx = Math.abs(x1 - x0);
        return dx == dy;
    }
    public static void yazdir(int[] vezirler) {
        for (int satir = 0; satir < n; satir++) {
            for (int sutun = 0; sutun < n; sutun++) {
                if (vezirler[satir] == sutun)
                    System.out.print(" Q ");
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] vezirler = new int[n];
        for (int i = 0; i < n; i++)
            vezirler[i] = i;
        while (tahtaKontrol(vezirler))
            tahtaKaristir(vezirler);
        yazdir(vezirler);
    }
}
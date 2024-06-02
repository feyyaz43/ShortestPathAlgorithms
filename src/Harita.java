import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Harita {

    public static int DUGUMSAYISI = 150;
    public static int DUGUMBASICIZGİSAYISI = 4;
    public static List<CizgiAgirlik> cizgiAgirlikList;
    public static int INF = 9999;

    public static void main(String[] args) {
        cizgiAgirlikList = new ArrayList<>();
        int[][] floydWarshallArray = new int[DUGUMSAYISI][DUGUMSAYISI];
        Random random = new Random();

        for (int ilkDugum = 0; ilkDugum < DUGUMSAYISI; ilkDugum++) {
            for (int cizgiSayac = 0; cizgiSayac < DUGUMBASICIZGİSAYISI; cizgiSayac++) {
                if (gecmisKontrol(ilkDugum)) {
                    ++cizgiSayac;
                } else {

                    int hedefDugum = random.nextInt(DUGUMSAYISI);

                    while (ilkDugum == hedefDugum || listedeVarmiKontrol(ilkDugum, hedefDugum)) {
                        hedefDugum = random.nextInt(DUGUMSAYISI);
                    }
                    int agirlik = 1 + random.nextInt(100);
                    cizgiAgirlikList.add(new CizgiAgirlik(ilkDugum, hedefDugum, agirlik));
                    cizgiAgirlikList.add(new CizgiAgirlik(hedefDugum, ilkDugum, agirlik));
                }
            }
        }

        for (int i = 0; i < DUGUMSAYISI; i++) {
            for (int j = 0; j < DUGUMSAYISI; j++) {
                if (i == j) {
                    floydWarshallArray[i][j] = 0;
                } else {
                    floydWarshallArray[i][j] = INF;
                }
            }
        }

        for (CizgiAgirlik cizgiAgirlik : cizgiAgirlikList) {
            floydWarshallArray[cizgiAgirlik.u][cizgiAgirlik.v] = cizgiAgirlik.w;
//            floydWarshallArray[cizgiAgirlik.v][cizgiAgirlik.u] = cizgiAgirlik.w;
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Düğüm Sayısı: " + DUGUMSAYISI);
        System.out.println("Bir Düğümün Bağlantı Sayısı: " + DUGUMBASICIZGİSAYISI);
        System.out.println("Düğümler Arası Toplam Bağlantı Sayısı: " + cizgiAgirlikList.size());
        System.out.println("-------------------------------------------------");
        dijkstraVeBellmanFordVerisiYazdir();
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        floydWarshallVerisiYazdir(floydWarshallArray);
    }

    private static boolean gecmisKontrol(int ilkDugum) {
        int sayacIlkDugum = 0;
        for (CizgiAgirlik cizgiAgirlik : cizgiAgirlikList) {
            if (cizgiAgirlik.v == ilkDugum || cizgiAgirlik.u == ilkDugum) {
                ++sayacIlkDugum;
            }
        }
        if (sayacIlkDugum >= DUGUMBASICIZGİSAYISI * 2) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean listedeVarmiKontrol(int ilkDugum, int hedefDugum) {
        for (CizgiAgirlik cizgiAgirlik : cizgiAgirlikList) {
            if ((cizgiAgirlik.u == ilkDugum && cizgiAgirlik.v == hedefDugum) || (cizgiAgirlik.u == hedefDugum && cizgiAgirlik.v == ilkDugum)) {
                return true;
            }
        }

        int sayacHedefDugum = 0;

        for (CizgiAgirlik cizgiAgirlik : cizgiAgirlikList) {
            if (cizgiAgirlik.v == hedefDugum || cizgiAgirlik.u == hedefDugum) {
                ++sayacHedefDugum;
            }
        }
        if (sayacHedefDugum >= DUGUMBASICIZGİSAYISI * 2) {
            return true;
        }
        return false;
    }

    private static void dijkstraVeBellmanFordVerisiYazdir() {
        System.out.println("---------------------Dijkstra ve Bellman-Ford Verisi----------------------------");
        cizgiAgirlikList.stream().forEach(cizgiAgirlik -> System.out.println("g.addEdge(" + cizgiAgirlik.u + ", " + cizgiAgirlik.v + ", " + cizgiAgirlik.w + ");"));
    }

    private static void floydWarshallVerisiYazdir(int[][] floydWarshallArray) {
        System.out.println("---------------------FloydWarshall Verisi----------------------------");
        for (int i = 0; i < DUGUMSAYISI; i++) {
            System.out.print("{");
            for (int j = 0; j < DUGUMSAYISI; j++) {
                if (floydWarshallArray[i][j] == INF) {
                    System.out.printf("%3s", "INF");
                } else {
                    System.out.printf("%3d", floydWarshallArray[i][j]);
                }
                if (j != DUGUMSAYISI - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("},");
        }
    }
}

class CizgiAgirlik {
    int u;
    int v;
    int w;

    public CizgiAgirlik(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "CizgiAgirlik{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}
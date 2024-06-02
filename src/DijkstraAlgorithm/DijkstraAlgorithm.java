package DijkstraAlgorithm;

import java.util.*;

public class DijkstraAlgorithm {

    public static long startTime;
    public static long endTime;

    public static int DUGUMSAYISI = 100;
    public static int DUGUMBASICIZGISAYISI = 4;
    public static List<CizgiAgirlik> cizgiAgirlikList;
    public static int INF = 999999;

    public static void main(String[] args) {

//        test-1

//        int V = 16;
//        Graph g = new Graph(V);
//
//        g.addEdge(0, 1, 7);
//        g.addEdge(0, 8, 19);
//        g.addEdge(1, 3, 16);
//        g.addEdge(1, 5, 5);
//        g.addEdge(2, 5, 22);
//        g.addEdge(2, 7, 11);
//        g.addEdge(3, 7, 12);
//        g.addEdge(4, 8, 4);
//        g.addEdge(4, 5, 23);
//        g.addEdge(4, 12, 8);
//        g.addEdge(5, 6, 13);
//        g.addEdge(6, 9, 9);
//        g.addEdge(7, 10, 15);
//        g.addEdge(7, 15, 20);
//        g.addEdge(9, 10, 26);
//        g.addEdge(9, 12, 39);
//        g.addEdge(9, 14, 4);
//        g.addEdge(10, 11, 6);
//        g.addEdge(10, 14, 8);
//        g.addEdge(11, 15, 12);
//        g.addEdge(13, 15, 18);

//        test-1 son

//        test-2

//        int V = 100;
//        Graph g = new Graph(V);
//
//        g.addEdge(0, 1, 9);
//        g.addEdge(0, 5, 23);
//        g.addEdge(0, 12, 32);
//        g.addEdge(0, 60, 53);
//        g.addEdge(1, 2, 13);
//        g.addEdge(2, 3, 5);
//        g.addEdge(3, 12, 4);
//        g.addEdge(3, 13, 13);
//        g.addEdge(3, 14, 18);
//        g.addEdge(4, 5, 14);
//        g.addEdge(4, 15, 20);
//        g.addEdge(5, 6, 25);
//        g.addEdge(6, 8, 18);
//        g.addEdge(6, 16, 57);
//        g.addEdge(7, 8, 10);
//        g.addEdge(7, 16, 45);
//        g.addEdge(8, 9, 3);
//        g.addEdge(8, 18, 19);
//        g.addEdge(8, 26, 17);
//        g.addEdge(9, 18, 16);
//        g.addEdge(9, 19, 21);
//        g.addEdge(9, 29, 28);
//        g.addEdge(10, 11, 11);
//        g.addEdge(10, 20, 24);
//        g.addEdge(10, 21, 32);
//        g.addEdge(10, 30, 13);
//        g.addEdge(11, 12, 14);
//        g.addEdge(11, 22, 17);
//        g.addEdge(11, 23, 22);
//        g.addEdge(13, 23, 27);
//        g.addEdge(14, 15, 47);
//        g.addEdge(14, 23, 21);
//        g.addEdge(14, 24, 25);
//        g.addEdge(15, 16, 11);
//        g.addEdge(15, 24, 13);
//        g.addEdge(15, 35, 19);
//        g.addEdge(17, 18, 35);
//        g.addEdge(17, 27, 14);
//        g.addEdge(17, 28, 4);
//        g.addEdge(18, 28, 13);
//        g.addEdge(19, 29, 20);
//        g.addEdge(19, 39, 24);
//        g.addEdge(19, 59, 33);
//        g.addEdge(20, 30, 17);
//        g.addEdge(20, 40, 29);
//        g.addEdge(21, 22, 21);
//        g.addEdge(21, 41, 34);
//        g.addEdge(22, 23, 16);
//        g.addEdge(22, 31, 26);
//        g.addEdge(24, 25, 28);
//        g.addEdge(24, 33, 27);
//        g.addEdge(24, 35, 21);
//        g.addEdge(25, 35, 18);
//        g.addEdge(26, 27, 21);
//        g.addEdge(26, 36, 24);
//        g.addEdge(27, 37, 23);
//        g.addEdge(27, 38, 28);
//        g.addEdge(28, 29, 29);
//        g.addEdge(29, 38, 6);
//        g.addEdge(31, 32, 13);
//        g.addEdge(32, 33, 39);
//        g.addEdge(32, 41, 15);
//        g.addEdge(33, 34, 34);
//        g.addEdge(33, 43, 27);
//        g.addEdge(33, 44, 14);
//        g.addEdge(34, 35, 29);
//        g.addEdge(34, 44, 6);
//        g.addEdge(35, 46, 19);
//        g.addEdge(36, 46, 2);
//        g.addEdge(36, 47, 7);
//        g.addEdge(37, 47, 12);
//        g.addEdge(37, 49, 27);
//        g.addEdge(39, 49, 23);
//        g.addEdge(40, 50, 20);
//        g.addEdge(40, 51, 23);
//        g.addEdge(41, 42, 8);
//        g.addEdge(42, 51, 13);
//        g.addEdge(42, 53, 33);
//        g.addEdge(43, 44, 2);
//        g.addEdge(43, 53, 13);
//        g.addEdge(44, 45, 8);
//        g.addEdge(44, 64, 47);
//        g.addEdge(45, 46, 11);
//        g.addEdge(45, 54, 13);
//        g.addEdge(47, 55, 31);
//        g.addEdge(47, 57, 10);
//        g.addEdge(47, 67, 23);
//        g.addEdge(48, 49, 15);
//        g.addEdge(48, 57, 22);
//        g.addEdge(48, 58, 37);
//        g.addEdge(49, 59, 16);
//        g.addEdge(50, 51, 16);
//        g.addEdge(50, 60, 24);
//        g.addEdge(50, 61, 17);
//        g.addEdge(52, 53, 23);
//        g.addEdge(52, 61, 45);
//        g.addEdge(53, 62, 15);
//        g.addEdge(53, 64, 31);
//        g.addEdge(53, 73, 4);
//        g.addEdge(54, 55, 19);
//        g.addEdge(55, 56, 21);
//        g.addEdge(55, 64, 40);
//        g.addEdge(56, 66, 29);
//        g.addEdge(56, 67, 5);
//        g.addEdge(58, 67, 15);
//        g.addEdge(58, 68, 30);
//        g.addEdge(58, 69, 41);
//        g.addEdge(59, 79, 11);
//        g.addEdge(60, 70, 13);
//        g.addEdge(60, 80, 41);
//        g.addEdge(61, 70, 56);
//        g.addEdge(61, 83, 57);
//        g.addEdge(62, 63, 3);
//        g.addEdge(62, 72, 19);
//        g.addEdge(63, 73, 6);
//        g.addEdge(65, 66, 13);
//        g.addEdge(65, 73, 64);
//        g.addEdge(65, 75, 31);
//        g.addEdge(65, 85, 50);
//        g.addEdge(66, 67, 15);
//        g.addEdge(66, 86, 34);
//        g.addEdge(69, 76, 57);
//        g.addEdge(69, 79, 31);
//        g.addEdge(70, 71, 27);
//        g.addEdge(71, 81, 10);
//        g.addEdge(71, 82, 13);
//        g.addEdge(71, 91, 77);
//        g.addEdge(72, 73, 35);
//        g.addEdge(72, 83, 21);
//        g.addEdge(73, 83, 8);
//        g.addEdge(74, 83, 33);
//        g.addEdge(74, 84, 22);
//        g.addEdge(74, 85, 17);
//        g.addEdge(75, 86, 14);
//        g.addEdge(76, 77, 12);
//        g.addEdge(76, 86, 9);
//        g.addEdge(77, 88, 32);
//        g.addEdge(77, 95, 79);
//        g.addEdge(78, 79, 14);
//        g.addEdge(78, 88, 13);
//        g.addEdge(78, 89, 53);
//        g.addEdge(79, 99, 87);
//        g.addEdge(80, 81, 23);
//        g.addEdge(81, 90, 38);
//        g.addEdge(82, 83, 19);
//        g.addEdge(83, 91, 49);
//        g.addEdge(83, 93, 26);
//        g.addEdge(84, 85, 49);
//        g.addEdge(84, 93, 32);
//        g.addEdge(84, 94, 18);
//        g.addEdge(85, 94, 34);
//        g.addEdge(86, 94, 20);
//        g.addEdge(87, 88, 28);
//        g.addEdge(87, 95, 62);
//        g.addEdge(88, 96, 46);
//        g.addEdge(88, 98, 39);
//        g.addEdge(89, 98, 61);
//        g.addEdge(89, 99, 5);
//        g.addEdge(90, 91, 15);
//        g.addEdge(90, 92, 43);
//        g.addEdge(92, 93, 15);
//        g.addEdge(92, 95, 40);
//        g.addEdge(95, 96, 11);
//        g.addEdge(97, 98, 12);
//        g.addEdge(97, 99, 26);

//        test-2 son


//        kodla üretilen test verisi

        cizgiAgirlikList = new ArrayList<>();
        Random random = new Random();

        for (int ilkDugum = 0; ilkDugum < DUGUMSAYISI; ilkDugum++) {
            for (int cizgiSayac = 0; cizgiSayac < DUGUMBASICIZGISAYISI; cizgiSayac++) {
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

//        for (int i = 0; i < DUGUMSAYISI; i++) {
//            for (int j = 0; j < DUGUMSAYISI; j++) {
//                if (i == j) {
//                    floydWarshallArray[i][j] = 0;
//                } else {
//                    floydWarshallArray[i][j] = INF;
//                }
//            }
//        }

//        for (CizgiAgirlik cizgiAgirlik : cizgiAgirlikList) {
//            floydWarshallArray[cizgiAgirlik.u][cizgiAgirlik.v] = cizgiAgirlik.w;
////            floydWarshallArray[cizgiAgirlik.v][cizgiAgirlik.u] = cizgiAgirlik.w;
//        }


        int V = 100;
        Graph g = new Graph(V);

        for (CizgiAgirlik cizgiAgirlik : cizgiAgirlikList) {
            g.addEdge(cizgiAgirlik.u, cizgiAgirlik.v, cizgiAgirlik.w);
        }


//        kodla üretilen test verisi son

        startTime = System.nanoTime();

        g.shortestPath(0);

        endTime = System.nanoTime();
        System.out.println("Çalışma Süresi : " + ((double) (endTime - startTime)) / 1000000);
    }

    private static boolean gecmisKontrol(int ilkDugum) {
        int sayacIlkDugum = 0;
        for (CizgiAgirlik cizgiAgirlik : cizgiAgirlikList) {
            if (cizgiAgirlik.v == ilkDugum || cizgiAgirlik.u == ilkDugum) {
                ++sayacIlkDugum;
            }
        }
        if (sayacIlkDugum >= DUGUMBASICIZGISAYISI * 2) {
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
        if (sayacHedefDugum >= DUGUMBASICIZGISAYISI * 2) {
            return true;
        }
        return false;
    }
}

class Graph {
    private int V;
    private List<List<iPair>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
//        adj.get(v).add(new iPair(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().second;

            for (iPair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new iPair(dist[v.first], v.first));
                }
            }
        }

//        System.out.println("Vertex Distance from Source");
//        for (int i = 0; i < V; i++) {
//            System.out.println(i + "\t\t" + dist[i]);
//        }
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
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




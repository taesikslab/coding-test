package datastructure.ch10_Graph;

public class Dijkstra {

    /*
    배열 D를 무한대로 초기화시킨다. 단, D[s]=0이다.
    for(k = 0; k < N; k++)
        방문 안된 각 정점 i에 대해 D[i]가 최소인 정점 minVertex를 찾고, 방문한다.
            if(w가 방문 안된 정점이면)
                if(D[minVertex] + 간선 (minVertex, w)의 가중치 < D[w])
                    D[w] = D[minVertex] + 간선 (minVertex, w)의 가중치 // 간선완화
                    previous[w] = minVertex
    */
}

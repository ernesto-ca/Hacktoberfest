#include<bits/stdc++.h>
using namespace std;

class Graph {

	int V;
	vector<int> *adjList;
	unordered_map<int, vector<pair<int, int>>> edgeList;
	unordered_map<char, vector<char>> cities;
	int INF = 1e5 + 7;

public:
	Graph(int v) {
		V = v;
		adjList = new vector<int>[V];
	}

	void addEdgeCities(char u, char v, bool bidir = true) {
		cities[u].push_back(v);
		if (bidir) {
			cities[v].push_back(u);
		}
	}

	void printCities() {
		for (auto city : cities) {
			cout << city.first << "->";
			for (auto c : city.second) {
				cout << c << ",";
			}
			cout << "\n";
		}
	}

	void addEdge(int u, int v, bool bidir = true) {
		adjList[u].push_back(v);
		if (bidir) {
			adjList[v].push_back(u);
		}
	}

	void addWeightedEdge(int u, int v, int w) {
		edgeList[u].push_back(make_pair(v, w));
	}

	void printWeightedList() {
		for (auto edge : edgeList) {
			cout << edge.first << "->";
			for (auto e : edge.second) {
				cout << e.first << " " << e.second << ", ";
			}
			cout << endl;
		}
	}

	void printList() {
		for (int i = 0; i < V; i++) {
			cout << i << "->";
			for (int node : adjList[i]) {
				cout << node << ",";
			}
			cout << "\n";
		}
	}

	void bfs(int src, int des) {
		queue<int> q;
		bool *visited = new bool[V + 1] {0};
		int *distance = new int[V + 1] {0};
		int *parent = new int[V + 1] { -1};

		q.push(src);
		visited[src] = true;

		while (!q.empty()) {
			int node = q.front();
			cout << node << " ";
			q.pop();

			for (int neighbor : adjList[node]) {
				if (!visited[neighbor]) {
					q.push(neighbor);
					visited[neighbor] = true;
					distance[neighbor] = distance[node] + 1;
					parent[neighbor] = node;
				}
			}
		}
		cout << endl;
		for (int i = 0; i < V; i++) {
			cout << i << " node having distance " << distance[i] << endl;
		}

		cout << endl;
		int temp = des;
		while (temp != -1) {
			cout << temp << "<--";
			temp = parent[temp];
		}
	}

	void dfs(int src, bool* vis) {
		if (vis[src]) return;
		vis[src] = true;
		cout << src << " ";
		for (int neighbor : adjList[src]) {
			dfs(neighbor, vis);
		}
	}

	int dfsTopSort(int pos, int src, bool* vis, vector<int>& ordering) {
		vis[src] = true;
		for (int neighbor : adjList[src]) {
			if (!vis[neighbor]) {
				pos = dfsTopSort(pos, neighbor, vis, ordering);
			}
		}
		ordering[pos] = src;
		return pos - 1;
	}

	vector<int> topSort() {
		bool* vis = new bool[V + 1] {0};
		vector<int> ordering (V, 0);
		int i = V - 1;
		for (int j = 0; j < V; j++) {
			if (!vis[j]) {
				i = dfsTopSort(i, j, vis, ordering);

			}
		}
		// for (int n : ordering) {
		// 	cout << n << ",";
		// }
		// cout << endl;
		return ordering;
	}

	void dagShortestPath(int start) {
		vector<int> topsort = topSort();
		vector<int> dist (V, INF);
		dist[start] = 0;

		for (int i = 0; i < V; i++) {
			int nodeIdx = topsort[i];
			if (dist[nodeIdx] != INF) {
				for (auto edges : edgeList[nodeIdx]) {
					int newDist = dist[nodeIdx] + edges.second;
					dist[edges.first] = min(dist[edges.first], newDist);
				}
			}
		}

		for (int i = 0; i < V; i++) {
			cout << "node " << i << " having distance " << dist[i] << endl;
		}
	}

	void dijkstra(int start) {
		vector<int> dist (V, INF);
		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
		dist[start] = 0;
		pq.push(make_pair(start, 0));
		while (!pq.empty()) {
			int index, minVal;
			tie(index, minVal) = pq.top();
			pq.pop();
			for (auto edge : edgeList[index]) {
				int newDist = dist[index] + edge.second;
				if (newDist < dist[edge.first]) {
					dist[edge.first] = newDist;
					pq.push(make_pair(edge.first, newDist));
				}
			}
		}

		for (int i = 0; i < V; i++) {
			cout << "node " << i << " having distance " << dist[i] << endl;
		}
	}

};

int main() {

	pair<int, int> edges[] = {{0, 1}, {1, 2}, {0, 4}, {4, 2}, {2, 5}, {2, 3}, {4, 3}, {3, 5}};
	tuple<int, int, int> weightedEdges[] = {{0, 1, 3}, {0, 4, 10}, {1, 2, 5}, {4, 2, -4}, {4, 3, 11}, {2, 5, 5}, {2, 3, 6}, {3, 5, 2}};
	pair<char, char> cities[] = {{'K', 'J'}, {'K', 'S'}, {'K', 'B'}, {'K', 'M'}, {'J', 'M'}, {'J', 'D'}, {'D', 'S'}};
	tuple<int, int, int> edgesDijkstra[] = {{0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {1, 3, 1}, {2, 3, 5}, {3, 4, 3}};

	Graph g(5);
	// for (int u = 0; u < 36; u++) {
	// 	for (int dice = 1; dice <= 6; dice++) {
	// 		int v = u + dice + board[u + dice];
	// 		g.addEdge(u, v, false);
	// 	}
	// }

	// for (auto e : edges) {
	// 	g.addEdge(e.first, e.second, false);
	// }

	for (auto e : edgesDijkstra) {
		int u = get<0>(e);
		int v = get<1>(e);
		g.addEdge(u, v, false);
	}


	// g.printList();
	// cout << "----------" << endl;

	for (auto e : edgesDijkstra) {
		int u = get<0>(e);
		int v = get<1>(e);
		int w = get<2>(e);
		g.addWeightedEdge(u, v, w);
	}

	// g.printWeightedList();

	// g.printCities();
	// g.bfs(0, 5);
	// bool vis[6] {0};
	// g.dfs(0, vis);
	// g.topSort();
	// g.dagShortestPath(0);
	g.dijkstra(0);


}
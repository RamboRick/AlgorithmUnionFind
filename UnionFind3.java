package unionfind;
//根据size来union
public class UnionFind3 {
	private int count;
	private int[] parent;
	private int[] sz;
	
	public UnionFind3(int count){
		parent = new int[count];
		sz = new int [count];
		this.count = count;
		for(int i = 0; i <count; i++){
			parent[i] = i;
			sz[i] = 1;
		}
	}
	
	private int find(int p){
		assert(p>=0&& p<count);
		while(p != parent[p]){
			p = parent[p];
		}
		return p;
	}
	
	public boolean isConnected(int p, int q){
		return find(p) == find(q);
	}
	
	public void unionElements(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot){
			return;
		}
		
		if(sz[pRoot] < sz[qRoot]){
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}else {
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
		
	}
}


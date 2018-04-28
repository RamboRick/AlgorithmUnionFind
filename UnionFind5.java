package unionfind;
//path compression 路径压缩 针对find
public class UnionFind5 {
	private int count;
	private int[] parent;
	private int[] rank;
	
	public UnionFind5(int count){
		parent = new int[count];
		rank = new int [count];
		this.count = count;
		for(int i = 0; i <count; i++){
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	private int find(int p){
		assert(p>=0&& p<count);
		//路径压缩方法1 跳两步
//		while(p != parent[p]){
//			p = parent[parent[p]];
//		}
//		return p;
		//路径压缩方法2 递归解决
		if(p != parent[p]){
			parent[p] = find(parent[p]);
		}
		return parent[p];
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
		
		if(rank[pRoot] < rank[qRoot]){
			parent[pRoot] = qRoot;
		}else if(rank[qRoot] < rank[pRoot]){
			parent[qRoot] = pRoot;
		}else{ //rank[qRoot] = rank[pRoot]
			parent[pRoot] = qRoot;
			rank[qRoot] += 1;
		}
		
	}
}




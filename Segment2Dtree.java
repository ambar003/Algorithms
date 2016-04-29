
public class Segment2Dtree {
	static int MAX=506;
static int p[][];
public static void main(String[] args) {
	int n=5,m=5;
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			
		}
	}
}
static class Point{
	int x,y,mx;
	public Point() {
	}
	public Point(int x,int y,int mx){
		this.x=x;
		this.y=y;
		this.mx=mx;
	}
}
static class Segment2D{
	Point[] T=new Point[2*MAX*MAX];
	int n,m;
	void Init(int n,int m){
		this.n=n;
		this.m=m;
		Build(1,1,1,n,m);
	}
	private Point Build(int node, int a1, int b1, int a2, int b2) {
	if(a1>a2||b1>b2)
		return def();
	if(a1==a2&&b1==b2)
		return T[node]=new Point(a1,b1,p[a1][b1]);
	T[node]=def();
	T[node]=maxNode(T[node],Build(4*node-2,a1,b1,(a1+a2)/2,(b1+b2)/2));
	T[node]=maxNode(T[node],Build(4*node-1,(a1+a2)/2 + 1,b1,a2,(b1+b2)/2));
	T[node]=maxNode(T[node],Build(4*node,a1,(b1+b2)/2 + 1,(a1+a2)/2,b2));
	T[node]=maxNode(T[node],Build(4*node+1,(a1+a2)/2 + 1,(b1+b2)/2+1,a2,b2));
	return T[node];
	}
	private Point maxNode(Point a, Point b) {
		if(a.mx>b.mx)
			return a;
		else
			return b;
	}
	Point query(int node,int a1,int b1,int a2,int b2,int x1,int y1,int x2,int y2){
		if(x1>a2||y1>b2||x2<a1||y2<b1||a1>a2||b1>b2)
			return def();
		if(x1<=a1&&y1<=b1&&a2<=x2&&b2<=y2)
			return T[node];
		Point mx=def();
		mx=maxNode(mx,query(4*node-2,a1,b1,(a1+a2)/2,(b1+b2)/2,x1,y1,x2,y2));
		mx=maxNode(mx,query(4*node-1,(a1+a2)/2+1,b1,a2,(b1+b2)/2,x1,y1,x2,y2));
		mx=maxNode(mx,query(4*node,a1,(b1+b2)/2 + 1,(a1+a2)/2,b2,x1,y1,x2,y2));
		mx=maxNode(mx,query(4*node+1,(a1+a2)/2 + 1,(b1+b2)/2+1,a2,b2,x1,y1,x2,y2));
		return mx;
	}
	Point query(int x1,int y1,int x2,int y2){
		return query(1,1,1,n,m,x1,y1,x2,y2);
	}
	private Point def() {
		return new Point(0,0,-Integer.MAX_VALUE);
	}
	
}
}

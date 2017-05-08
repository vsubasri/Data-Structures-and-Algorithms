/*
 * Name: Valli Subasri
 * Student Number: 250697148
 */

public class UandF {

	private int [] p, r;
	private boolean fin = false;
	
	public UandF(int n) {
		p = new int[n];
		r = new int [n];
	}
	
	public void make_set(int i) {
		p[i]=i;
	}
	
	public void union_sets(int i, int j) {
		i = find_set(i);
		j = find_set(j);
		
		if (r[i]>r[j]) {
			p[j]=p[i];
		}
		else if (r[i]<r[j]) {
			p[i]=p[j];
		}
		else {
			p[j]=p[i];
			r[i]++;
		}
	}
	
	public int find_set(int x) {
		if (fin==false) {
			if (p[x]!= x) {
				return (p[x]=find_set(p[x]));
			}
			else {
				return x;
			}
		}
		else {
			return p[x];
		}
	}
	
	public int final_sets() {	
		for (int i=1; i<p.length; i++) {
			if(p[i]!=0)find_set(i);
		}

		int count=1;

		for (int i=1; i<p.length; i++) {
			if (p[i]==i) {
				p[i]=count++;
				r[i]=1;
			}
			else {
				r[i]=0;
			}
		}

		for (int i=1; i<p.length; i++) {
			if (r[i]==0 && p[i]>0) {
				p[i]=p[p[i]];
			}
		}

		fin=true;

		return count-1;
	}
}

package spractice.model;

public class Domain implements Comparable<Domain> {
	private String fields[];

	public Domain(String domain) {
		fields = domain.split("\\.");
		System.out.println(this);
	}

	public String[] get() {
		return fields;
	}

	@Override
	public int compareTo(Domain domain) {
		String fields[] = domain.get();
		int m = fields.length;
		int n = this.fields.length;
		int N = Math.min(m, n);
		System.out.println(this + " - " + domain + "--- " + N);
		for (int i = N - 1; i >= 0; i--) {
			System.out.println(fields[m-1] + " " + this.fields[n-1]);
			int comp = this.fields[--n].compareTo(fields[--m]);
			if (comp == 0) {
				continue;
			}
			return comp > 0 ? 1 : -1;
		}
		return this.fields.length - fields.length;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < fields.length - 1; i++) {
			buffer.append(fields[i] + ".");
		}
		buffer.append(fields[fields.length - 1]);
		return buffer.toString();
	}
}

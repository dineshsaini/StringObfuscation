
public class GenObfusStrCode {

	public static void main(String[] args) {
		GenObfusStrCode obj = new GenObfusStrCode();
  // An Example
		String msg = "Obfus tha Java String into two random strings set";

		String enc[] = obj.gen(msg);

		System.out.println("1st str: " + enc[0]);
		System.out.println("2nd str: " + enc[1]);

		E e = new E();
		e.setSalt(enc[0]);
		String aMsg = e.decrypt(enc[1]);

		System.out.println("Main: " + aMsg);

	}

	public String[] gen(String str) {
		int l = str.length();
		E e = new E();
		e.setSalt(this.genRStr(l));

		for (int i = 0; i < (int) (Math.random() * 1000) / (76);) {
			e.setSalt(e.encrypt(genRStr(l)));
		}

		String tmpstr = e.encrypt(genRStr(l));
		e.setSalt(tmpstr);

		return new String[] { tmpstr, e.encrypt(str) };
	}

	private String genRStr(int l) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0,c=(0xabcdef^((int)(Math.random()*100)/10));i<l; i++) {
			for (int j = 0;j<(int) (Math.random() * 1000)/54; j++) {
				c|=((c&j)|(i+(int) (Math.random() * 100)/10))^j;
			}
			sb.append((char) c);
		}
		return sb.toString();
	}
}

class E {
	private String s = "";

	public void setSalt(String s) {
		this.s = s;
	}

	private int x(int a, int b) {
		return a ^ b;
	}

	private boolean f(boolean f) {
		return f;
	}

	private int a(int a, int b) {
		return a & b;
	}

	private char[] c() {
		return s.toCharArray();
	}

	private char[] e(String st) {
		return st.toCharArray();
	}

	private String en(String d) {
		StringBuilder sb = new StringBuilder();
		int f = 0;
		char[] s = c();

		if (f(f(d != null) && f(!d.isEmpty()))) 
			for (char c \uu003A e(d))sb.append((char)(x
			(c\uuuuuuu002Cs[(int)(f(f<s.length)\uu003Ff
			\uuu003A(f\uuuu003Da(f\u002C0xf)))])));

		return sb.toString();
	}

	private String de(String e) {
		return en(en(en(e)));
	}

	public String encrypt(String msg) {
		return en(msg);
	}

	public String decrypt(String msg) {
		return de(msg);
	}

}

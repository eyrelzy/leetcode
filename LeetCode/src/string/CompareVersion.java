package string;

public class CompareVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersion cv = new CompareVersion();
		String version1 = "1.0";
		String version2 = "1";
		// String i="1";
		// System.out.println(Integer.parseInt(i));

		System.out.println(cv.compareVersion(version1, version2));
	}

	public int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");
		int len1 = str1.length, len2 = str2.length;
		int i = 0;
		while (i < len1 && i < len2) {
			int i1 = Integer.parseInt(str1[i]);
			int i2 = Integer.parseInt(str2[i]);
			if (i1 > i2) {
				return 1;
			} else if (i1 < i2) {
				return -1;
			} else {
			}
			i++;
		}
		while (i < len1) {
			int i1 = Integer.parseInt(str1[i]);
			if (i1 == 0) {

			} else {
				return 1;
			}
			i++;
		}
		while (i < len2) {
			int i2 = Integer.parseInt(str2[i]);
			if (i2 == 0) {

			} else {
				return -1;
			}
			i++;
		}
		return 0;
	}

}

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SqlParseTest {

	/**
	 * 测试UTF-8字符集英文、中文等都分表占用的字节数
	 * 英文字符占用一个字节、中文字符占用3个，部分中文会占用4个字节
	 */
	@Test
	public void test() {
		String str = "燈";
		System.out.println(str.getBytes(StandardCharsets.UTF_8).length);
	}

	/**
	 * 测试验证ascii码对应的byte
	 */
	@Test
	public void test2() {
		String pattern = "^[0-9a-zA-Z]+\\s[0-9a-zA-Z]+\\s[0-9a-zA-Z]+$";
		String pattern2 = "^[0-9]+\\|[0-9]+\\|[0-9]*\\|[^\\|]*$";
		
		
		System.out.println("14170099080030395001 AB52D7CAF等BFBACD27D6B10080D4D50B2 235F791E806C349FAD71162DEDAE2FBC".matches(pattern));
		System.out.println("13732900182|310000494165||||".matches(pattern2));
		System.out.println("123456|122323||".matches(pattern2));
		System.out.println("123456|||".matches(pattern2));
		System.out.println("123456|||邓慧智".matches(pattern2));
		System.out.println("123456|aaa||邓慧智".matches(pattern2));
		System.out.println("123456|111|aaa|邓慧智".matches(pattern2));
		System.out.println("123456|111|222|邓慧智".matches(pattern2));
	}
	
	@Test
	public void test222 () throws IOException {
		String aaa = "123456\n"
				+ "abcd123\n"
				+ "1234124\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(aaa.getBytes()), "UTF-8"));
		List list = new ArrayList();
		String str = null;
		while ((str = br.readLine()) != null) {
			if (str.trim().equals("")) {
				continue;
			}
			list.add(str.trim());
		}
		System.out.println(list.size());
	}
}

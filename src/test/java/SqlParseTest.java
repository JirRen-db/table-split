import static org.junit.Assert.*;

import java.nio.charset.StandardCharsets;

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
		byte a = 127;
		System.out.println(a);
	}
}

import static org.junit.Assert.*;

import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class SqlParseTest {

	/**
	 * ����UTF-8�ַ���Ӣ�ġ����ĵȶ��ֱ�ռ�õ��ֽ���
	 * Ӣ���ַ�ռ��һ���ֽڡ������ַ�ռ��3�����������Ļ�ռ��4���ֽ�
	 */
	@Test
	public void test() {
		String str = "��";
		System.out.println(str.getBytes(StandardCharsets.UTF_8).length);
	}

	/**
	 * ������֤ascii���Ӧ��byte
	 */
	@Test
	public void test2() {
		byte a = 127;
		System.out.println(a);
	}
}

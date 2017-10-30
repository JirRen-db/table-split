import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ������������ͨ���������Ӵ�֮������Ӵ�����ַ�����Ϊ�������ֽ��к�������
 * 
 * @author steve
 *
 */
public class StringNumberIncreaseHelper {
	
	
	public void test() {
		String begin = "898600C4101200000001";
		String end = "898600C4101200000249";
		if(begin.length() != end.length()) {
			return;
		}
		int length = end.length();
		String maxSub = "";
		int maxIndex = 0;
		for(int i = 0; i < length - 1; i++) {
			String subStr  = begin.substring(0, i);
			boolean hasSub = end.startsWith(subStr);
			System.out.println("i is " + i + "" + hasSub);
			if(hasSub) {
				maxSub = subStr;
				maxIndex = i;
			}
		}
		System.out.println(maxSub);
		System.out.println(maxIndex);
		System.out.println(begin.substring(maxIndex, begin.length()));
		System.out.println(end.substring(maxIndex, begin.length()));
		Long beginNum = new Long(begin.substring(maxIndex, begin.length()));
		Long endNum = new Long(end.substring(maxIndex, begin.length()));
		int maxSize = length - maxIndex;
		List<String> iccidList = new ArrayList<String>();
		for(Long i = beginNum; i <= endNum; i++) {
			iccidList.add(maxSub + addZero(i.toString(), maxSize));
		}
		
		for(int i = 0; i < iccidList.size() - 1; i++) {
			assert(iccidList.get(i).length() == length);//����ÿ��������icc_id���ȶ���������ַ�������һ��
		}
		assert(iccidList.size() == endNum - beginNum + 1);
		System.out.println("iccid size is " + iccidList.size());
	}
	
	@Test
	public void test2() {
		String begin = "898600C4101200000001";
		String end = "898600C4101200000249";
		List<String> iccIdList = getIccIdList(begin, end);
		System.out.println("iccid size is " + iccIdList.size());
	}
	
	/**
	 * ͨ����ʼ�Ŷκͽ����Ŷν��кŶ�����
	 * 
	 * @param origin
	 * @param maxSize
	 * @return List<String> ���ɵĺ���
	 */
	public static String addZero(String origin, int maxSize) {
		if(maxSize > origin.length()) {
			int zeroSize = maxSize - origin.length();
			String tem = "";
			for(int i = 0; i < zeroSize; i++) {
				tem = tem + "0";
			}
			return tem + origin;			
		} else {
			return origin;
		}
	}
	
	public static List<String> getIccIdList(String beginStr, String endStr) {
		assert(beginStr.length() == endStr.length());
		assert(beginStr.length() > 0);
		int length = beginStr.length();
		String maxSub = "";
		int maxIndex = 0;
		for(int i = 0; i < length - 1; i++) {
			String subStr  = beginStr.substring(0, i);
			boolean hasSub = endStr.startsWith(subStr);
			System.out.println("i is " + i + "" + hasSub);
			if(hasSub) {
				maxSub = subStr;
				maxIndex = i;
			}
		}
//		System.out.println(maxSub);
//		System.out.println(maxIndex);
//		System.out.println(beginStr.substring(maxIndex, beginStr.length()));
//		System.out.println(endStr.substring(maxIndex, beginStr.length()));
		Long beginNum = new Long(beginStr.substring(maxIndex, beginStr.length()));
		Long endNum = new Long(endStr.substring(maxIndex, endStr.length()));
		int maxSize = length - maxIndex;
		List<String> iccidList = new ArrayList<String>();
		for(Long i = beginNum; i <= endNum; i++) {
			iccidList.add(maxSub + addZero(i.toString(), maxSize));
		}
		
		for(int i = 0; i < iccidList.size() - 1; i++) {
			assert(iccidList.get(i).length() == length);//����ÿ��������icc_id���ȶ���������ַ�������һ��
		}
		assert(iccidList.size() == endNum - beginNum + 1);
		System.out.println("iccid size is " + iccidList.size());
		return iccidList;
	}
}

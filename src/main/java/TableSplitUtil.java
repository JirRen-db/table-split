import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author steve
 *
 */
public class TableSplitUtil {

	/**
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return a tuple contains of strings like "201708,201709,201710"
	 * @throws Exception if endDate is smaller than beginDate
	 */
	public static String[] getSplitDateStrings(Date beginDate, Date endDate) throws Exception {
		if (beginDate != null && endDate != null) {
			List<Integer> list = new ArrayList<Integer>();
			Calendar bCal = Calendar.getInstance();
			Calendar eCal = Calendar.getInstance();
			bCal.setTime(beginDate);
			eCal.setTime(endDate);
			if (eCal.compareTo(bCal) < 0) {
				throw new Exception("endDate is smaller than beginDate, not allow!");
			}
			while (eCal.compareTo(bCal) >= 0
					|| (eCal.compareTo(bCal) < 0 && (eCal.get(Calendar.YEAR) == bCal.get(Calendar.YEAR)
							&& (eCal.get(Calendar.MONTH) == bCal.get(Calendar.MONTH))))) {
				list.add(new Integer(bCal.get(Calendar.YEAR) * 100 + bCal.get(Calendar.MONTH) + 1));
				bCal.add(Calendar.MONTH, 1);
			}
			if (list != null && list.size() > 0) {
				String[] ids = new String[list.size()];
				for (int i = 0; i < list.size(); i++) {
					ids[i] = (list.get(i) != null) ? list.get(i).toString() : null;
				}
				return ids;
			}
		}
		return null;
	}
}

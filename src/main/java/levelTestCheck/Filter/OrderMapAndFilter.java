package levelTestCheck.Filter;

import java.util.Map;

@FunctionalInterface
public interface OrderMapAndFilter {
	public Map<Integer, Object> processingBy (Map<Integer, Object> list, int key, 
										String city);
}

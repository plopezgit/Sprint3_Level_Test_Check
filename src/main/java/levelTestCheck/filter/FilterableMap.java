package levelTestCheck.filter;

import java.util.List;
import java.util.Map;

import levelTestCheck.entity.Item;

@FunctionalInterface
public interface FilterableMap<T> {
	public List<T> filterBy (Map<T, T> t, T t2);
}

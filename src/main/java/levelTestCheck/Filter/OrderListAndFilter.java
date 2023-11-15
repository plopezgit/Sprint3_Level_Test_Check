package levelTestCheck.Filter;

import java.util.List;

import levelTestCheck.entity.Item;

@FunctionalInterface
public interface OrderListAndFilter {
	public List<Item> processingBy (List<Item> list, int index, 
										int price, String type);
}

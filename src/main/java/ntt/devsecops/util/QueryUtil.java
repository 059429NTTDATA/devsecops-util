package ntt.devsecops.util;

import java.util.Map;

import jakarta.persistence.Query;

public class QueryUtil {
	
	public static void setQueryParams(Query query, Map<String, Object> condition) {
		for (Map.Entry<String, Object> entry : condition.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
}

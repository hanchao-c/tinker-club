package org.tinker.asset.page;

import java.io.Serializable;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface PageRequest extends Serializable {
	
	int getPageSize();

	int getOffset();
	
	Collection<Sort> getSorts();
	
	default int getPageNumber() {
		return getOffset() / getPageSize() + 1;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Sort implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private String sortColumn;
		private SortSequence sortSequence;
		
		@Override
		public String toString() {
			StringBuilder stringBuilder = new StringBuilder(sortColumn.length() + 5);
			return stringBuilder
					.append(sortColumn)
					.append(" ")
					.append(sortSequence.name())
					.toString();
		}
	}
	
	public static enum SortSequence {
		
		ASC,
		DESC;

		public static SortSequence of(String sequence) {
			SortSequence[] sequences = SortSequence.values();
			for (SortSequence sortSequence : sequences) {
				if(StringUtils.equalsIgnoreCase(sortSequence.name(), sequence)) {
					return sortSequence;
				}
			}
			throw new NoSuchElementException("枚举类型不存在");
		}
	}
	
}

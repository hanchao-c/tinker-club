package org.tinker.asset.page;

import java.util.List;

import org.tinker.asset.Foo;
import org.tinker.asset.FooMapping;
import org.tinker.asset.util.JacksonUtil;

import com.google.common.collect.Lists;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PagedListTest extends TestCase {

	public void testConvert() {
		List<Foo> foos = Lists.newArrayList(Foo.make(), Foo.make());
		SimplePageResult<Foo> pagedList = new SimplePageResult<>(foos.size(), foos);
		Page<FooMapping> convertedList = pagedList.mapTo(FooMapping.class);
		log.info(JacksonUtil.toJSONString(convertedList));
		List<FooMapping> list = convertedList.getContent();
		log.info(list.toString());
	}

}

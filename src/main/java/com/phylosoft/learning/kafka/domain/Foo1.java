package com.phylosoft.learning.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foo1 {

	private String foo;

	@Override
	public String toString() {
		return "Foo1 [foo=" + this.foo + "]";
	}

}

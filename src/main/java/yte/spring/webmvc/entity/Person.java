package yte.spring.webmvc.entity;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

	private String name;
	private String surname;
	private Long age;
}

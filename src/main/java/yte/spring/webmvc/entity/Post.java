package yte.spring.webmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	private Long id;
	private Long userId;
	private String title;
	private String body;

}
